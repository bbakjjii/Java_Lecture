
public class C01_Method {
	// ▼ class 내부

	/* 
# 함수 (Function)
· 기능을 미리 정의해두고 나중에 가져다 쓰는 것
· 함수를 정의한 시점에서는 실행되지 않고 나중에 호출했을 때 실행된다.
· 미리 정의된 함수 이름 뒤에 ()를 붙여 해당 함수를 호출한다.
· 나중에 재사용 할 가능성이 있는 기능들을 함수로 만들어두면 작업의 반복을 줄일 수 있다.
· 자바에서 함수는 반드시 클래스 내부에 선언해야 한다.
· 클래스 내부에 선언된 함수는 메서드(method)라고 부른다.

# 함수의 선언
	public static 리턴타입 함수이름(매개변수){
				   ↑ 자료형 또는 void
		함수의 내용
		return; (리턴 타입이 void일 경우 return 없음)
	}
· public static : 뭔지 모르겠지만 일단 써야 하는 것
· 리턴 타입 : 함수가 실행되고 나면 호출한 곳에 돌려줘야 하는 값의 타입
· 함수 이름 : 나중에 호출할 때 사용하고 싶은 이름
· return : 해당 함수를 끝마치면서 값을 호출한 곳에 돌려준다.

# 함수의 리턴 (return)
· 해당 함수가 반환하는 값의 타입을 지정할 수 있다.
· 함수를 호출했을 때 호출한 곳에 함수의 실행 결과가 반환된다.
· 함수 내부에서 return을 만나면 해당 함수를 즉시 종료한다.
· 리턴 타입 void인 함수는 값을 반환하지 않는다.

# 함수의 매개변수 (argument)
· 함수를 호출할 때 ()에 전달하는 값을 인자라고 한다.
· 함수를 정의할 때 ()에 선언하는 인자를 받을 수 있는 변수를 매개변수라고 한다.
· 매개 변수의 개수에는 제한이 없다.
· 매개 변수에 ...(점점점)을 찍으면 여러개의 해당 타입 값을 배열로 받을 수 있다.
· ...(점점점)은 반드시 마지막 매개변수에 사용해야 한다.

# 단축키
· sysout 입력 후 Ctrl + Space Bar
	System.out.println("안녕하세요");
· syserr 입력 후 Ctrl + Space Bar : 글씨가 빨갛게(에러) 나옴
	System.err.println("안녕하세요.");
· main 입력 후 Ctrl + Space 누르면 자동완성
	public static void main(String[] args) {
	 */

	//	public static void main(String[] args) {
	//
	//	// 1-1.
	//		for (int i = 0; i < 10; ++i){
	//			System.out.println(" /)/)");
	//			System.out.println("(  ..)");
	//			System.out.println("(   >$");
	//		}
	//	}
	//}

	//	// 1-2. 함수를 정의한 시점에서는 실행되지 않고
	//	public static void printRabbit() {
	//		System.out.println(" /)/)");
	//		System.out.println("(  ..)");
	//		System.out.println("(   >#");
	//	}
	//
	//	// 1-3. 나중에 호출했을 때 실행된다.
	//	public static void main(String[] args) {
	//	// ▼ main 내부
	//		for (int i = 0; i < 3; ++i) {
	//		printRabbit();
	//		}
	//	}
	//}

//	public static void test(int a, String...msgs) { // ⑤
//		// ...은 맨 마지막에 넣어야 한다. why? 뒤에 변수가 몇개가 올지 모르기 때문에!
//		// ...(점점점)매개변수에는 값을 원하는만큼 보낼 수 있다.
//		System.out.println("a: " + a);
//
//		for(int i = 0; i < msgs.length; ++i) {
//			System.out.printf("%d: %s\n", i, msgs[i]);
//		}
//	}
//
//	public static void main(String[] args) {
//		test(1, "abc", "abc", "abc");
//		test(2, "abc");
//		test(3, "lion", "lion", "tiger", "monkey", "lion");
//	}
//}

	public static int plus(int a, int b) { // ⓞ
		// 리턴 타입 : int, 함수 이름 : plus
		int num = a + b;
		return 123; 
		// 리턴 타입이 int이기 때문에 int 외의 다른 값(string 등)을 리턴 하면 에러
		// return : 투입했을 때 나에게 돌아오는 값
	}
	
	public static String repeat(int time, String message) { // ①
		// ** int time, String message : 매개변수
		String str = "";
		for (int i = 0; i < time; ++i) {
			str += message;
		}
		return str; // ③
	}
	
	// void : 이 함수는 호출해도 리턴이 없습니다 라는 뜻
	public static void print(String str) { // ④
		System.out.print(str);
	}

	public static void main(String[] args) { // ②

		// 리턴 타입이 void인 함수는 호출해도 값이 돌아오지 않는다.
		// int a = print("123\n");

		// 리턴 타입이 있는 함수는 해당 타입의 값을 반드시 리턴한다.
		int b = plus(1, 2); // ** 1, 2 : 인자
		
		String str = repeat(3, "L");
	
		System.out.println(repeat(5, "hello! ")); // ②
		System.out.println(repeat(10, "bye! ")); // ②
		System.out.println(plus(1,1)); // ③
	}
}






