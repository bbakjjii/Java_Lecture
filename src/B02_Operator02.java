/*
	# 비교 연산자
	· 두 값을 비교하는 연산
	· 비교 연산의 결과는 항상 참(true) 또는 거짓(false)이다.
	· 비교 연산의 결과는 boolean 타입이다.
	· 산술 연산과 비교 연산이 함께 있으면 산술 연산을 먼저 계산한다.
	· > : 왼쪽이 크면 true
	· < : 오른쪽이 크면 true
	· >= : 왼쪽이 크거나 같으면 true
	· <= : 오른쪽이 크거나 같으면 true
	· == : 두 값이 같으면 true		
	· != : 두 값이 다르면 true
	
	# 논리 연산자
	· boolean 타입 값으로 연산
	· && : 양 옆의 두 값이 모두 true일 때 true (AND)
	· ||(Shift + \) : 둘 중 하나만 true여도 true (OR)
	· ! : true면 false, false면 true (NOT)
*/

public class B02_Operator02 {
	public static void main(String[] ags) {
		
		int a = 10, b = -7;
		
		// 비교 결과를 변수에 담아놓는 것이 가능하다.
		int c = a + b;
		boolean d = a > b;
		
		System.out.println(a < b);
		// a*b(-70)와 a+b(3)를 먼저 계산하고 이 값으로 비교 연산한 결과를 산출 
		System.out.println(a * b < a + b); // 산술 연산과 비교 연산이 함께 있으면 산술 연산을 먼저 계산
		
		
		System.out.println(a > b); // > : 왼쪽이 크면 true
		System.out.println(a < b); // < : 오른쪽이 크면 true
		System.out.println(a >= b); // >= : 왼쪽이 크거나 같으면 true
		System.out.println(a <= b); // <= : 오른쪽이 크거나 같으면 true
		System.out.println(a == b); // == : 두 값이 같으면 true		
		System.out.println(a != b); // != : 두 값이 다르면 true
		
		System.out.println(a + 5 < 20); // a + 5가 20 보다 작나요?
		System.out.println(a % 3 == 0); // a가 3의 배수일 때 true. a 나누기 3의 나머지가 0과 같은가? 3의 배수인가?
		System.out.println(a % 3 != 0); // a가 3의 배수가 아닐 때 true. a 나누기 3의 결과가 0과 다른가?  3의 배수가 아닌가?
		
		System.out.println("### AND ###"); // 양 옆의 두 값이 모두 true일 때 true
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println("### OR ###"); // 둘 중 하나만 true여도 true
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		System.out.println("### NOT ###"); // true면 false, false면 true
		System.out.println(!true);
		System.out.println(!false);
		
		a = 95;
		System.out.println(a < 100 && a % 5 == 0);
		
		b = -5555;
		System.out.println(b < 100 && b % 5 == 0 &&  a >= 0);	
	}
}
