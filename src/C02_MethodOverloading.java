public class C02_MethodOverloading {
	
/*
# 매서드 오버로딩 (method overloading)
· 같은 이름의 메서드를 여러개 선언하는 방식
· 매개 변수의 타입 또는 개수가 다르다면 이름이 같아도
  각 메서드를 구분할 수 있기 때문에 중복 선언이 가능하다.
*/
	// ① : 2개
	public static int plus(int a, int b) {
		return a + b;
	}
	
	// ② : 3개
	// 매개 변수의 개수가 다르다면 같은 이름의 메서드를 선언할 수 있다.
	public static int plus(int a, int b, int c) {
		return a + b + c;
	}
	
	// ③ : 4개 이상
	public static int plus(int...numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; ++i) {
			sum += numbers[i];
			}
		return sum;
		}
	
	// ④ : 소수
	// 매개 변수의 개수가 같아도 타입이 다르다면 다른 메서드로 인식할 수 있다.
	public static float plus(float a, float b) {
		return a + b;
	}

	public static void main(String[] args) {
		System.out.println(plus(1, 2)); // ①
		System.out.println(plus(1, 2, 3)); // ②
		System.out.println(plus(1.2f, 2.3f)); // ④
		System.out.println(plus(1)); // (오버로딩) Ctrl + Space 누르면 어떤 소스를 쓸 수 있는지 알 수 있다.
		System.out.println(plus(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}
}

