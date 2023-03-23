/*
	# ASCII 코드
	· 문자는 실제로 각 문자에 대응하는 번호를 지니고 있다.
		ex) 'A'는 65번 문자, 'B'는 66번 문자 ...
	· 0 ~ 127번 까지의 문자들을 ASCII 코드라고 한다. 
	· 모든 데이터는 실제로 0과 1로 변환되어 저장된다.
	· 문자는 바로 0과 1로 변환할 수 없기 때문에 문자에 해당하는 코드값이 존재한다.

	# 인코딩 (encoding) : 문자를 코드화 하는 것
	· A → 65 → 01000 001
	· ! → 33 → 0010 0001

	# 디코딩 (Decoding) : 코드를 해석 하는 것
	· 0100 0001 → A
	· 0010 0001 → !
*/

public class A02_ASCII {
	public static void main(String[] args) {
		//문자 0 : 실제로는 48이라는 코드값을 가지고 있다.
		System.out.println((int)'0'); 
		// 숫자 0 : 실제로도 0
		System.out.println(0); 
		
		// 문자 타입 리터럴의 실제 값(코드값)을 보고 싶다면 앞에 (int)를 붙인다.
		System.out.println((int)' ');
		System.out.println((int)'!');
		System.out.println((int)'?');
		System.out.println((int)'A');
		System.out.println((int)'한');
		System.out.println((int)'가');
		
		// 숫자 타입 리터럴의 문자 형태를 보고 싶다면 앞에 (char)를 붙인다.
		System.out.println((char)33);
		System.out.println((char)90);
		System.out.println((char)48);
		System.out.println((char)49);
		System.out.println((char)50);
		
		// 문자 타입 리터럴도 실제로는 숫자값을 갖고 있기 때문에 계산이 가능하다.	
		// 해당하는 문자의 다음 문자를 찾아낼 수 있다.		
		System.out.println((char)('A' + 0));
		System.out.println((char)('A' + 1));
		System.out.println((char)('A' + 2));
		System.out.println((char)('A' + 3));
		System.out.println((char)('A' + 4));
		System.out.println((char)('A' + 5));
		
		System.out.println((char)('가' + 1));
		System.out.println((char)('가' + 2));
		System.out.println((char)('가' + 3));
		System.out.println((char)('나' + 1));
		
		// 문자끼리 계산해서 거리재기
		System.out.println('Z' - 'A'); // Z는 A로부터 몇 번째 문자인가?
		System.out.println('K' - 'A'); // K는 A로부터 몇 번째 문자인가?
		System.out.println('a' - 'A'); // 대문자를 소문자로 변환하기 위한 거리

		// 대소문자와 소문자의 거리를 이용해 대소문자 변환
		System.out.println((char)'Y' + 32);
		System.out.println((char)'Y' + ('a' - 'A'));
	}
}
