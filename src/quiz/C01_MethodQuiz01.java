package quiz;

import java.util.Arrays;

public class C01_MethodQuiz01 {

	/*
문제. 다음 메서드를 정의하고 올바르게 동작하는지 테스트 해보세요
1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
4. 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수
5. 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
	 */

	// 1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
	public static boolean isAlphabet(char ch) {
		// boolean 타입으로 리턴한다는 건 한줄로 끝나도 된다는 얘기임
		// 방법 (1).
		//		if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
		//			return true;
		//		} 
		//			return false;
		//	}
		// 방법 (2). 한줄짜리
		return ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z';
	}

	// 2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
	public static boolean inMul3(int num) {
		return num % 3 == 0;
	}

	// 3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
	public static String evenOdd(int num) {
		// 방법 (1).
//		if (num % 2 ==0) {
//			return "짝수입니다.";
//		} else {
//			return "홀수입니다.";
//		}
//		// 방법 (2). 한줄짜리
		return num % 2 == 0 ? "짝수입니다." : "홀수입니다.";
	}

	// 4. 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수
	public static int[] yaksu(int num) {
		// ↓ 약수의 개수 먼저 세기
		int cnt = 0;
		for (int i = 1; i <= num; ++i) {
			if (num % i == 0) {
				++ cnt;
			}
		}
		int[] yaksu = new int[cnt];
		// 약수의 개수가 몇 개인지   ↑ 모르기 때문에 약수의 개수 먼저 센다.
		cnt = 0;
		for (int i = 1; i < num; ++i) {
			if (num % i == 0) {
				yaksu[cnt++] = i;
			}
		}
		return yaksu;
	}

	// 5. 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
	public static boolean isPrime(int num) {
		for (int i = 2; i < Math.sqrt(num); ++i) {
			if(num % i == 0) {
				System.out.println("5번 정답 ⇒ [INFO] " + i + "로 나누어 떨어져서 소수가 아닙니다.");
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// 1.
		boolean english = isAlphabet('家');
		System.out.println("1번 정답(메서드 사용X) ⇒ english? " + english);
		System.out.println("1번 정답 ⇒ english? " + isAlphabet('Z'));

		// 2.
		System.out.println("2번 정답 ⇒ 3의 약수? " + inMul3(30));


		// 3.
		System.out.println("3번 정답 ⇒ 짝수? 홀수?" + evenOdd(33));

		// 4.
		System.out.println("4번 정답 ⇒ 777의 약수 : " + Arrays.toString(yaksu(777)));


		// 5. 
		// boolean 타입을 리턴하는 메서드는 조건으로 사용할 수 있다.
		if (isPrime(27)) {
			System.out.println("5번 정답 ⇒ 소수일 때 도착하는 곳");
		} else {
			System.out.println("5번 정답 ⇒ 소수가 아닐 때 도착하는 곳");
		}
	}
}
