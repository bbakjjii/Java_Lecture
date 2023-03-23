
public class B13_Operator05 {

/*
# 삼항 연산자
· 간단한 if문을 한 줄로 사용할 수 있다.
· 비교 ? 예 : 아니오;
· 비교 결과가 true라면 : 왼쪽의 값을 사용한다.
· 비교 결과가 false라면 : 오른쪽의 값을 사용한다.
*/

	public static void main(String[] args) {

		int apple = 20;
		int basket = apple % 10 == 0 ? apple / 10 : apple / 10 + 1;
		System.out.println("필요한 바구니의 개수 : " + basket);

		System.out.println("----------");		

		int a = 13; // int a는 10이다

		// 물음표 뒤의 값이 문자열이기 때문에 String 사용		
		String message = a % 2 == 0 ? "짝수입니다." : "홀수입니다."; // a % 2의 나머지가 0이니?

		int result = a % 2 == 0 ? 7 : 99; // a에 들어있는 값이 짝수이면 7, 홀수이면 99를 출력

		// 삼항연산자가 boolean일 때는 삼항연산자를 안 쓰는 것과 같다.
		// boolean jjaksu = a % 2 == 0 ? false : true;
		boolean holsu = a % 2 != 0;

		System.out.println(message);
		System.out.println(result);
		System.out.println(holsu);
	}

}
