/*
	# 변수(Variable)
	· 프로그래밍 언어에서 데이터를 저장해 둘 수 있는 공간
	· 자바에서 변수는 반드시 선언한 뒤에 사용해야 한다.
	· 값을 한번도 대입한 적 없는 변수는 사용하려고 하면 에러가 발생한다.
		(초기화(initialize) 하지 않은 변수는 사용할 수 없다.)
	· 같은 {} 내부에서 같은 이름의 변수를 여러번 선언할 수 없다.

	# 초기화 : 값을 맨 처음으로 넣는 행위. 초기화와 값은 따로 있다.

	# 변수의 선언 (declare)
	· 타입 변수명;
	· 해당 변수에 어떤 타입의 데이터만 저장할 것인지
	· 타입 : 해당 변수에 저장할 데이터의 타입을 지정한다.
		(String - 문자열, int - 정수, ...)
	· 변수명 : 사용하고 싶은 변수의 이름을 지정한다.

	# 대입 연산 (=)
	· 원래 알고 있는 =의 의미 : 왼쪽과 오른쪽의 값이 같다.
	· 프로그래밍 언어에서 =의 의미 : 왼쪽의 변수에 오른쪽의 값을 넣어라. (대입)
 */


public class A03_Variable {
	public static void main(String[] args) {
		// int : 이 변수에는 정수만 담을 예정이다.
		int age = 13;
		int price = 1350;

		// 변수의 값은 대입 연산을 통해 바꿀 수 있다. 원래 있던 값은 무시한다.
		age = 33;

		// Sting : 이 변수에는 문자열만 담을 예정이다.
		String name = "아이언맨";

		name = "하와이안 피자";
		System.out.println(age) ;
		System.out.println(age + age) ;
		System.out.println(age * 3);
		System.out.println(name);	
		System.out.println(price);

		// int grape_qty;
		// System.out.println(grape_qty);
		//오류: 변수의 값을 넣지 않아서 쓸 수 없다.

		// 변수를 선언과 동시에 초기화
		int grape_price = 2800;

		// 변수를 선언만 하고 나중에 초기화
		int grape_qty = 8; // qty : 수량

		// 위에서 선언한 변수를 이용해 초기화
		int grape_total_price = grape_price * grape_qty;

		System.out.println("포도의 가격 : " + grape_price);
		System.out.println("포도의 개수 : " + grape_qty);
		System.out.println("총 가격 : " + grape_price * grape_qty);

		// int age; 
		// 같은 {} 내부에서 같은 이름의 변수를 여러번 선언할 수 없다.

		// {} 내부에서 선언된 변수는 해당 {}를 벗어나면서 사라지게 된다.
		int apple = 100;
		{
			int orange = 30;

			System.out.println(orange);
		}

		// orange는 {}가 끝나면서 사라졌기 때문에 다시 선언할 수 있다.
		int orange = 123;
		// age는 {} 내부에 선언한 것이 아니기 때문에 이름이 겹친다.
		// int age = 123;
		// apple은 {} 내부에 선언한 것이 아니기 때문에 이름이 겹친다.
		// int apple = 123;
	}

}	