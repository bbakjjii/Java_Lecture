package quiz;

public class B06_ForQuiz03 {

	/*
	 문제) for문을 사용해 다음과 같이 숫자를 출력해보세요.
	 보기)
	 1. 0 3 6 9 12 ... 93 96 99
	 2. -35 -28 -21 ... 0 7 14 21 ... 35 ??????????
	 3. 100 200 300 ... 800 900 1000
	 4. 100 99 98 ... 5 4 3 2 1 0
	 5. 0 1 2 3 ... 6 7 8 9 0 1 2 3 ... 7 8 9 ... (30번) ?????????
	 6. 10 9 8 7 ... 3 2 1 10 9 8 ... 3 2 1 10 9 ... (30번) ????????
	 7. 7 77 777 7777 77777 777777 7777777 77777777 777777777 7777777777 ??????
	 */

	public static void main(String[] args) {

		System.out.println("----- 1번 -----");
		// 1. 0 3 6 9 12 ... 93 96 99
		for (int i = 0; i < 100; i += 3) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("----- 2번 -----");
		// 2. -35 -28 -21 ... 0 7 14 21 ... 35
		for (int i = -35; i <= 35; i += 7) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("----- 3번 -----");
		// 3. 100 200 300 ... 800 900 1000
		for (int i = 100; i <= 1000; i += 100) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("----- 4번 -----");
		// 4. 100 99 98 ... 5 4 3 2 1 0
		for (int i = 100; i >= 0; --i) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("----- 5번 -----");
		// 5. 0 1 2 3 ... 6 7 8 9 0 1 2 3 ... 7 8 9 ... (30번)
		for (int i = 0; i < 300; ++i) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("----- 6번 -----");
		// 6. 10 9 8 7 ... 3 2 1 10 9 8 ... 3 2 1 10 9 ... (30번)
		// (★많이 사용되는 응용법, 10 - (i % 10) 이해 안 감)
		for (int i = 0; i < 300; ++i) {
			System.out.print(10 - (i % 10) + " ");
		}

		System.out.println();
		System.out.println("----- 6-2번 -----");
		// 6-2. 숫자를 거꾸로 세는 방법
		for (int i = 0; i < 100; ++i) {
			System.out.println(100 - i);
		}
		
		System.out.println("----- 7번 -----");
		// 7. 7 77 777 7777 77777 777777 7777777 77777777 777777777 7777777777
		long num = 7;

		for (int i = 0; i < 10; ++i) {
			System.out.print(num + " ");
			num = num * 10 + 7;
		}
		System.out.println();

		// 7-2.  int의 표현범위를 넘어가면 -로 돌아간다.
		//	for (int i = 0, num = 7; i < 10; ++i) {
		//		System.out.print(num + " ");			
		//		num = num * 10 + 7;
		//	}

		// 7-2 ex. int의 표현범위를 넘어가면 -로 돌아간다.
		// MIN_VALUE, MAX_VALUE
		//	for (int i = 0; true; i += 10000) {
		//		System.out.println(i);
		//	}

		System.out.println("----- 7-2번 -----");
		// 7-2. String(문자열) 사용
		String numStr = "7";

		for (int i = 0; i < 10; ++i) {
			System.out.print(numStr + " ");
			numStr += "7";
		}	

	}
}

