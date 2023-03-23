package quiz;

import java.util.Scanner;

public class B04_MonthToSeason {

	/*
# 사용자로부터 몇 월인지 입력받으면 해당하는 계절을 출력해보세요.
  (반드시 Switch-case문을 사용할 것) 
	 */

	public static void main(String[] args) {

		String season; // 왜 입력할까...??
		int month;


		System.out.print("몇 월인가요? ");

		switch (month = new Scanner(System.in).nextInt()) {
		// new Scanner 새로운 스캐너를 만들고     // nextInt 새로운 스캐너의 통로에서 값을 받아오고
		case 12: case 1: case 2:
			season = "겨울";
			break;
		case 3: case 4: case 5:
			season = "봄";
			break;
		case 6: case 7: case 8:
			season = "여름";
			break;	
		case 9: case 10: case 11: 
			season = "가을";
			break;
		default:
			season = "없음";
			break;
		}

		System.out.printf("%d월은 %s입니다.\n", month, season);
		// 시즌에 빨간줄이 뜨는 이유 : default값에 season이 설정 안되어 있어서
	}
}
