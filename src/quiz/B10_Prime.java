package quiz;

import java.util.Scanner;

public class B10_Prime {

	/*
문제.
사용자로부터 숫자(양수)를 입력받으면 1부터 입력한 숫자 사이에 있는 모든 소수를 출력해보세요.

※ 소수 : 나누어 떨어지는 수가 1과 자기 자신밖에 없는 수
ex) 2, 3, 5, 7, 11, 13 ...
※ 사용자가 잘못된 숫자를 입력하는 경우 다시 제대로 입력하게 만들 것
	 */

	public static void main(String[] args) {

		int num;	
		Scanner sc = new Scanner(System.in);

		for (;;) {
			System.out.print(">> ");
			num = sc.nextInt();

			// num에 원하는 숫자가 들어와야 반복문을 탈출할 수 있다.
			if (num > 1) {
				break;
			}
			System.out.println("2 이상의 숫자를 입력하세요.");
		}

		for (int i = 2; i <= num; ++i) {
			boolean prime = true;

			// i가 소수인지 검사
			// 방법 1. i를 1부터 i까지의 숫자로 모두 나누어 본다.
			// 모두 나누었을 때 약수가 2개라면 소수다. 2개 이상이면 소수가 아니다.
			// 방법 2. i를 2부터 자기 자신 직전까지의 숫자로 나눈다.
			// 이때 나누어 떨어지는 수가 없으면 소수다.
			// 즉 나누어 떨어지는 숫자가 하나라도 있으면 소수가 아니다.
			// 방법 3. i를 2부터 검사하는 숫자의 제곱근까지의 숫자로 나눈다.
			// ★ 알고리즘을 짠다 ★		

			// 방법 2.
			// for (int j = 2; j < i; ++j) {
			// if (i % j == 0) {
			//	prime = false;
			// 	break;
			// 	}
			// }

			// 방법 1.
			int count = 0;
			for (int j = 1; j <= i; ++j) {
				if (i % j == 0) {
					count++;
				}
			}

			prime = count == 2;

			if (prime) {	// prime이 true일 때만 출력		
				System.out.printf("%d은 소수인가요? %s\n", i, prime);
			}
		}
	}
}
