package myobj;

public class PlayCard {
	
	// 각 인스턴스가 자기만의 공간을 가지고 사용한다. (인스턴스 영역)
	public char suit; // 모양
	public int num; // 숫자
	
	// width : 너비, height : 높이
	// 모든 카드의 모양과 숫자는 달라도 너비와 높이는 같아야 한다.
	// 카드는 통일된 크기이기 때문에 각자가 값을 가질 필요 없다.
	// static : static을 붙이면 모든 카드들이 같은 값을 가진다.
	// static : 메모리를 절약할 수 있다.
	// static 영역 = 클래스 영역
	// * static 변수
	// 같은 클래스로 만들어진 모든 인스턴스가 함께 사용하는 공간(스태틱 영역)
	public static int width = 100; // 너비 
	public static int height = 200; // 높이

	public PlayCard(char suit, int num) {
		this.suit = suit;
		this.num = num;
	}
	
	// * static 메서드
	// static메서드에서는 인스턴스 영역의 자원을 사용할 수 없다.
	// → 반대로 말하면, static 메서드는 static 자원만 활용할 수 있는 메서드를 의미한다.
	// 에러 : Cannot make a static reference to the non-static field suit
	// static은 인스턴트가 하나도 없는 상황일 때도 존재할 수 있다.
	// 넣을 곳이 없어서 에러.

	//	public static void test() {
//		suit = '♠'; 
//		num = 1;
//		info();
//	}
	
	// static메서드에서는 인스턴스 영역의 자원을 사용할 수 없다.
	// → 반대로 말하면, static 메서드는 static 자원만 활용할 수 있는 메서드를 의미한다.
	// → this도 현재 인스턴스를 뜻하기 때문에 static 메서드에서는 사용할 수 없다. 
	public static void ChangeCardSize(int width, int height) {
		PlayCard.width = width; // this.width는 사용 불가. this는 나 자신을 말하는 것.(h1카드)
		PlayCard.height = height; // static은 소속이 없기 때문에 this.사용 불가.
	}
	
	// h1.info(), c10.info()
	// 각자의 문양과 숫자 : this.suit, this.num
	// 모든 너비와 크기 : width, height
	public void info() {
		System.out.printf("[%c%d] w:%d, h:%d\n", this.suit, this.num, width, height);
	}
}
