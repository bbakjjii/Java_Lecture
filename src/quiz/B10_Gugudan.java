package quiz;

public class B10_Gugudan {

	/*
문제. 구구단을 다음과 같이 가로로 출력해보세요.
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
		for (int dan = 2; dan <= 9; ++dan) {
			System.out.printf("%d단:\t", dan);
			for (int gop = 1; gop <= 9; ++gop) {
				System.out.printf("%dx%d=%-2d ", dan, gop, dan * gop);
			}
			System.out.println();
		}
		
		// 2.
		for (int line = 0; line <= 9; ++line) {
			for (int dan = 2; dan <= 9; ++dan) {
				if (line == 0) {
					System.out.printf("%d단\t", dan);
				} else {
				System.out.printf("%dx%d=%d\t", dan, line, dan * line);
				}
			}
			System.out.println();
		}
		
	}
}