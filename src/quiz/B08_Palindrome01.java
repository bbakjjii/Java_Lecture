package quiz;

import java.util.Scanner;

public class B08_Palindrome01 {

	/*
문제. 사용자가 단어를 입력하면 해당 단어가 완벽하게 좌우대칭인지 판별해주는 프로그램을 만들어보세요.

보기.
>> Level
→ 좌우대칭이 아닙니다.
>> level
→ 좌우대칭입니다.
>> abba
→ 좌우대칭입니다.
	 */

	/*
 # 문제를 잘 못 푸는 이유
 1. 문제 푸는 절차를 잘못 생각한 경우
 · 내 머리로는 풀 수 없는 경우 : 심각
 · 풀 수 있지만 절차적으로 변환이 안되는 경우 : 경험 부족
 2. 어떻게 만들어야되는지는 아는데 자바 문법을 모르는 경우
 · 복습을 열심히 해야 한다.
 · 틀린 문제를 또 틀리면 안된다.
 3. 기계처럼 생각하지 않는다.
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String word;		
		System.out.print("단어를 입력 > ");
		word = sc.next();

		// for문 예.
		// 01234567
		// Straight : 8글자
		// i : 0 ⇒ word.length() - i - 1 : 7
		// i : 1 ⇒ word.length() - i - 1 : 6
		// i : 2 ⇒ word.length() - i - 1 : 5
		// i : 3 ⇒ word.length() - i - 1 : 4
		// i : 4 ⇒ word.length() - i - 1 : 3
		// i : 5 ⇒ word.length() - i - 1 : 2
		// i : 6 ⇒ word.length() - i - 1 : 1
		// i : 7 ⇒ word.length() - i - 1 : 0

		// 방법 1. : i번째 글자와 len-i번째 글자가 모두 일치하면 좌우 대칭
		boolean palindrome = true; // **

		for (int i = 0; i < word.length() / 2; ++i) {
			int i2 = word.length() - 1 - i;

			// i : 0 1 2 3 4 5 6 7 8 9 10 ... len-1 : 단어 길이에 따라
			char ch1 = word.charAt(i);
			char ch2 = word.charAt(i2);

			if (ch1 == ch2) {
				System.out.printf("%d번째 [%c]와 %d번째 [%c]가 일치합니다.\n", i, ch1, i2, ch2);
				// palindrome = true; ** 이것까지 입력하면 값이 출력 안됨
			} else {
				System.out.printf("%d번째 [%c]와 %d번째 [%c]가 일치하지않습니다.\n", i, ch1, i2, ch2);
				palindrome = false; // **
			}
		}
		System.out.println("좌우대칭 여부 : " + palindrome); // **
	}
}







