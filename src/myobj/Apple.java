package myobj;

public class Apple {
	
	public int size;
	public int grade;
	public String color;
	
	// ※ 생성자 (인스턴스 메서드 만들기 전에 만든다)
	// 생성자 : 클래스 이름과 같아야 함. 리턴 타입 없음
	// 생성자에서는 값을 채우는 용도로 많이 사용한다.
	
	// Ctrl + Space : 자동완성으로 불러오기
	// 인스턴스 생성시 다음 생성자들 중 하나를 반드시 호출해야 한다.
	public Apple() {
		// 기본 설정
		size = 50;
		grade = 3;
		color = "기본색상";
	}
	
	// 생성자도 오버로딩이 가능하다.
	public Apple(int size) {
	}
	
	public Apple(int size, int grade) {	
		// 이름(값)이 똑같을 때는 제일 가까운 변수를 불러온다.
		// 좀 더 정확하게 지정해줘야 한다.
		// size = size; X
		// grade = grade; X
		// this = 각 인스턴스 영역을 의미한다.		
		this.size = size; // a3
		this.grade = grade;
		this.color = "기본색";
	}

	public Apple(int s, int g, String c) {
		// 이름(값)이 겹치지 않을 때는 this가 생략 가능하다.		
		size = s;
		grade = g;
		color = c;
	}

	public void info() {
		System.out.printf("크기 : %d\n등급 : %d\n색깔 : %s\n",
				this.size, this.grade, this.color);
	}
	
	@Override
	public String toString() {
		return color + "색 사과 크기는 " + size + "";
	}
}
