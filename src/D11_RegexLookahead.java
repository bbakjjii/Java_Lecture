import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D11_RegexLookahead {

	/*
	 	# 정규표현식 Lookahead

	 	- 특정 정규표현식 앞에 있는 패턴을 잡아낼 수 있는 방식
	 	- 잘 응용하면 반드시 포함시키는 규칙을 만들어낼 수 있다

	 		apple(?=regex)  : regex 앞에 있는 apple를 찾아라
	 		apple(?!regex)  : regex 앞에 오지 않는 apple를 찾아라
	 		apple(?<=regex) : regex 뒤에 오는 apple를 찾아라
	 		apple(?<!regex) : regex 뒤에 오지 않는 apple를 찾아라

	 */

	public static void main(String[] args) {

		// step 1.
		String text = "apple@ @apple apple@ @apple apple@ @apple";

		// Pattern frontApple = Pattern.compile("apple(?=@)"); 
		// @ 앞에 있는 apple를 찾아라. @ 포함X
		Pattern frontApple = Pattern.compile("apple@"); // 이렇게 만들면 @가 포함된다.

		Matcher frontMatcher = frontApple.matcher(text);

		while(frontMatcher.find()) {
			System.out.println("found : " + frontMatcher.group());
			System.out.println("start : " + frontMatcher.start());
			System.out.println("end   : " + frontMatcher.end());
		}
		System.out.println("--------------------");

		// step 2.
		// 검사와 다음 문자를 찾는 것은 별개다.
		String text2 = "apple";
		String frontRegex2_1 = "app(?=l)e"; // false
		String frontRegex2_2 = "app(?=l)le"; // true

		System.out.println("# text2_1");
		System.out.println(Pattern.matches(frontRegex2_1, text2));
		System.out.println("--------------------");
		
		System.out.println("# text2_2");
		System.out.println(Pattern.matches(frontRegex2_2, text2));
		System.out.println("--------------------");

		// step 3.
		String text3 = "Hello, abcd1234!!! 3 4 5 6 78910 123 12 13333";
		String frontRegex3 = "(?=\\d)[1-3]{2,}"; // (?=숫자). 
		// 숫자로만 1-3까지의 숫자가 2개 이상 나와야한다.
		// ⇒ 숫자 앞에 아무것도 아닌 것이 와야 하고, .에는 숫자가 와야 함.
		// apple(?=regex)  : regex 앞에 있는 apple를 찾아라

		Pattern pattern3 = Pattern.compile(frontRegex3);

		Matcher matcher3 = pattern3.matcher(text3);
		System.out.println("# text3");
		while (matcher3.find()) {
			System.out.println("found : " + matcher3.group());
			System.out.println("start : " + matcher3.start());
			System.out.println("end   : " + matcher3.end());
		}
		System.out.println("--------------------");

		// step 4.
		String text4 = "a12";
		// a가 없거나 여러개, 숫자로만 4글자 이상이 나와야 true, a의 뒤로부터 3글자 이상
		// true : 글자를 소모하지 않아 맨 앞에서부터 검사하므로 3글자
		String frontRegex4_1 = "(?=a\\d)[a1-4]{3,}"; 
		// false : a 뒤부터 3글자여야 하므로 false
		String frontRegex4_2 = "a(?=\\d)[1-4]{3,}"; 
		System.out.println("# text4");
		System.out.println(Pattern.matches(frontRegex4_1, text4));
		System.out.println(Pattern.matches(frontRegex4_2, text4));
		System.out.println("--------------------");

		// step 5.
		String text5 = "Aab2cdefg@#$한글";
		// 검사 조건을 통과해야 조건에 맞으면 true 값을 찾을 수 있다?
		// (?=.*조건) :해당 조건이 순서에 상관없이 모두 들어가야 한다.
		// 정규표현식의 단점 : 어디서 걸려서 false가 나오는지(내가 부족한게 뭔지) 알려주지를 못한다.
		String frontRegex5_1 = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%])[\\dA-Za-z!@#$%]{6,}"; // 5글자이상인지 검사

		System.out.println("# test5");
		System.out.println(Pattern.matches(frontRegex5_1, text5));
	}
}
