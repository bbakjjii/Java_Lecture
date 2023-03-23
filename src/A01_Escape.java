


/*
	# Escape 문자
	· 특수한 기능을 가진 문자
	· 그냥 출력하기에 문자가 있는 문자들을 표현하기 위한 방식
	· \(역슬래시, Back Space 바로 옆 원화키)
	· \와 하나의 문자가 합쳐져서 특수한 기능을 한다.
	· \와 문자인 두 문자가 하나의 문자로 인식된다.
	· \n : 줄 바꿈의 기능을 가진 특수 문자
	· \t : Tab키의 기능을 가진 특수 문자. but Tab인지 Space인지 구분이 안됨.
	· \\ : Escape 문자의 기능을 사용하지 않고 그냥 역슬래시를 출력하고 싶을 때 사용한다. 한글폰트는 역슬래시가 원표시로 나움.
	· \" : 그냥 큰 따옴표를 출력하고 싶을 때 사용하는 특수 문자
	· \' : 그냥 작은 따옴표를 출력하고 싶을 때 사용하는 특수 문자
 */
public class A01_Escape {
	public static void main(String[] args) {

		System.out.println("안녕하세요 반갑습니다.");
		System.out.println("안녕하세요 반갑\n습니다.");

		System.out.println("안녕하세요 반갑\t습니다.");
		System.out.println("안녕하세요 반갑  습니다.");

		System.out.println("안녕하세요 반갑\\습니다.");
		System.out.println("C:\\JavaFullStack(박지영_No Delete)\\eclipse\\note");


		System.out.println("오늘 저녁은 \"피자\"를 먹는다");

		System.out.println("오늘 저녁은 \'햄버거\'를 먹는다");
		System.out.println('\'');
		System.out.println('A');
		System.out.println('한');
		System.out.println(' ');
		System.out.println('\n');
		System.out.println('\\');
		System.out.println('\t');	
	}
}