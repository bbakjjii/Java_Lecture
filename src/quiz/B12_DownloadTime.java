package quiz;

import java.util.Scanner;

public class B12_DownloadTime {

	/*
문제.
사용자로부터 다운로드 시간을 초 단위로 입력받으면
x일 x시간 x분 x초 남았는지 환산하여 출력해보세요.
(필요 없는 단위는 출력하지 않아야 함)

보기.
>> 600
→ 10분 0초

>> 66656
→ 1일 0시간 5분 56초

	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //Scanner 클래스 변수 선언 및 초기화. 입력값을 받아오는 스캐너기능을 사용할 수 있다 

		System.out.print("숫자를 입력 해보세요 >> ");
		int downloadTime = sc.nextInt();

		// 영원히 변하지 않을 값은 변수를 모두 대문자로 지정한다.
		// (VarNaming 4. 프로그램 내에서 프로그램이 꺼질때까지 변하지 않을 변수는 모두 대문자를 사용한다.)
		// final이 붙어있는 변수는 나중에 수정할 수 없다.
		final int MINUTE = 60;
		final int HOUR = MINUTE * 60;
		final int DAY = HOUR * 24;

		if (downloadTime >= DAY) {
			System.out.printf("%d일 %d시간 %d분 %d초\n",
					downloadTime / DAY,
					downloadTime % DAY / HOUR,
					downloadTime % HOUR / MINUTE,
					downloadTime % MINUTE);
		} else if (downloadTime >= HOUR) {
			System.out.printf("%d시간 %d분 %d초\n", 
					downloadTime / 3600, 
					downloadTime % 3600 / 60, //★ 중요(detail) 
					downloadTime % 60);
		} else if (downloadTime >= MINUTE) { 
			System.out.printf("%d분 %d초\n", 
					downloadTime / 60, downloadTime % 60);
		} else {
			System.out.printf("%d초\n", downloadTime);
		}
	}
}