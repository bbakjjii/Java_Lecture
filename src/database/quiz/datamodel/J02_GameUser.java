package database.quiz.datamodel;

// data model : 데이터의 형태를 구현한 클래스 (데이터를 담아놓는 용도로 사용)
// 테이블에서 하나를 꺼내면 인스턴스 한 행만 나온다.
public class J02_GameUser {
	
	private Integer user_num;
	private String user_id;
	private String user_password;
	private Integer gold;
	
	// 데이터는 구경할 수 있게 get만 만들어놓는다 (수정이 불가능)
	// 데이터를 담는 것은 생성자에서 진행
	public J02_GameUser(Integer user_num, String user_id, String user_passwrod, Integer gold) {
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_password = user_passwrod;
		this.gold = gold;
	}


	public Integer getUser_num() {
		return user_num;
	}


	public String getUser_id() {
		return user_id;
	}

	public String getUser_password() {
		return user_password;
	}


	public Integer getGold() {
		return gold;
	}
	
	public void setGold(Integer gold) {
		this.gold = gold;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %s, %dgold]", user_num, user_id, gold);
	}
	

	
	
}
