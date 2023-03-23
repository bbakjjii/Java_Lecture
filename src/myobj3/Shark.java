package myobj3;

// 상어는 수영을 구현했다(implements)
public class Shark implements Swimming {
	
	@Override
	public void swim() {
		System.out.println("상어는 수영을 할 줄 압니다.");
	}
}
