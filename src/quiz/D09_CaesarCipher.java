package quiz;

public class D09_CaesarCipher {

	/*
	 # 시저 암호
	 · 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 암호화하는 암호 방식
	 · 키 값만큼 평문의 모든 알파벳을 오른쪽으로 밀어주면 암호화가 되고
	 	암호문을 다시 왼쪽으로 키 값만큼 밀어주면 복호화가 된다
	 	ABCDEFGHIJKLMNOPQRSTUVWXYZ
	 	      Key가 5일때
	 	HELLO ----------> MJQQT
	 */

	// static : 키값이 달라도 항상 동일하게 적용 가능
	// 문자모음(대문자, 소문자, 한글)
	private final static String UPPER_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // H-A = 7
	private final static String LOWER_CHARSET = "abcdefghijklmnopqrstuvwxyz";
	
	// final은 선언만 해놓고 나중에 쓸 수가 없다. 그렇기 때문에 여기서 다른 함수(메서드)를 호출해서 불러다가 사용해야한다.
	private final static String KOR_CHARSET= getKorSet();
		
	// 키값 설정 : 새로 만들때마다 키값을 다시 설정
	int key;

	public D09_CaesarCipher(int key) {
		// 알파벳 총 개수 이상의 값을 넣어도 동작이 잘 되게 % 26을 한다.
		this.key = key % 26;
	}
	
	// 한글 : final은 선언만 해놓고 나중에 쓸 수가 없다. 그렇기 때문에 여기서 다른 함수(메서드)를 호출해서 불러다가 사용해야한다.
	public static String getKorSet() {
		StringBuilder sb = new StringBuilder();
		
		for (char i = '가'; i <= '힣'; ++i) {
			sb.append(i);
		}
		
		return sb.toString();
	}
	
	// -- E07_FileDecryption -- 
	public void setKey(int key) {
		this.key = key;
	}
	// -- E07_FileDecryption --
	
	// 암호화
	public String encrypt(String plain) {

		StringBuilder sb = new StringBuilder(plain); // append를 하나 바로 하나 똑같음

		int len = sb.length();

		for (int i = 0; i < len; ++i) {
			char ch = sb.charAt(i); // key만큼 더하면 오른쪽으로 문자열을 보내는 효과가 있다.
			int index, len2;

			if (Character.isUpperCase(ch)) {
				len2 = UPPER_CHARSET.length();
				index = ch - 'A' + key % len2; // 대문자라면 인덱스가 - A로 나온다
				index = index >= len2 ? index - len2 : index;
				ch = UPPER_CHARSET.charAt(index);  
			} else if (Character.isLowerCase(ch)) {
				len2 = LOWER_CHARSET.length();
				index = ch - 'a' + key % len2;
				index = index >= len2 ? index - len2 : index;
				ch = LOWER_CHARSET.charAt(index);
			} else if (ch >= '가' && ch <= '힣') {
				len2 = KOR_CHARSET.length();
				index = ch - '가' + key % len2;
				index = index >= len2 ? index - len2 : index;
				ch = KOR_CHARSET.charAt(index);
			}
			sb.setCharAt(i, ch);
		}
		return sb.toString(); 
	}

	// 복호화
	public String decrypt(String crypto) {
		StringBuilder sb = new StringBuilder(crypto);
		int len = sb.length();

		for (int i = 0; i < len; ++i) {
			char ch = sb.charAt(i);
			int index, len2;
			
			if (Character.isUpperCase(ch)) {
				ch -= key % 26;
				ch = (char) (ch < 'A' ? ch + 26 : ch);
			} else if (Character.isLowerCase(ch)) {
				ch -= key % 26;
				ch = (char) (ch < 'a' ? ch + 26 : ch);
				// 연습문제 - 한글 복호화 구현하기
			} else if (ch >= '가' && ch <= '힣') {
				ch -= key % len;
				ch = (char)(ch < '가' ? ch + ('힣' - '가') + 1 : ch);
								
			} // 연습문제 - 한글 복호화 구현하기
			
			sb.setCharAt(i, ch);
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		String plainText = "Hello, world!! 감사합니다 땡큐";

		// 각 인스턴스마다 키값을 다르게 해서....(?)
		// 인스턴스 : cipher1, cipher2 - 키값을 각자 가지고 있어야 함
		D09_CaesarCipher cipher1 = new D09_CaesarCipher(1);
		D09_CaesarCipher cipher2 = new D09_CaesarCipher(13);

		System.out.println("key 1 : " + cipher1.encrypt(plainText));
		System.out.println("key 13 : " + cipher2.encrypt(plainText));
		
		String crypto1 = "Ifmmp, xpsme!! 갑삭핪닉닥 땢큑";
		String crypto2 = "Uryyb, jbeyq!! 객삹핶닕닱 땮큝";
		System.out.println(cipher1.decrypt(crypto1));
		System.out.println(cipher2.decrypt(crypto2));
	}
}

