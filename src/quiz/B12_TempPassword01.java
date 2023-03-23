package quiz;

import java.util.Random;

public class B12_TempPassword01 {

	/*
문제.

알파벳 대문자로 구성된 랜덤 비밀번호 6자리를 생성하여 출력해보세요.
알파벳 대문자 : 65 ~ 90까지의 랜덤 숫자 6개를 생성하여 출력
알파벳의 갯수 : 26개 (90-65+1)
	 */

	public static void main(String[] args) {

		Random ran = new Random();

		// 65부터 90까지의 숫자를 만들고 싶다 ⇒ 0 ~ 25 + 65
		for (int i = 0; i < 6; ++i) {

			// 1. 원하는 숫자의 개수로 범위를 생성한다. : * 26
			// 2. 원하는 숫자의 최소값을 더한다 : + 'A'
			char ch = (char)(ran.nextInt(26) + 'A'); //알파벳이 26개니까

			System.out.print(ch);
		}
	}
}

