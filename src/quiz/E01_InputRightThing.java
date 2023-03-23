package quiz;

import java.util.Scanner;

public class E01_InputRightThing {

	/*
	 문제.
	 사용자로부터 nextInt()로 숫자를 입력받되
	 숫자가 아닌 문자를 입력하더라도 다시 입력받을 수 있는 프로그램을 만들어보세요
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = 0;

		while (true) {
			try {
				System.out.println("input number only : ");
				a = sc.nextInt(); // int a를 하고 출력하면 모르는 값이 되기 때문에 int a를 밖으로 빼고 a만 사용한다.
				break;
			} catch (Exception e) {
				System.out.println("잘못된 입력. 숫자만 입력해주세요.");
				System.out.println("스트림에 남아있던 것 : " + sc.nextLine()); // 잘못 입력된 값을 빼주는 여갛ㄹ
			}
		}
		System.out.println("받은 값 : " + a);
	}
}