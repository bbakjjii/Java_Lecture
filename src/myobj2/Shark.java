package myobj2;

// 에러 : The type Shark must implement the inherited abstract method Animal.bite()
// = 샤크 타입은 반드시 상속받은 추상메서드 애니몰 바이트를 구현해야 한다.
// 자식클래스
public class Shark extends Animal {
			
	@Override
	public void bite() {
		System.out.println("상어가 물면 아프다.");		
	}
}
