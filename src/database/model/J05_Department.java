package database.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class J05_Department {
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	// departments에 employees를 넣으면 부서 한개에 여러명의 직원이 들어와 배열로 만들어야 하기 때문에 번거로워지므로 employees안에 departments가 들어오는게 맞다.
	// Employee[] employees 
	
	
	public J05_Department() {}
	
	public J05_Department(ResultSet rs) throws SQLException {
		department_id = rs.getInt(1);
		department_name = rs.getString(12);
		manager_id = rs.getInt(13);
		location_id = rs.getInt(14);
	}
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
}