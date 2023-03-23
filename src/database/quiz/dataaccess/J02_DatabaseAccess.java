package database.quiz.dataaccess;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import database.quiz.datamodel.J02_GameUser;

public class J02_DatabaseAccess {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static String id = "testuser";
	private static String password = "1234";

	// SELECT를 하기 싫으면 애초에 여기에 Integer가 아니라 Item을 담으면 된다. (이게 맞는 방식임 - 이래서 설계를 잘해야 함..)
	private static List<Integer> boxItems = new ArrayList<>(); // 뽑기 배열



	// 드라이버 호출은 프로그램 실행시 최초 1번이면 충분하다.
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// -- 아이템 뽑기 배열 생성 ---
		// 최초의 DB Access 발생시 아이템 뽑기 배열 생성
		try (
				Connection conn = DriverManager.getConnection(url, id, password);
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT * FROM item");
				ResultSet rs = pstmt.executeQuery();
				){
			while (rs.next()) {
				// 확률만큼 뽑기 배열에 추가하여 확률 생성
				int prob = Math.round(rs.getFloat("probability") * 100); // 확률만큼 반복	

				for (int i = 0; i < prob; ++i) {
					boxItems.add(rs.getInt("item_id")); // 1이 30개, 2가 30개, 3이 15개, 4가 15개, 5가 10개 추가 될 것이다.
				}
			}
			Collections.shuffle(boxItems);
			System.out.println(boxItems);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}






	// ---- 박스 오픈 ----
	public static void openBox(J02_GameUser user) {
		int gold = user.getGold();


		// 여기서 걸리기 때문에 savepoint를 쓸일이 별로 없다.
		if (gold < 1000) {
			System.out.println("소지금이 부족합니다...");
			return;
		}

		// 1. DB의 소지금을 감소하고
		// 2. 아이템 목록에 추가하고
		String reduceGold = "UPDATE gameuser SET Gold = gold - 1000 WHERE user_num = ?";
		String addOwnItem = "INSERT INTO ownitem VALUES "
				+ "(ownitem_seq.nextval,?,?,sysdate)";
		String getItem = "SELECT * FROM item WHERE item_id = ?";

		try(
				Connection conn = DriverManager.getConnection(url, id, password);
				PreparedStatement pstmt1 = conn.prepareStatement(reduceGold);
				PreparedStatement pstmt2 = conn.prepareStatement(addOwnItem);
				PreparedStatement pstmt3 = conn.prepareStatement(getItem)
				){
			// 확률대로 뽑은 아이템의 번호
			int item_id = boxItems.get((int)(Math.random() * boxItems.size()));

			// ? 채우기 (물음표 채우기)
			pstmt1.setInt(1, user.getUser_num());
			pstmt2.setString(1, user.getUser_id());
			pstmt2.setInt(2, item_id);
			pstmt3.setInt(1, item_id); // 뽑은 아이템의 정보를 뽑아 올 수 있따.

			// 다 만든 쿼리문 실행하여 DB에 반영하기
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();

			// 뽑은 아이템 정보 가져와서 출력해주기
			ResultSet rs = pstmt3.executeQuery();
			rs.next();
			System.out.printf("[%s]님이 [%s]를 뽑으셨습니다.\n"
					, user.getUser_id(), rs.getString("item_name")); // 뽑은 아이템 확인
			user.setGold(gold - 1000);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// ---- 박스 오픈 ----




	// GameUser타입으로 리턴
	public static J02_GameUser login(String userId, String userPassword) {
		String sql = "SELECT * FROM gameuser WHERE user_id = ?";

		try (
				Connection conn = DriverManager.getConnection(url, id, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, userId);

			try (ResultSet rs = pstmt.executeQuery()){
				// 다음께 있으면 게임유저 유저는 null로 만들고
				// 다음께 있으면 아래처럼 넣어라.				
				J02_GameUser user = null;

				if (rs.next()) {
					user = new J02_GameUser(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getInt(4)
							);
				}

				// userId의 사용자가 없어서 조회가 안된 경우
				if (user == null) {
					return null;
				} else {
					if (user.getUser_password().equals(userPassword)) {
						// 비밀번호 맞춰서 로그인에 성공하는 경우 정보를 리턴
						return user;
					} else {
						// 비밀번호 틀려서 로그인 실패하는 경우 null을 리턴
						return null;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// -- 숙제 : 목록보기(미완성)
	public static void ItemBox(String userId, String userPassword) {
		String sql = "SELECT * FROM ownItem INNER JOIN Item USING (item_id) WHERE user_id = ?";
		J02_GameUser user = new J02_GameUser(null, userId, userPassword, null);

		try (
				Connection conn = DriverManager.getConnection(url, id, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, userId);

			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()){
					System.out.printf("%d\t%s\t%d\t%s\t%s\n",
							rs.getInt("own_id"),
							rs.getString("user_id"),
							rs.getInt("item_id"),
							rs.getString("item_name"),
							rs.getString("own_date"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}