package quiz;

import java.nio.file.spi.FileSystemProvider;

import java.util.Scanner;

public class B02_ConditionQuiz02 {

	/*
# 알맞은 조건식을 만들어보세요.
1. char형 변수 a가 'q' 또는 'Q'일 때 true
2. char형 변수 b가 공백이나 탭이 아닐 때 true
3. char형 변수 c가 '0' ~ '9' 일 때 true
4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
5. char형 변수 e가 한글일 때 true
6. 사용자가 입력한 문자열이 quit일 때 true
	 */

	public static void main(String[] asg) {


		// 1. char형 변수 a가 'q' 또는 'Q'일 때 true
		char a = 'Q';

		System.out.println((int)'q');
		System.out.println((int)'Q');

		System.out.println(a == 'q' || a == 'Q'); // 정답 1
		System.out.println(a == 81 || a == 113); // 정답 2 (ASCII 코드)

		System.out.println("=====");


		// 2. char형 변수 b가 공백이나 탭이 아닐 때 true
		char b = '\n';
		System.out.println(b != ' ' && b != '\t');
		System.out.println(!(b == ' ' || b == '\t'));
		System.out.println("=====");


		// 3. char형 변수 c가 '0' ~ '9' 일 때 true
		char c = '9';

		System.out.println((int)'\t');
		System.out.println((int)'9');

		System.out.println(c >= '0' && c <= '9');
		System.out.println("=====");


		// 4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
		char d = 'N';
		boolean isUpperCase = d >= 'A' && d <= 'Z';
		boolean isLowerCase = d >= 'a' && d <= 'z';
		System.out.println(isUpperCase || isLowerCase);
		System.out.println("=====");


		// 5. char형 변수 e가 한글일 때 true
		// ⇒ 한글 ID 만들 때 사용
		char e = '철';

		// 16진수 리터럴 : 한글 코드
		System.out.println((char)0xAC00); // 한글코드
		System.out.println((char)0xAC01); // 한글코드
		System.out.println((char)0xAC02); // 한글코드
		System.out.println((char)0xAC0F); // 한글코드
		System.out.println((char)0xAC10); // 한글코드

		// 정답
		System.out.println(e >= '가' && e <= '힣');
		System.out.println(e >= 0xAC00 && e <= 0xD7A3); // 한글코드 사용한 정답 (16진수)
		System.out.println(e >= 44032 && e <= 552030); // AC00 = 44032, D7A3 = 552030 (10진수)
		System.out.println("=====");
		/*
 # 계산기(프로그램용)
 HEX : 16진수
 DEC : 10진수
 OCT : 8진수
 BIN : 2진수
		 */

		// 6. 사용자가 입력한 문자열이 quit일 때 true
		// 8byte * 1024 = 8,192Mb
		Scanner sc = new Scanner(System.in) ;

		String command;

		System.out.println("문자를 입력하세요. >> ");

		command = sc.next(); // 사용자가 입력한 문자열
		System.out.println("Quit? " + (command.equals("quit")));
	}
}