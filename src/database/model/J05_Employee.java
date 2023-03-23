package database.model;

import java.util.Date;

public class J05_Employee {

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
	
}