package quiz;

import java.util.Arrays;

public class B14_Lotto {

	/*
문제.
0. 우선 배열에 랜덤 숫자 6개를 생성해보세요.
1. 1 ~ 45의 "중복 없는" 랜덤 숫자 6개를 생성하여 당첨 번호를 만들어보세요.
2. 당첨될때까지 랜덤 로또 번호를 생성하여 몇 회만에 당첨되었는지 출력해보세요.
(7개 중 6개 맞추면 1등)
	 */

	public static void main(String[] args) {

		// ① 배열에 랜덤 숫자 6개 생성
		int[] lotto = new int[6];

		// ② i번째 랜덤 숫자를 뽑음
		for (int i = 0; i < lotto.length; ++i) {
			lotto[i] = (int)(Math.random() * 45 + 1); // i번째 랜덤 숫자 뽑기
			System.out.println("방금 뽑은 숫자 : [" + lotto[i] + "]");

			// 중복제거 - 방법(1)
			// 0단계 - [] [] [] [] [] []
			// 1단계 - [34] [] [] [] [] []
			// 2단계 - [34] [8] [] [] [] [] 
			// 3단계 - [34] [8] [9] [] [] []
			// 4단계 - [34] [8] [9] [34] [] [] : 중복 숫자 나옴
			// ⇒ 앞의 숫자와 체크해서 같은 숫자가 나오면 다시 뽑아라.

			// 중복제거 - 방법(2)
			// 1 2 3 4 5 6 7 8 9 10 ... 10
			// 중복 나오면 X 표시!

			// ③ 중복제거 : 이전의 숫자들과 비교해서 뽑았던 숫자가 있다면 다시 뽑아야 함
			for (int j = 0; j < i; ++j) { // i보다 전단계에 있는 랜덤숫자들을 j에 뽑아주겠다.
				System.out.printf("이전 숫자%d: %d\n", j, lotto[j]);
				if (lotto[i] == lotto[j]) { // 방금 뽑은 숫자 j가 이전 숫자 i와 같다면 다시 뽑아라
					lotto[i] = (int)(Math.random() * 45 + 1); // i를 랜덤으로 다시 뽑기
					j = -1; // j가 중복인 경우 다시 뽑기
					System.out.println("다시 뽑은 숫자 [" + lotto[i] + "]");
					System.out.println("중복이 발생하여 다시 뽑고 처음부터 검사합니다.");
				}
			}
			System.out.println("-----");
		}

		// ④ 출력 : 당첨될때까지 랜덤 로또 번호를 생성하여 몇 회만에 당첨되었는지 출력해보세요.
		System.out.print("당첨번호 : ");
		for (int i = 0; i < lotto.length; ++i) { // 0 1 2 3 4 5번방에 위에서 뽑은 랜덤숫자 넣기 = 당첨번호 6개
			System.out.printf("%-2d ", lotto[i]);
		}
		System.out.println();

		// ↑ 로또 당첨 번호!
		// ↓ 내가 산 로또 번호!

		// ⑤ 번호를 계속 뽑기 : 당첨될때까지 랜덤 로또 번호를 생성하여 몇 회만에 당첨되었는지 출력해보세요.
		// ⑦ 몇번만에 당첨이 되는지!
		int buyCount = 0;
		while (true) { // 무한 반복
			int[] myLotto = new int[6]; // 내가 뽑은 로또 번호 6개

			for (int i = 0; i < myLotto.length; ++i) {
				myLotto[i] = (int)(Math.random() * 45 + 1);

				for (int j = 0; j < i; ++j) {
					if (myLotto[i] == myLotto[j]) {
						myLotto[i] = (int)(Math.random() * 45 + 1);
						j = -1;
					}
				}
			}
			// ⑦ 몇번만에 당첨이 되는지!
			++ buyCount; // 몇번만에 당첨이 되는지!

			// lotto[]와 myLotto[]가 같은지 비교를 해야 한다.

			// 숫자 6개 동일한지 찾는 방법 (1).
			// 이렇게 비교하면 안됨!!
			// why? 숫자의 순서가 다를 수 있기 때문에
			// 1 2 3 4 5 6 = 5 6 1 2 3 4 ⇒ 순서가 달라도 당첨일 수 있다.
			// myLotto에서 당첨번호 중 하나인 1이 있냐 없냐? 
			// 숫자 6개가 전부 있냐없냐?를 봐야 함
			//	if (lotto[0] == myLotto[0] 
			//	&& lotto[1] == myLotto[1]
			//	&& lotto[1] == myLotto[2]
			//	&& lotto[1] == myLotto[3]
			//	&& lotto[1] == myLotto[4]
			//	&& lotto[1] == myLotto[5]) {

			// 숫자 6개 동일한지 찾는 방법(2).
			// 이렇게 비교해야 함!
			// → 당첨 번호 6개가 myLotto[]에 포함되어 있는지 검사해야 한다.
			// ⑥ 당첨될때까지 랜덤 로또 번호를 생성
			int winCount = 0;
			for (int i = 0; i < lotto.length; ++i) {
				for (int j = 0; j < myLotto.length; ++j) {
					if (lotto[i] == myLotto[j]) {
						++winCount;
						break;
					}
				}
			}
			if (winCount == 6) {
				// ⑦ 몇번만에 당첨이 되는지!
				System.out.println(buyCount + "당첨!");
				break;
			} else if (winCount == 5) {
				System.out.println("2등! 아쉽다");
				// ★ Ctrl + Shift + O : java.utill.Arrays.toString(arr) : 배열을 문자열로 변환할 수 있다.
				System.out.println(Arrays.toString(myLotto)); 
			}
		}
	}
}