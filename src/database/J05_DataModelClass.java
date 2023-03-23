package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.J05_Fruit;

public class J05_DataModelClass {

	// DB에서 꺼내온 데이터는 해당 테이블의 데이터를 담을 수 있는 데이터 모델 클래스에 보관하는 것이 좋다

/*
	# 데이터 모델 클래스
	- 데이터를 담아 놓는 용도인 클래스(DTO, Data Transfer Object)
	- 필드값에 그냥 접근하도록 허용하지 않고 getter와 setter를 통해 접근하도록 한다
	- getter만 달아놓으면 읽기 전용 데이터 클래스가 된다 (VO, Value Object)
	- setter를 모두 달아 놓으면 수정이 가능한 필드가 된다
*/
	public static void main(String[] args) {
		
		List<J05_Fruit> fruits = new ArrayList<>();
		
		try(
				Connection conn = JJ_OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM fruits");
				ResultSet rs = pstmt.executeQuery();
				){
			while (rs.next()) {
				J05_Fruit f = new J05_Fruit();
				
				f.setName(rs.getString("name"));
				f.setPrice(rs.getInt("price"));
				f.setSweet(rs.getDouble("sweet"));
				f.setApple_grade(rs.getString("apple_grade"));
				f.setCountry_id(rs.getString("country_id"));
				
				fruits.add(f);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		// DB 연결 부분에서 활용하기 보다는 컬렉션에 담아놓은 후 활용하는 것이 좋다
		System.out.println(fruits);
	}
}
