import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D10_Regex {

	/*

# 정규표현식 (Regular Expression)
· 문자열을 패턴으로 검사할 수 있는 표현식
· 특정 프로그래밍 언어에만 있는 것이 아닌 공통의 규칙
· 정의한 정규표현식과 일치하는 문자열을 찾을 수 있다.

# Java의 정규표현식 관련 클래스
· java.util.regex.Pattern
· Matcher

	 */

	public static void main(String[] args) {

		// Pattern.matches(regex, input) : input이 regex에 해당하는 문자열인지 검사하는 메서드
		System.out.println(Pattern.matches("sleep", "sleep"));

		// [] : 해당 위치에 올 수 있는 한 글자를 정의하는 정규표현식 문법
		System.out.println(Pattern.matches("s[lh]eep", "sheep"));
		System.out.println(Pattern.matches("s[lh]eep", "sleep"));
		System.out.println(Pattern.matches("s[lh]eep", "skeep"));
		System.out.println(Pattern.matches("[cs][lh]eep", "cleep"));
		System.out.println(Pattern.matches("[cs][lh]eep", "cheep"));
		System.out.println(Pattern.matches("[cs][lh]e[ea]p", "cheap"));
		System.out.println(Pattern.matches("[cs ][lh]e[ea]p", " heap")); // 공백도 가능
		System.out.println(Pattern.matches("01[016789]-","019-"));

		// \(역슬래시)는 정규표현식 내부에서도 특수문법으로 활용되므로 \\를 적어야 그냥 역슬래시를 의미한다.
		System.out.println(Pattern.matches("s[hk\\\\]ip","s\\ip"));
		System.out.println("---------------------------------");

		/*
		[abc] : a 또는 b 또는 c를 모두 허용
		[a-z] : a 부터 z까지 모두 허용
		[A-Z] : A 부터 Z까지 모두 허용
		[a-e&&c-z] : 두 조건을 모두 만족하는 문자를 허용
		 */

		System.out.println(Pattern.matches("[a-e&&c-f]ap", "cap"));
		System.out.println(Pattern.matches("[a-e&&c-f]ap", "dap"));
		System.out.println(Pattern.matches("[a-e&&c-f]ap", "bap"));
		System.out.println("---------------------------------");


		/*
# 하나로 여러 문자를 나타내는 것들
 · .  : 모든 문자 허용, [.]이나 \.은 그냥 .(점)만 허용한다는 뜻
 · \d : 모든 숫자 허용
 · \D : 숫자를 제외한 모든 것 허용
 · \s : space. 모든 공백을 허용(\t, \n,  , \r)
 · \S : 공백을 제외한 모든 것 허용
 · \w : 일반적인 문자들을 허용 ([a-z, A-Z, 0-9, _]와 같음) - ID 허용, 이메일 계정
 · \W : \w를 제외한 모든 것 허용
		 */

		System.out.println(Pattern.matches(".at", "$at"));
		System.out.println(Pattern.matches(".at", "갉at"));
		System.out.println(Pattern.matches(".at", "at")); //안 넣는 건 안된다.
		System.out.println(Pattern.matches("[.]at", ".at"));
		System.out.println(Pattern.matches("[.]at", "긱at"));
		System.out.println(Pattern.matches("....\\.jpg", "abcd.jpg"));
		System.out.println(Pattern.matches("....[.]jpg", "ship.jpg"));
		System.out.println(Pattern.matches("Windows\\d", "Windows7")); // 숫자 두자리
		System.out.println(Pattern.matches("Windows\\d\\d", "Windows10")); // 숫자 두자리
		System.out.println(Pattern.matches("\\d\\d\\s\\d", "1234")); // 숫자 2자리+공백+숫자
		System.out.println(Pattern.matches("\\d\\d\\s\\d", "12\n4")); // 숫자 2자리+공백+숫자
		System.out.println("---------------------------------");

		/*
# 해당 패턴이 적용될 문자의 개수를 지정하는 방법
· {n}   : {}앞의 패턴이 n개 일치해야 한다.
· {n,m} : {} 앞의 패턴이 n개 이상 m개 이하 일치해야 한다.
· {n,}  : {} 앞의 패턴이 n개 이상 일치해야 한다.
· ?     : ? 앞의 패턴이 0번 또는 한 번 나와야 한다.
· +     : + 앞의 패턴이 최소 한 번 이상 나와야 한다.
· *     : * 앞의 패턴이 0번 이상 나와야 한다.
		 */
		System.out.println(Pattern.matches("\\d{6}-\\d{7}", "123456-9999"));
		System.out.println(Pattern.matches("\\d{6}-\\d{7}", "123456-9999999"));

		System.out.println(Pattern.matches("\\d{2,4}", "1234")); // 정규표현식은 띄어쓰기 하면 안됨
		System.out.println(Pattern.matches("\\d{2,4}", "12"));

		System.out.println(Pattern.matches("\\w?[.]\\w+[.]\\w*[.]\\w+", ".abcdef..f"));
		System.out.println(Pattern.matches("\\w?[.]\\w+[.]\\w*[.]\\w+", "ab.abcdef..f"));
		System.out.println(Pattern.matches("\\w?[.]\\w+[.]\\w*[.]\\w+", "a.a.a.f"));
		System.out.println("---------------------------------");

		// 연습 1 : 해당 문자열이 핸드폰 번호인지 검사할 수 있는 정규표현식을 만들어보세요. (옛날번호 포함)
		String phoneRegex = "01[0126-9]-\\d{3,4}-\\d{4}";
		String phoneNumber = "123-1234-1234";

		System.out.println(Pattern.matches(phoneRegex, phoneNumber));

		// 연습 2 : 해당 문자열이 이메일인지 검사할 수 있는 정규표현식을 만들어보세요.
		// 전자우편 규칙
		// 전자 우편 주소의 로컬 파트는 아래의 ASCII 문자 중 어느 것이든 올 수 있다:
		// 대소문자 로마자 기본 A부터 Z, a부터 z
		// 숫자 0부터 9
		String emailRegex = "\\w+@\\w+[.]\\w+([.]\\w+)*"; // () 묶어서 한번에 나오게도 안나오게도 할 수 있다.
		String email = "abc@naver.net";

		System.out.println(Pattern.matches(emailRegex, email));


		// 연습 3 : 해당 문자열이 IPv4주소인지 아닌지 검사할 수 있는 정규표현식을 만들어보세요.
		//			(0.0.0.0 ~ 255.255.255.255)
		String ipAddress = "129.129.129.129";
		String ipRegex = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
				+ "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";

		// --- # Matcher 클래스 사용하기 ---
		String fruits = "apple banana orange kiwi pineapple mangoapple ";

		// 3번 반복
		StringBuilder sb = new StringBuilder(fruits);
		for (int i = 0; i < 3; ++i) {
			sb.append(sb); // = fruits += fruits;
		}

		fruits = sb.toString();

		// 1. 정규표현식을 컴파일하여 Pattern 인스턴스 생성
		// (\\w*)(apple) : 정규표현식에서 그룹으로 표현함
		Pattern appleRegex = Pattern.compile("(\\w*)(apple)"); // apple이 들어간 단어 검색

		// 2. 생성한 Pattern 인스턴스로 문자열을 탐색할 수 있는 Matcher 인스턴스를 생성
		Matcher matcher = appleRegex.matcher(fruits);

		String[] groupMessage = {"전체 텍스트", "첫 번째 괄호 부분", "두 번째 괄호 부분"};

		// 3. 반복문을 통해 매치 결과를 모두 찾을 수 있다
		// matcher.find() : 계속해서 다음껄 찾아준다.
		while (matcher.find()) {
			for (int i = 0; i <= matcher.groupCount(); ++i) {
				System.out.printf("### Group %d (%s) ###\n", i, groupMessage[i]);
				System.out.println("찾아낸 것 : " + matcher.group(i));
				System.out.println("찾아낸 것의 시작 인덱스 : " + matcher.start(i));
				System.out.println("찾아낸 것의 마지막 인덱스 : " + matcher.end(i));
			}
			System.out.println("----------\n");
		}
		// --- # Matcher 클래스 사용하기 ---
	}
}

