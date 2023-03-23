package gui.quiz.register.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;

// 회원가입 관련 작업으로 인한 DB 접근에 대한 코드를 모아놓은 곳
// DAO : 관련 작업으로 인한 DB 접근에 대한 코드를 모아놓는 곳 (작업단위로 모아놓는다)
public class RegisterDAO {

	public boolean checkDuplicateEmail(String email) {
		String sql = "SELECT count(*) FROM membership WHERE mem_email = ?";
		int count = 0;
		if(count > 0) {
			System.out.println("중복 이메일 입니다!");
			return true;
		} else {
			System.out.println("중복 이메일이 아니므로 사용할 수 있습니다!");
			return false;
		}
	}

	public boolean checkDuplicateID(String id) {
		// ID를 가지고 갯수를 세서 테이블에 ID가 있으면 중복
		String sql = "SELECT count(*) FROM membership WHERE mem_id = ?";
		int count = 0; // 중복된 아이디가 0개

		if (count > 0){ // 중복된 아이디의 개수가 1개이상이면 중복된 아이디가 존재
			System.out.println("중복 아이디 입니다!");
			return true;
		} else {
			System.out.println("중복 아이디가 아니므로 사용할 수 있습니다!");
			return false;
		}

	}

	public int registerMember(gui.quiz.register.model.Member m) {

		String sql = "INSERT INTO membership VALUES (?,?,?,?,?,?,?,?,?,?)";
		try(
				Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, m.getMem_id());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getMem_name());
			pstmt.setInt(4, m.getAge());
			//			pstmt.setInt(5, m.getBirthday());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone_number());
			pstmt.setString(8, m.getInterest1());
			pstmt.setString(9, m.getInterest2());
			pstmt.setString(10, m.getInterest3());


			return pstmt.executeUpdate();	
		} catch (SQLException e) {
			return -1;
		}

	}

	public void open() {
		JFrame f = new JFrame();

		f.setVisible(true); // 해당 프레임을 숨기는 메서드
		f.setLayout(null);
		f.setLocation(700, 200);
		f.setSize(500, 300);
	}

}
