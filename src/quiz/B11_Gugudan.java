package quiz;

public class B11_Gugudan {

/*
문제.
B10의 구구단 두 개를 While문으로 출력해보세요.

보기1.
2단: 2x1=2 2x2=4 2x3=6 ...
3단: 3x1=3 3x2=6 3x3=9 ...
4단 : ...

보기2.
2단		3단		4단
2x1=2	3x1=3	4x1=4
2x2=4	3x2=6	4x2=8
...
*/

	public static void main(String[] args) {

		// 1.
		int dan = 2, gop = 1;

		while (dan <= 9) {
			System.out.printf("%d단: ", dan);

			gop = 1; // ★ 초기화 다시 해주기
			while (gop <= 9) {
				System.out.printf("%dx%d=%-2d ", dan, gop, dan * gop);
				++gop;
			}
			++dan;
			System.out.println();
		}

		System.out.println("==========");

		// 2.
		int line = 0;

		while (line < 10) { // 라인은 1씩 증가시키면서 사용하겠다.(10줄 출력)
			dan = 2; //
			while (dan <= 9) { // 단을 증가시켜준다
				if (line == 0) { // 라인이 0일 때
					System.out.printf("%d단\t", dan); // 라인이 0일 때 출력
				} else {
					System.out.printf("%dx%d=%d\t", dan, line, dan * line); // 라인이 0이 아닐 때 (1~9일 때) 출력
				}
				++dan; // 단이 1씩 증가
			}
			++line; // 라인이 1씩 증가
			System.out.println(); //맨 마지막에 줄바꿈
		}
	}
}