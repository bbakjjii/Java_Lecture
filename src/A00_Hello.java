
/*  
	# 주석(Comment)
	· 개발자가 하고 싶은 말을 적어 놓는 것
	· 컴파일시에 무시되기 때문에 프로그램 실행에 영향을 미치지 않는다.
	· 언어별로 주석을 사용하는 방법이 다를 수 있다.
	· 한 줄 주석(//)과 여러 줄 주석('/**'/)이 있다.  

	# Windows 단축키
	· [Win] : 시작 메뉴
	· [Win] + E : 탐색기
	· [Win] + 방향키 : 창 크기 조절
	· [Win] + Shift + S : 스크린샷 (스크린샷 후 카카오톡 등에 붙여넣기 가능)

	# Eclipse 단축키
	· Ctrl + [+, -] : 글자 크기 조정
	· Ctrl + M : 현재 창 최대/최소화 
	· Ctrl + F11 : 소스 코드 컴파일 및 실행 (빌드)
	· Alt + 위/아래 : 줄 이동
	· Tab : 들여쓰기
	· Shift + Tab : 거꾸로 들여쓰기
	· Ctrl + Z : 방금 했던 것 취소하기
	· Ctrl + Y : 방금 취소했던 것 다시하기

	# 블록지정 단축키
	· Home : 커서를 현재 줄 맨 앞으로 이동
	· End : 현재 줄의 맨 뒤로 이동
	· Insert : 커서의 모드를 수정/삽입 모드로 전환
	· Shift + 방향키 : 커서를 이동하며 원하는 만큼 블록지정하기
	· Shift + Home : 현재 커서 위치부터 맨 앞까지 블록지정
	· Shift + End : 현재 커서 위치부터 맨 뒤까지 블록지정
	· Ctrl + A : 전체 문서를 블록지정
	· Ctrl + C : 복사하기
	· Ctrl + X : 잘라내기
	· Ctrl + V : 복사하거나 잘라낸 것을 붙여넣기
	
	# public class A00_Hello {
	· public class의 이름은 반드시 파일명과 같아야 한다
	
	# 에러(F2)
	· Eclipse에서 빨간 줄이 생겼을 때(에러) 그곳에 커서를 두고 F2를 누르면 해당 에러에 대한 정보와 간단한 해결책을 볼 수 있다.

	# main() 함수
	· Java에서 어떤 단어 뒤에 ()가 있으면 함수(메서드)라고 한다
	· main() 함수는 프로그램의 시작 지점
	· 사용자가 프로그램을 실행하면 가장 먼저 main() 함수를 찾아서 실행한다
	· main() 함수가 종료되면 프로그램도 종료된다
	· main() 함수에 오타가 있으면 프로그램 시작 지점을 찾지 못한다 
	· main() 함수의 범위는 {}로 지정한다
	
	# public static void main(String[] args) {
	· 프로그램 시작시 가장 먼저 도착하는 곳
	
	# System.out.println() 함수
	· ()안에 전달한 데이터를 콘솔 화면에 출력하는 함수

	# 콘솔 (Console)
	· 글자만 나오는 환경의 화면 (Command Line Interface, CLI)
	· Eclipse에서는 테스트용 콘솔을 제공해준다
	· 우리가 만드는 프로그램은 실제 콘솔에서도 동일하게 동작한다 (cmd, cd, java, ...)
	· 제작한 소스코드(.java)의 컴파일 결과 (.class)는 프로젝트 내부의 bin 폴더에 저장된다

	# 세미콜론(;)
	· 한 명령어가 끝났음을 컴파일러에게 알리는 문자
	
	# 자바의 데이터 종류 (리터럴의 종류)
	· "" 사이에 적는 것 : 문자열(String), 문자를 여러개 적을 수 있다
	· '' 사이에 적는 것 : 문자(character), 문자를 하나만 적을 수 있다
	· 숫자를 적는 것 : 정수(Integer), 계산 가능
	· 소수를 적는 것 : 실수(Float, Double), 계산 가능
	· true/false : 참/거짓(Boolean)
	
	# 이름 규칙
	· package명 : 소문자
	· class명 : 대문자로 시작
*/

public class A00_Hello {
	public static void main(String[] args) {
		System.out.println("Hello, world!!!!!");
		
		System.out.println("Welcome to my server!");
		System.out.println('한');
		System.out.println(12345);
		System.out.println(12345 * 123);
		System.out.println(12345 + 123);
		System.out.println(12345 - 123);
		System.out.println(123.45 * 11);
		System.out.println(true);
		System.out.println(false);
		System.out.println("true");
	
		// 문자열과 다른 타입을 + 하면 이어붙인다
		System.out.println(10 + 10);
		System.out.println("10" + 10);
		System.out.println(10 + "10");
		System.out.println("총 가격 : " + 1580 + "원");
		System.out.println("총 가격 : " + (1580 + 1580) + 1580 + "원"); // "총 가격 :" 과 만나면서 문자로 인식됨
		
		System.out.println("Hello, " + "sausage!");
		System.out.println("Hello! " + true);
		System.out.println("Hello! " + 123.1234);
		
	} // 프로그램의 끝
}
