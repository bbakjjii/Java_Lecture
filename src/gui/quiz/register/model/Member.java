package gui.quiz.register.model;

import java.util.Date;

public class Member {
	
	//아이디, 이름, 나이, 주민등록번호 맨 앞자리까지, 관심분야, SMS수신 동의 여부, 이메일, 핸드폰 번호
	private String mem_id;
	private String password;
	public String getPassword() {
		return password;
	}

	private String mem_name;
	private String email;
	private String phone_number;
	private Integer age;
	private Date birthday;
	private String gender;
	private String interest1;
	private String interest2;
	private String interest3;
	private boolean sms;
	
	public Member() {}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInterest1() {
		return interest1;
	}

	public void setInterest1(String interest1) {
		this.interest1 = interest1;
	}

	public String getInterest2() {
		return interest2;
	}

	public void setInterest2(String interest2) {
		this.interest2 = interest2;
	}

	public String getInterest3() {
		return interest3;
	}

	public void setInterest3(String interest3) {
		this.interest3 = interest3;
	}

	public boolean isSms() {
		return sms;
	}

	public void setSms(boolean sms) {
		this.sms = sms;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
}
