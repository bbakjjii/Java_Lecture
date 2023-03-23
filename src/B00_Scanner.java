/*
	# import(불러오기)

	· Ctrl + Shift + O : Eclipse 자동 import 단축키
	· 다른 패키지에 만들어 놓은 다른 클래스를 여기에 사용하기 위한 문법
	· 같은 패키지에 만들어 놓은 다른 클래스는 import를 하지 않고 사용할 수 있다.

	# java.util.Scanner 클래스
	· 프로그램으로 입력을 받을 수 있는 여러 기능들이 모여있는 클래스
	· 어느곳으로부터 입력 받을지 결정한 뒤 스캐너를 생성하여 사용한다.

	# Scanner
	· 다른 패키지의 다른 클래스를 가져다 쓰는 문법.
	· Scanner 사용(java.util 패키지의 Scanner 클래스)
	· 사용자의 입력을 받아오는 기능을 하는 코드

	# Scanner 코드 사용법
	Scanner a = new Scanner(System.in);
	- new Scanner를 활용하여 System.in으로 들어온 사용자의 입력을 받고 입력받은 덩어리를 a에 저장
	String b = a.nextLine();
	- a.nextLine() : 문자열 한 줄을 저장
	- a.nextInt() : 정수
	- a.nextDouble() : 실수
	System.out.println(b);	

	# 생성한 스캐너에 있는 여러가지 기능
	1) next타입() 메서드 : nextInt(), nextDouble(), nextFloat() ...
	· 입력된 여러가지 값들 중 다음 값을 하나만 꺼낸 뒤에 해당하는 타입으로 변환하여 가져온다.
	· 공백, \t, \n을 기준으로 값을 구분한다.
	· 입력 통로에 아무 값도 없다면 프로그램을 멈추고 새로운 입력을 기다린다.
	· 문자열은 다른 메서드를 사용해야 한다.

	(2) next() 메서드
	· 입력된 값들 중 다음 값을 문자열 타입으로 꺼낸다.
	· 공백, \t, \n을 기준으로 값을 구분한다.
	· 입력 통로에 아무 값도 없다면 프로그램을 멈추고 새로운 입력을 기다린다.

	(3) nextLine() 메서드
	· 입력된 값을 모두 문자열로 꺼낸다.
	· \n만 기준으로 삼아 값을 구분한다. (한 줄을 통째로 꺼내기 때문에 값의 구분에 의미가 없다.)
	· 입력 통로에 아무 값도 없다면 프로그램을 멈추고 새로운 입력을 기다린다.
 */




import java.util.Scanner;


// quiz 패키지의 A00_Quiz_Rabbit 클래스 불러오기
import quiz.A00_Rabbit;

public class B00_Scanner {

	public static void main(String[] args) {

		// 같은 패키지의 다른 클래스는 import 없이 사용할 수 있다.
		A00_Hello.main(null);
		A01_Escape.main(null);

		// 다른 패키지의 다른 클래스는 사용하려면 import가 필요하다.
		// quiz 패키지의 A00_Quiz_Rabbit 클래스 불러오기
		A00_Rabbit.main(null);

		// System.in 으로 입력받는 새로운 스캐너를 생성
		// Ctrl + Shift + O
		Scanner sc = new Scanner(System.in); 

		System.out.print("숫자를 입력 해보세요 >> ");
		int a = sc.nextInt();
		// 콘솔 입력창에 숫자를 입력하면 입력숫자의 2배의 결과를 보여줌
		System.out.printf("결과 : %d\n", a * 2);


		// next()는 입력을 한 단어씩 꺼낸다. 	
		// 모든 것을 문자로 꺼낼 수 있다.
		// 문자는 어떤 것을 넣어도 에러가 날 수 없다.
		String str1, str2;
		System.out.print("단어를 두 개 입력해주세요 >> ");
		str1 = sc.next();
		str2 = sc.next();
		System.out.println("단어1: " + str1);
		System.out.println("단어2: " + str2);


		// nextLine()
		System.out.println("아무거나 막 입력해보세요 >> ");
		sc.nextLine(); //개행문자 처리
		String line = sc.nextLine();
		System.out.println("꺼낸 줄 : " + line);

	}
}
