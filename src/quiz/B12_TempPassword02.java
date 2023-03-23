package quiz;

import java.util.Random;

public class B12_TempPassword02 {

	/*
문제.
[대문자, 소문자, 특수문자, 숫자]로 구성된 랜덤 비밀번호 6자리를 생성하여 출력해주세요.

※ 사용 가능한 특수문자
! @ # $ % ^ & * - _ + =  | : ; < > @ [ ] ^ ~ \
제외 : - ( ) ' { } / 
	 */

	public static void main(String[] args) {

		// 방법 1.
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvwxyz"
				+ "0123456789"
				+ "!@#$%^&*-_+=|:;<>@[]^\\~";

		Random ran = new Random();

		for (int i = 0; i < 6; ++i) {
			System.out.print(charset.charAt(ran.nextInt(charset.length())));
		}

		// 방법 2.
		//		Random ran2 = new Random();
		//		
		//		for (int i = 0; i < 6; ++i) {
		//			switch (ran.nextInt(4)) {
		//			case 0:
		//				// 숫자
		//				System.out.print((char)(ran.nextInt(10) + '0'));
		//				break;
		//			case 1:
		//				// 소문자
		//				System.out.print((char)(ran.nextInt(26) + 'a'));
		//				break;
		//			case 2:
		//				// 대문자
		//				System.out.print((char)(ran.nextInt(26) + 'A'));
		//				break;
		//			case 3:
		//				// 특수문자
		//				String charset = "!@#$%^&*-_+=|:;<>@[]^\\~";
		//		
		//				int random_index = ran.nextInt(charset.length()); // 0~-1?
		//				System.out.print(charset.charAt(ran.nextInt(charset.length()))); // random 위치의 문자를 하나 꺼내서 출력?
		//				break;
		//			}
		//		}
	}
}
