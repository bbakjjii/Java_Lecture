package myobj;

public class KindPerson  extends Person {
	
	String name = "동용"; // = 그냥 name
	
	// 상속받은 클래스는 부모의 생성자(=super 클래스)를 가장 먼저 호출해야 한다.
	public KindPerson(String name, int age) { // 상속 클래스도 이름과 나이를 전달 받아야 한다.
		super(name, age); // super class의 생성자
	}
	
	// 부모 클래스에 이미 존재하던 기능을 자식 클래스에서 수정하여 사용할 수 있다. (오버라이드)
	// 오버라이드 (빈줄에 Ctrl + Space 해서 불러오기)
	// @Override : 컴파일러가 일을 좀 빨리 할 수 있게 도움을 준다. 없어도 상관은 없다.
	@Override
	public void sayHi() {		
		String name = "인재";
		System.out.printf("안녕하십니까. 제 이름은 %s입니다. 나이는 %d살 입니다. 잘 부탁드립니다.\n", name, age);
	}
	
	// ↓ -----부모 클래스에는 없던 새로운 기능-----
	// this.name(자식클래스)과 super.name(부모클래스)의 차이
	public void sayMyname() {
		System.out.println("그냥 name: " + name);
		System.out.println("this.name: " + this.name); //KindPerson에는 아무것도 안 들어있다.
		System.out.println("super.name: " + super.name);
	}
	
	// KindPerson은 Person보다 추가로 sayThanks()까지 가지고 있다.
	public void sayThanks(String target) {
		System.out.printf("%s씨 감사합니다.\n", target);
	}
	// ↑ -----부모 클래스에는 없던 새로운 기능-----
}
