package quiz;

import java.util.Random;

public class B12_Count369 {

	/*
문제.
랜덤 양의 정수를 하나 생성하고 해당 숫자까지 369 게임이 진행된다면 박수를 총 몇 번 쳐야 하는지 출력해보세요.
	 */

	public static void main(String[] args) {

		int num = (int)(Math.random() * 1000);

		System.out.println("이번에 검사할 숫자: " + num);

		int clap = 0;

		// 방법 1. 문자열을 활용한 방식
		for (int i = 3; i <= num; ++i) {

			// 검사할 숫자를 문자열로 변환
			String check = "" + i;
			// System.out.println(check + " 검사 결과: ");

			// 문자열이 된 숫자를 하나씩 떼서 박수를 쳐야하는지 검사
			for (int j = 0; j < check.length(); ++j) {
				char ch = check.charAt(j);
				// System.out.printf("- %d번째 숫자 [%c] : ", j, ch);

				// "44839" → '4', '4', '8', '3', '9'
				if(ch == '3' || ch == '6' || ch == '9') {
					++clap;
					// System.out.println("짝");
				} else {
					// System.out.println();
				}
			}
		}
		System.out.println("총 박수 " +  clap + "회 입니다.");

		// 방법2.
		// 각 자릿수 분할
		// 1 2 3 4 5 % 10 ⇒ 5 ⇒ 5 / 10 = 1234
		// 1 2 3 4 % 10 ⇒ 4 ⇒ 4 / 10 = 1 2 3
		// 1 2 3 % 10 ⇒ 3 ⇒ 3 / 10 = 1 2
		// 1 2 % 10 ⇒ 2 ⇒ 2 / 10 = 1
		// 1 % 10 ⇒ 1 ⇒ 1 % 10 = 0

		clap = 0;

		for (int i = 3; i <= num; ++i) {

			int check = i;
			System.out.println("이번에 검사할 숫자 : " + check);

			// 십진수는 % 10으로 일의 자리를 분리할 수 있다.

			// 16진수는 % 16으로 일의 자리를 분리할 수 있다.
			// (보통 문자열로 분할하긴 하지만, 숫자로 분할 할 때 해결할 수 있어야 함)
			// 0xAB0123F .....??? 뭔 얘긴지 모르겠음

			// 2진수는 % 2로 일의 자리를 분리할 수 있다.
			while (check > 0) {
				System.out.printf("- %d : \n", check % 10);

				int digit = check % 10;

				if (digit != 0 && digit % 3 == 0) {
					System.out.println("짝");
					++clap;
				} else {
					System.out.println();
				}

				check /= 10;
			}
		}
	}
}