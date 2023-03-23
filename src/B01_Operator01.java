
/*
	# 연산자 (Operator)
	· 계산할 때 값과 함께 사용하는 것
	· +, -, *, /, >, <, >=, <=, !, && ...
	
	1) 산술 연산자
	· + : 더하기
	· - : 빼기
	· * : 곱하기
	· / : 나누기
	· % : 나머지
	
	2) % (나머지 연산)
	· n으로 나눈 나머지는 0부터 n-1까지 밖에 나올 수 없다
	  ex) 3으로 나눈 나머지는 0부터 2(=3-1)까지 밖에 나올 수 없다
	
	3) 연산 결과
	· 정수 + 정수 = 정수
	· 정수 + 실수 = 실수
	· 정수 / 정수 = 몫
	· 정수 / 실수 = 실수값(정확한 값)
	
	# Math함수
	· Math.pow(a, b) : a 제곱 b(a의 b승)를 구해서 반환한다. (결과가 double 타입)
	· Math.sqrt(a) : a의 제곱근을 구해서 반환한다.
	· Math.abs(a) : a의 절대값을 구해서 반환한다.
	· Math.round(a) : a를 소수 첫째자리에서 반올림한 결과를 반환한다.
	· Math.ceil(a) : a를 올림한 결과를 반환한다.
	· Math.floor(a) : a를 내림한 결과를 반환한다.
	· Math.round()로 원하는 자릿수에서 반올림하기
	  (반올림하고 싶은 자리를 소수 첫 번째 자리로 만든 후 다시 나눈다)
	  
 */
public class B01_Operator01 {
	public static void main(String[] args) {

		int a = 30, b = 8;
		double c = 30, d = 8;

		System.out.println("int a = 30, b = 8 / double c = 3, d = 8");
		// 정수와 정수의 연산 결과 = 정수
		System.out.println("a + b : " + a + b);
		System.out.println("a + a : " + a + a);

		// 정수와 실수의 연산 결과 = 실수
		System.out.println("c + b : " + c + b);
		System.out.println("a + d : " + a + d);
		System.out.println("c + c : " + c + c);

		// 정수와 정수를 나누면 몫만 구한다.
		System.out.println("a / b : " + a / b); // 30 / 8 = 3

		// 정수와 실수를 나누면 정확한 값을 구한다.
		System.out.println("a / d : " + a / d); // 30 / 8.0 = 3.75
		System.out.println("c + b : " + c / b); // 30.0 / 8 = 37.5
		System.out.println("c + d : " + c / d); // 30.0 / 8.0 = 37.5

		// 나머지 연산
		System.out.println("20 % 3 : " + 20 % 3); // 20 / 3의 나머지 = 6...2
		System.out.println("20 % 8 : " + 20 % 8); // 20 / 8의 나머지 = 2...4

		//n으로 나눈 나머지는 0부터 n-1까지 밖에 나올 수 없다.
		// ex) 3으로 나눈 나머지는 0부터 2(=3-1)까지 밖에 나올 수 없다.
		System.out.println("0 % 3 : " + 0 % 3);
		System.out.println("1 % 3 : " + 1 % 3);
		System.out.println("2 % 3 : " + 2 % 3);
		System.out.println("3 % 3 : " + 3 % 3);
		System.out.println("4 % 3 : " + 4 % 3);
		System.out.println("5 % 3 : " + 5 % 3);
		System.out.println("6 % 3 : " + 6 % 3);
		System.out.println("7 % 3 : " + 7 % 3);
		System.out.println("8 % 3 : " + 8 % 3);


		// Math.pow(a, b) : a 제곱 b(a의 b승)를 구해서 반환한다. (결과가 double 타입)
		System.out.println("Math.pow(2,10) : " + Math.pow(2,10));
		System.out.println("Math.pow(2,11) : " + Math.pow(2,11));
		System.out.println("Math.pow(2,12) : " + Math.pow(2,12));
		System.out.println("Math.pow(3,10) : " + Math.pow(3,10));


		// 반환이 있는 함수의 예
		double result = Math.pow(2, 8); // 반환하는 함수

		System.out.println("double result = Math.pow(2, 8) : " + result);

		// 반환이 없는 함수의 예
		// double result2 = System.out.println("Hello, world!");


		// Math.sqrt(a) : a의 제곱근을 구해서 반환한다.
		System.out.println("Math.sqrt(2) : " + Math.sqrt(2));
		System.out.println("Math.sqrt(49) : " + Math.sqrt(49));
		System.out.println("Math.sqrt(51) : " + Math.sqrt(51));

		// Math.abs(a) : a의 절대값을 구해서 반환한다.
		System.out.println("Math.abs(-55) : " + Math.abs(-55));
		System.out.println("Math.abs(55) : " + Math.abs(55));

		// Math.round(a) : a를 소수 첫째자리에서 반올림한 결과를 반환한다.
		System.out.println("Math.round(123.11) : " + Math.round(123.11));
		System.out.println("Math.round(123.55) : " + Math.round(123.55));

		// Math.ceil(a) : a를 올림한 결과를 반환한다.
		System.out.println("Math.ceil(333.00999) : " + Math.ceil(333.00999));
		System.out.println("Math.ceil(333.0) : " + Math.ceil(333.0));


		// Math.floor(a) : a를 내림한 결과를 반환한다.
		System.out.println("Math.floor(333.99999) : " + Math.floor(333.99999));
		System.out.println("Math.floor(333.12345) : " + Math.floor(333.12345));

		// Math.round()로 원하는 자릿수에서 반올림하기
		// (반올림하고 싶은 자리를 소수 첫 번째 자리로 만든 후 다시 나눈다)
		double value = 123.1234567;		
		System.out.println("Math.round(value * 10 / 10.0) : " + Math.round(value * 10) / 10.0); //.0을 붙이면 double 타입
		System.out.println("Math.round(value * 100 / 100.0) : " + Math.round(value * 100) / 100.0);
		System.out.println("Math.round(value * 1000 / 1000.0) : " + Math.round(value * 1000) / 1000.0);
		System.out.println("Math.round(value * 10000 / 10000.0) : " + Math.round(value * 10000) / 10000.0);
		System.out.println("Math.round(value * 100000 / 100000.0) : " + Math.round(value * 100000) / 100000.0);
	}
}
