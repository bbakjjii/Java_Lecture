package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class D10_CheckPassword {

	/*
		사용자가 사용하고 싶은 비밀번호를 입력하면 사용할 수 있는 비밀번호인지 체크한 후
		한 번 더 동일하게 입력하도록 만들어보세요
		(사용할 수 있는 비밀번호의 조건 - 아무 유명한 사이트 회원가입을 참조)

		영대문자(A~Z, 26개), 영소문자(a~z, 26개), 숫자(0~9, 10개) 및 특수문자(32개) 중 3종류 이상으로 구성하여 최소 9자 이상으로 입력합니다.
		※ 특수문자 32개 예시
		~․!@#$%^&*()_-+=[]|\;:'"<>,.?/
	 */

	// -- 정규표현식을 사용해서 만들기 --
	private static String passwordRegex = "(?=.*\\\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%])[\\dA-Za-z!@#$%]{8,16}";

	public static boolean isValidPassword2(String userPass) {
		return Pattern.matches(passwordRegex, userPass);		
	}

	// -- if else문으로 만들기 --
	public static boolean isValidPassword (String userPass) {

		// 정규표현식의 단점 : 어디서 걸려서 false가 나오는지(내가 부족한게 뭔지) 알려주지를 못한다.
		// \\+ : 이스케이프를 걸어주다.
//		String passRegex = "[a-zA-Z0-0~!@#\\$%\\^\\&\\*\\_\\-\\+\\=\\`|\\(\\)\\{\\}\\[\\]:;\"'<>,.?/]{8,16}";
//
//		if (!Pattern.matches(passRegex, userPass)) {
//			System.out.println("포함되면 안되는 문자가 있습니다!");
//			return false;
//		}

		// if else로 비밀번호 검사를 구현하면 무엇때문에 안됐는지 자세히 표현이 가능하다.
		int len = userPass.length();

		if (len < 8 || len > 16) {
			System.out.println("비밀번호의 길이가 잘못되었습니다.");
			return false;
		}

		if (!Pattern.matches("[a-zA-Z\\d!@#$%]{8,16}", userPass)) {
			System.out.println("사용하면 안되는 문자를 사용하셨습니다. (소문자, 대문자, 숫자, 특수문자만 사용 가능)");
			return false;
		}

		// String mustHave = "!@#$%";
		List<Character> mustHave = new ArrayList<>();
		Collections.addAll(mustHave,'!', '@', '#', '$', '%');

		boolean digit = false, lower = false, upper = false, special = false;

		for (int i = 0; i < len; ++i) {
			char ch = userPass.charAt(i);

			if (Character.isLowerCase(ch)) {
				lower =  true;
			} else if (Character.isUpperCase(ch)) {
				upper = true;
			} else if (Character.isDigit(ch)) {
				digit = true;
			} else if (mustHave.contains(ch)){
				special =  true;
			}
		}

		if (!digit) {
			System.out.println("숫자 미포함");
			return false;
		} else if (!upper) {
			System.out.println("대문자 미포함");
			return false;
		} else if (!lower) {
			System.out.println("소문자 미포함");
			return false;
		} else if (!special) {
			System.out.println("특수문자 미포함");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String userPass;
			while (true) {
				System.out.println("사용하고 싶은 비밀번호 입력 >> ");
				userPass = sc.nextLine();
				if (isValidPassword(userPass)) {
					break;
				}
			}
			System.out.println("다시 한번 입력 >> ");
			if (userPass.equals(sc.nextLine())) {
				System.out.println("일치합니다!");
				break;
			} else {
				System.out.println("확인한 비밀번호가 일치하지 않습니다. 처음부터 다시 합니다. ");
			}
		}
	}
}
