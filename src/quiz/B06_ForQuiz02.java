package quiz;

import java.util.Scanner;

public class B06_ForQuiz02 {

	/*
	사용자로부터 숫자를 입력받으면
 	0부터 해당 숫자 사이에 존재하는 모든 5의 배수를 한 줄에 10개씩 출력해보세요
 	(음수를 입력받는 경우에도 올바르게 동작해야 합니다)
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("아무 숫자나 입력 > ");
		int num = sc.nextInt();

		System.out.printf("[0부터 %d까지 모든 5의 배수 목록]\n", num);

		if (num > 0) { // 양수일 때는 증가하는 for문을 사용할 것이고
			for (int i = 0, cnt = 1; i < num; i += 5, ++cnt) {
				// 줄 바꾸기
				System.out.printf("%5d ", i);
				// %5d : 숫자만큼 자릿수 확보
				if (cnt % 10 == 0) {
					System.out.println();
				}
			}
		} else { // 음수일 때는 증감하는 for문을 사용할 것이다.
			for (int i = 0, cnt = 1; i > num; i -= 5, ++cnt) {
				// 줄 바꾸기
				System.out.printf("%5d ", i);
				if (cnt % 10 == 0) {
					System.out.println();
				}
			}
		}
	}
}



