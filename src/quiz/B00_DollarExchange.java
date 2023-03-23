package quiz;

import java.util.Scanner;

public class B00_DollarExchange {

	/* 원을 입력 받으면 달러로 얼마인지 계산해주는 프로그램을 만들어보세요. */


	public static void main(String[] args) {

		int won;
		double dollar;

		System.out.print("한국 돈을 입력 > ");
		won = new Scanner(System.in).nextInt();

		// * 정수와 실수의 계산 결과는 실수가 된다.	
		dollar = won / 1400.8;

		System.out.printf("%d원은 %.2f달러입니다.\n", won, dollar);		
	}
}

