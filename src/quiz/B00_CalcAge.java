package quiz;

import java.util.Scanner;

public class B00_CalcAge {
	public static void main(String[] args) {
	
	// 사용자로부터 태어난 해를 입력받으면 나이를 출력해주는 프로그램을 만들어 보세요.
	
		Scanner yearScanner = new Scanner(System.in);		
		
		int thisYear, birthYear, age;
		
		System.out.print("올해와 태어난 해를 입력해주세요 >> ");
		thisYear = yearScanner.nextInt();
		birthYear = yearScanner.nextInt();
		
		age = thisYear - birthYear + 1;
		
		System.out.printf("당신의 나이는 %d살 입니다.\n", age);
		
	}

}