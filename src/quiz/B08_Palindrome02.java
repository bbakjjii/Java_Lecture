package quiz;

public class B08_Palindrome02 {

	public static void main(String[] args) {

		// 방법 2. : 글자를 거꾸로 만든 후 거꾸로 되기 전과 같으면 좌우 대칭
		// 비어있는 문자열에 문자를 하나씩 계속 이어붙여 문자를 만들 수 있다.
		//		String reversed = ""; 							
		//		reversed += 'e';
		//		reversed += 'l';
		//		reversed += 'p';
		//		reversed += 'p';
		//		reversed += 'a';
		//		System.out.println(reversed.equals("apple"));

		String example = "level";
		String reversed = "";

		for (int i = example.length() - 1; i >= 0; --i) {
			reversed += example.charAt(i);
		}
		System.out.println("원래 문자열: " + example);
		System.out.println("뒤집은 문자열: " + reversed);
		System.out.println("좌우대칭이니? " + example.equals(reversed));
	}
}






