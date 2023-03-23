package database.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J02_SelectQuiz {

	/*
	 	testuser 계정에 테이블을 아무거나(컬럼 4개 이상) 추가하고 데이터를 추가한 뒤
	 	자바에서 Select로 조회한 결과를 콘솔에 출력해보세요
	 */

	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

	public static void main(String[] args) {

		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 완료.");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾지 못했습니다.");
		}

		String keyword = "%레시피%";
		String sql = "SELECT * FROM books WHERE book_name LIKE ?"; // = : 완전히 일치하는...

		try (
				Connection conn = DriverManager.getConnection(url, "testuser", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){

			pstmt.setString(1, keyword);

			try (ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					System.out.printf("%d\t%-16s\t%d\t%d\t%s\n",
							rs.getInt("book_id"),
							rs.getString("book_name"),
							rs.getInt("book_price"),
							rs.getInt("area_id"),
							rs.getString("floor_number"));					
				}
				rs.close();
			}
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
