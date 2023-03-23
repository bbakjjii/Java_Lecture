/*
	# 콘솔에 출력하는 함수들
	1. println()
	· () 안에 전달한 데이터를 콘솔에 출력하면서 줄을 자동으로 바꿔준다.
	· print() + '\n'

	2. print()
	· () 안에 전달한 데이터를 콘솔에 출력한다.

	3. printf()
	· print format
	· 서식을 이용해 원하는 출력 형태를 미리 만들어 놓는 출력(print) 방식
	· 서식 문자 자리에 값을 순서대로 채워서 사용한다
	· \n이 자동으로 추가되지 않으므로 주의해야 한다.

	3-1. printf() 서식 문자의 종류
	· %d : 해당 자리에 전달한 정수값을 10진수로 출력 (decimal)
	· %x : 해당 자리에 전달한 정수값을 16진수로 출력 (a~f)
	· %X : 해당 자리에 전달한 정수값을 16진수로 출력 (A~F)
	· %o : 해당 자리에 전달한 정수값을 8진수로 출력
	· %s : 문자열
	· %c : 문자
	· %f : 실수 (double, float)
	· %% : 그냥 %를 출력하고 싶을 때 사용

	3-2. prinf() 서식 문자의 옵션
	· 서식 문자의 %와 문자 사이에 넣어서 사용
		ex) System.out.printf("몸무게 : %.1f\n", weight);
	1) %숫자d
	· 숫자만큼 자릿수를 확보하면서 출력한다.
	2) %-숫자d
	· 숫자만큼 자릿수를 확보한 후 왼쪽 정렬하여 출력
	3) %0숫자d
	· 숫자만큼 자릿수를 확보하고 빈자리에 0을 채우면서 출력
 */

public class A06_Print {	
	public static void main(String[] args) {

		int number = 12345;

		//1) %숫자d : 숫자만큼 자릿수를 확보하면서 출력한다.
		System.out.printf("%10d:\n", number);

		// 2) %-숫자d : 숫자만큼 자릿수를 확보한 후 왼쪽 정렬하여 출력
		System.out.printf("%-10d:\n", number);

		// 3) %0숫자d : 숫자만큼 자릿수를 확보하고 빈자리에 0을 채우면서 출력
		System.out.printf("%020d:\n", number);


		String fruitName = "Apple";
		int fruitPrice = 1500;
		// %-숫자s : 숫자만큼 자릿수를 확보한 후 왼쪽 정렬하여 출력
		System.out.printf("%-8s:%6d\n", fruitName, fruitPrice);
		// %숫자s : 숫자만큼 자릿수를 확보하면서 출력한다.
		System.out.printf("%8s:%6d\n", fruitName, fruitPrice);



		// %s : 문자열
		String name = "민수";
		String message = "Nice to meet you!";
		System.out.printf("%s님이 남긴 메세지 입니다. \"%s\"\n", name, message);


		int ch = 88;
		// 문자 X의 코드값은 88 (ASCII 코드)
		System.out.printf("문자 '%c'의 코드값은 [%d]입니다.\n", ch, ch);


		double weight = 75.873453;
		// 옵션 : % 뒤에 .1(0.1), .2(0.01), ... 붙이면 소수점 자릿수 조절 가능
		System.out.printf("몸무게 : %.1f\n", weight);
		System.out.printf("이자율 : %f%%\n", weight);


		int a = 15;
		System.out.printf("a에 들어있는 값은 10진수로 %d이고, 16진수로 %x입니다.\n", a, a);
		System.out.printf("a에 들어있는 값은 10진수로 %d이고, 16진수 소문자로 표현하면 %x이고, "
				+ "16진수 대문자로 표현하면 %X이고, 8진수로 표현하면 %o 입니다.\n", a,a,a,a);


		int year = 2022;
		int month = 10;
		int date = 6;
		int hour = 9;
		int minute = 25;
		int second = 1;

		System.out.println("오늘은 " + year + "년 " + month + "월 " + date + "일이고, " + "현재 시간은 " +
				hour + "시 " + minute + "분 " + second + "초 입니다.");
		System.out.printf("오늘은 %d년 %d월 %d일이고, " + "현재 시간은 %d시 %d분 %d초 입니다.\n", 
				year, month, date, hour, minute, second);


		// # 10진수, 8진수, 16진수
		for (int num = 1; num <= 17; ++num) {
			System.out.printf("10진수 %d은 8진수로 %o, 16진수로 %x\n", num, num, num);
		}
	}
}
