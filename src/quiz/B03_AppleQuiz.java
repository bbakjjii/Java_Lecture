package quiz;

import java.util.Scanner;

public class B03_AppleQuiz {

	/*
Q. 사과를 10개씩 담을 수 있는 바구니가 있다.
 	사용자가 사과의 개수를 입력하면 사과를 모두 담기 위해 필요한
 	바구니의 개수를 알려주는 프로그램을 만들어보세요.
 	⇒ 한 페이지에 게시글이 등장하는 사이즈 구하는 방법
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("사과 개수를 입력해보세요. >> ");	
		int appleQty = sc.nextInt(); // 입력 받는 숫자
		int basketSize = 10;
		int answer;

		answer = (int)Math.ceil(appleQty / (double)basketSize); // 정답 2. if문 없이 Math.ceil 사용

		// ★ 잘못된 입력에 대한 검증은 가장 먼저 하는 것이 좋다.
		if (appleQty <= 0){
			answer = 0;
		} else if (appleQty % basketSize > 0) {		
			answer = appleQty / basketSize + 1;			
		} else {
			answer = appleQty / basketSize;			
		}		

		System.out.printf("필요한 바구니의 개수는 %d개 입니다 ", answer);

	}

}
