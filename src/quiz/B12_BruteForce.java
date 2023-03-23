package quiz;

import java.util.Random;

public class B12_BruteForce {

	/*
문제.
4자리의 비밀번호가 있을 때 비밀번호를 찾을 때 까지 모든 비밀번호를 대조하는 프로그램을 만들어보세요.

 aaaa
 aaab
 ...

	 */

	public static void main(String[] args) {

		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvwxyz"
				+ "0123456789"
				+ "!@#$%^&*-_+=|:;<>@[]^\\~";

		// String password = "1a#V";
		// System.out.println("" + 'A' + 'B'); // String으로 인식하기 위해서 ""를 붙인 것 예시

		String password = "";

		Random ran = new Random();

		for (int i = 0; i < 4; ++i) {
			password += charset.charAt(ran.nextInt(charset.length()));
		}
		System.out.println("생성된 임시 비밀번호: " + password);

		for (int i = 0; i < charset.length(); ++i) {
			for (int j = 0; j < charset.length(); ++j) {
				for (int k = 0; k < charset.length(); ++k) {
					for (int l = 0; l < charset.length(); ++l) {
						String brute = "" // String으로 인식하기 위해서 "" 붙인 것
								+ charset.charAt(i)
								+ charset.charAt(j)
								+ charset.charAt(k)
								+ charset.charAt(l);

						if (brute.equals(password)) {
							System.out.println("비밀번호는 [" + brute + "]입니다.");
						}

						//			System.out.print(charset.charAt(i));
						//			System.out.print(charset.charAt(j));
						//			System.out.print(charset.charAt(k));
						//			System.out.print(charset.charAt(l));
						//			System.out.println();
					}
				}
			}
		}
	}
}