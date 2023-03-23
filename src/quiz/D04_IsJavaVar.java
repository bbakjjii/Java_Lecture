package quiz;

import javax.lang.model.SourceVersion;

public class D04_IsJavaVar {

	/*
	 문제.
	 1. 문자열을 매개변수로 전달하면 해당 문자열이 자바 변수로써 사용할 수 있는 문자열인지
	 검사해주는 메서드를 만들어보세요. 
	 2. 추가로 예약어인지 아닌지 알려주는
	 - true, false
	 */

	public static boolean isJavaVar (String word) {

		// isKeyword : 예약어인지 아닌지 알려줌
		// 예약어라면 변수로 사용할 수 없다.
		if (SourceVersion.isKeyword(word)){
			System.out.println("예약어는 변수로 사용할 수 없습니다.");
			return false;
		}

		if (!Character.isJavaIdentifierStart(word.charAt(0))){
			System.out.printf("[%s]의 첫 번째 글자가 자바 변수에 사용할 수 없는 문자입니다.", word);
			return false;
		}

		for (int i = 1; i < word.length(); ++i) {
			if (!Character.isJavaIdentifierPart(word.charAt(i))) {
				System.out.printf("[%s]의 %d 번째 글자가 자바 변수에 사용할 수 없는 문자입니다.", word, i + 1);
			}
		}	
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isJavaVar("sevenEleven"));
		System.out.println(isJavaVar("7Eleven"));
		System.out.println(isJavaVar("se#ven"));
		System.out.println(isJavaVar("public"));
		System.out.println(isJavaVar("void"));
		System.out.println(isJavaVar("int"));	
		System.out.println(SourceVersion.isIdentifier("apple123"));
		System.out.println(SourceVersion.isIdentifier("apple1 23"));
		System.out.println(SourceVersion.isIdentifier("2est"));
	}
}
