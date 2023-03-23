package myobj2;

// abstract - 나중에 자식이 구현할 예정임 (인스턴스화 할 수 없음)
// : 이 클래스로는 생산품을 만들 수 없다.
// abstract public도 가능 public abstract도 가능하다(취향문제)
// 추상클래스
abstract public class Animal {

	// 동물의 이름
	String name;
	
	public String getName() {
		return name;
	}

	// 나중에 자식이 구현할 예정인 메서드
	// 동물은 문다.
	public abstract void bite();
}
