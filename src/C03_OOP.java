import myobj.Book;
import myobj.Car;
import myobj.Coffeemachine;
import myobj.Subway;

public class C03_OOP {

	/*
 # 객체 지향 프로그래밍(Object Oriented Programming)
 · 변수와 함수들을 세상에 존재하는 개념(객체)으로 묶어서 사용하려는 프로그래밍 방법론
 · 변수와 함수들을 무분별하게 사용하는 것 보다 현실에 존재하는 객체 단위로 묶어서 표현하는 것이
 	개발자들의 업무 효율을 높인다.
 · 변수는 현실에 존재하는 객체의 상태를 나타낸다.
 	ex) color, name, age, ...
 · 해당 객체의 상태를 변화시킬 수 있는 객체 내부의 함수들을 메서드라고 부른다.

 ex) 책(Book)
 	· 책의 상태(변수) : 전체 페이지(int), 현재 페이지(int), 눌림 정도, 
 					각 페이지의 낙서여부(boolean 배열인데 페이지수만큼 있는 것),
 					각 페이지의 메모 내용, 가치(메모(낙서)를 할 때마다 가치가 떨어진다),
 					원래 가격, 감가상각
 	· 책의 기능(메서드) : 페이지를 넘기는 기능(몇 페이지 넘길지 → 현재 페이지의 변화시킬 수 있는 기능)
 	 				해당 페이지에 메모하는 기능, 형광펜을 칠하는 기능(가치 -2), ...

# 클래스 (Class)
· 객체지향 프로그래밍의 객체를 프로그래밍 언어로 표현한 문법
· 클래스는 해당 객체의 설계도 역할을 한다.
· 클래스는 정의한 시점에서는 실체(인스턴스)가 없다.
· ★ 클래스라는 설계도를 통해 마들어내는 실제 객체를 '인스턴스(instance)'라고 한다.
· 클래스틀 통해 인스턴스를 생성할 때 new를 사용한다.
· 같은 패키지 내부에는 같은 이름의 클래스를 정의할 수 없다.

# 인스턴스
· 새로운 생산품
⇒ 세상에 책은 엄청 많음. 각각의 책을 인스턴스라고 함. 모든 책들이 보유하고 있는 설계도를 Class라고 함.
	 */

	public static void main(String[] args) {
		// new를 통해 인스턴스를 찍어낼 수 있다.
		Book book1  = new Book(); // F2 누르고 myobj에 있는 Book 선택 // Book 클래스로 만들어진 book1이 존재
		Book book2 = new Book();

		book1.price = 35000;
		book1.page = 350;
		book1.currPage = 10;

		System.out.println(book1.price); // 설정이 있기 때문에 35000이 나온다.
		System.out.println(book2.price); // 설정이 없으면 기본값은 배열과 똑같다. ⇒ 0

		book1.nextPage();
		book2.nextPage();
		System.out.println(book1.currPage); // 11페이지(10+1페이지)
		System.out.println(book2.currPage); // 0페이지(설정 X)
		System.out.println("----------");

		/*
 		연습문제 : 현실에 존재하는 객체를 하나 참고하여 클래스를 하나 생성한 후
 		인스턴스를 생성하고 해당 인스턴스의 상태를 출력해보세요.

 		※ 인스턴스 변수 3개 이상, 인스턴스 메서드 2개 이상 (책 금지)
		 */

		Coffeemachine coffee1 = new Coffeemachine();
		Coffeemachine coffee2 = new Coffeemachine();
		Coffeemachine coffee3 = new Coffeemachine();

		coffee1.type = "아메리카노";
		coffee1.price = 1500;
		coffee1.size = "tall";
		coffee1.qty = 40;

		coffee2.type = "라떼";
		coffee2.price = 2000;
		coffee2.size = "tall";
		coffee2.qty = 35;		

		System.out.println(coffee1.type);
		System.out.println(coffee1.size);
		System.out.println(coffee1.qty);
		System.out.println(coffee1.price);

		coffee1.sizeUp();
		System.out.println(coffee1.price);

		coffee1.service();
		System.out.println(coffee1.qty);

		System.out.println("----------");

		System.out.println(coffee2.type);
		System.out.println(coffee2.size);
		System.out.println(coffee2.qty);
		System.out.println(coffee2.price);

		coffee2.sizeUp();
		System.out.println(coffee2.price);

		coffee2.service();
		System.out.println(coffee2.qty);
		System.out.println("----------");

		Car truck = new Car(); // car 클래스
		truck.weight = 3000; // 트럭 무게
		truck.accSpeed = 5.2; // 밝을 때마다 5.2km  속도로 빨라진다.

		truck.tackle("고라니"); // 고라니를 쳤다.

		truck.acceleration();
		truck.acceleration();
		truck.acceleration();

		truck.tackle("고라니");

		Subway one = new Subway();
		Subway two = new Subway();

		one.line = 1;
		two.line = 2;

		// 에러 : 배열의 메모리 할당이 되지 않아 사용할 수 없는 방식
		// 에러 메세지 : Array constants can only be used in initializers 이 방식은 초기화 할 때만 사용할 수 있습니다.
		// one.stations = {"시청", "종각", "종로3가"}

		// 배열의 메모리 할당과 초기화를 동시에 진행하는 방식
		one.stations = new String[]{"시청", "종각", "종로3가","종로5가"};
		two.stations = new String[]{"당산", "합정", "홍대입구","신촌", "이대"};
		
		two.rotate = true;
		two.direction = true;

		// ②
		for (int i = 0; i < 10; ++i) {
			two.information();
			two.next();
		}
	}
}
