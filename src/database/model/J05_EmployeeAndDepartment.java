package database.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J05_EmployeeAndDepartment {
	
	private Integer department_id;
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private Double salary;
	private Double commission_pct;
	private Integer manager_id;
	J05_Department department; // Department 인스턴스를 넣는다. J05_Department안에 들어가서 department의 정보를 볼 수 있다.
	
	public J05_EmployeeAndDepartment() {}
	
	public J05_EmployeeAndDepartment(ResultSet rs) throws SQLException {
		department_id = rs.getInt(1);
		employee_id = rs.getInt(2);
		first_name = rs.getString(3);
		last_name = rs.getString(4);
		email = rs.getString(5);
		phone_number = rs.getString(6);
		hire_date = rs.getDate(7);
		job_id = rs.getString(8);
		salary = rs.getDouble(9);
		commission_pct = rs.getDouble(10);
		manager_id = rs.getInt(11);
		department = new J05_Department(rs);
	}
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public Double getSalary() {
		return salary;
	}
	public Double getCommission_pct() {
		return commission_pct;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	
	public J05_Department getDepartment() {
		return department;
	}
	public String getDepartment_name() {
		return department.getDepartment_name(); //J05_Department의 department를 끌어온다
	}
	public Integer getDepartemtManager_id() {
		return department.getManager_id();
	}
	public Integer getLocation_id() {
		return department.getLocation_id();
	}
	
	@Override
	public String toString() {
		return String.format("%s/%d/%d\n", first_name, department_id, getDepartemtManager_id());
	}

}
