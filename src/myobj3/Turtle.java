package myobj3;

// 다중 상속이 안된다. ⇒ 다중 상속을 극복하고자 인터페이스가 나온 것.
// implements를 붙이면 다중 상속 가능(타입 역할 가능, 업캐스팅 가능, 인스턴스화는 불가능)
public class Turtle implements Running, Swimming {
	
	@Override
	public void swim() {
		
	}
	
	@Override
	public void run() {
	
	}
}
