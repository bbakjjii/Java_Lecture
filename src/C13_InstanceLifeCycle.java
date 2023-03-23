public class C13_InstanceLifeCycle {

	/*
# 인스턴스 생명 주기
1. 해당 클래스 첫 실행시 스태틱 관련 자원들 메모리 할당
2. 인스턴스 관련 자원들 메모리 할당
3. 생성자 실행
	 */

	// 내부에 클래스 생성
	static class TestClass{

		static String b = "abc";
		int a = 10;

		// 스태틱 블록①
		static {
			System.out.println("스태틱 블록이 실행되었습니다. " + b);
		}

		// 인스턴스 블록② : 클래스 영역 안에서 실행할 수 있는 인스턴스 블록
		{
			System.out.println("인스턴스 블록이 실행되었습니다." + a);
		}

		// 생성자③
		public TestClass() {
			System.out.println("생성자가 실행되었습니다.");
		}

		void doSomething() {
			System.out.println("Hello, world!");
		}
	}

	public static void main(String[] args) {
		// 생성자 보다 먼저 실행되는 것이 인스턴스 블록
		// 스태틱 블록은 첫 인스턴스 생성시에만 실행된다.
		TestClass test = new TestClass(); 
		TestClass test2 = new TestClass(); 

		// 5번 실행 : 스태틱→인스턴스→생성자→인스턴스→생성자
		for (int i = 0; i < 5; ++i){ 
			new TestClass();
		}
	}
}
