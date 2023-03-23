package myobj;

import java.util.Arrays;

public class Lotto {

	// 로또 한 장 5000원어치
	// {1, 2, 3, 4, 5, 6}
	// {1, 2, 3, 4, 5, 6}
	// {1, 2, 3, 4, 5, 6}
	// {1, 2, 3, 4, 5, 6}
	// {1, 2, 3, 4, 5, 6}

	int[][] nums = new int[5][6];

	// 로또는 1 ~ 45번까지 있다.
	static int MAX_NUM = 45; // 로또 번호의 최대값
	static int MIN_NUM = 1; // 로또 번호의 최소값
	static int NUM_OF_LOTTO = 5; // (한 장에 5000원 ⇒ 5칸)
	static int LOTTO_LENGTH = 6; // 선택할 로또 번호
	static int WIN_LENGTH = 7; // 당첨 로또 번호

	// 로또 당첨 번호 메서드
	public static int[] getWinNum() {
		int[] win = new int[WIN_LENGTH];

		for (int i = 0; i < WIN_LENGTH; ++i) {
			win[i] = (int)(Math.random() * MAX_NUM + MIN_NUM); // Math.random() * MAX_NUM = 0~45 + MIN_NUM(1) ⇒ 1 ~ 45

			for(int j = 0; j < i; ++j) {
				if (win[i] == win[j]) {
					--i;
					break;
				}
			}
		}
		return win;
	}

	// 자동 번호 생성 + 중복 제거 메서드
	public static int[] auto() {
		int[] lotto = new int[LOTTO_LENGTH];

		for (int i = 0; i < LOTTO_LENGTH; ++i) {
			lotto[i] = (int)(Math.random() * MAX_NUM + MIN_NUM);

			for(int j = 0; j < i; ++j) {
				if (lotto[i] == lotto[j]) {
					--i;
					break;
				}
			}
		}
		return lotto;
	}

	public Lotto() {
		nums = new int[NUM_OF_LOTTO][LOTTO_LENGTH];

		// NUM_OF_LOTTO = 5; 이기 때문에 for문을 해석하면 아래와 같다.
		// nums[0] = auto();
		// nums[1] = auto();
		// nums[2] = auto();
		// nums[3] = auto();
		// nums[4] = auto();

		for (int i = 0; i < NUM_OF_LOTTO; ++i) {
			nums[i] = auto();
		}
	}

	public Lotto(int[][] nums) {
		this.nums = nums;
	}

	// 우리가 선택한 로또 번호를 보여주는 메서드
	public void view() {
		for (int i = 0; i < NUM_OF_LOTTO; ++i) {
			System.out.println(Arrays.toString(nums[i]));
		}
	}

	// 로또가 당첨인지 아닌지의 여부를 판별
	public static boolean isWin(int[] winNum, Lotto lotto) {
		// 넘겨받은 당첨번호와 해당 로또용지를 대조하여 당첨되었는지 확인하는 메서드를 구현해보세요.
		// System.out.println("--당첨 체크 중 + (" + Arrays.toString(winNum) + ") --");
		for (int i = 0; i < NUM_OF_LOTTO; ++i) {

			int count = 0;

			for (int j = 0; j < LOTTO_LENGTH; ++j) { // LOTTO_LENGTH : 6
				for (int k = 0; k < WIN_LENGTH; ++k) { // WIN_LENGTH : 7
					if (lotto.nums[i][j] == winNum[k]) { // i : 0~4, j : 0~5, k : 0~6
						++count;
						break;
					}
				}
			}
			if (count >= 6) { // 맞는 번호가 6개 이상이면 당첨
				return true;
			}
		}
		return false; // 맞는 번호가 6개 미만이면 당첨이 아님
	}

	public static void main(String[] args) { // LOTTO 클래스와는 별개인 부분.

		// Lotto 클래스의 당첨번호를 생성하는 기능을 이용해 당첨번호를 생성
		int[] winNum = Lotto.getWinNum();

		// 당첨될 때까지 용지를 생성하겠다.
		int count = 0;
		while (true) {

			// 생성자에서 자동으로 번호 5세트 생성(인스턴스 전달)
			Lotto lotto = new Lotto();
			++count;

			// 생성해놓은 당첨번호와 생성한 용지를 전달하면 당첨인지 알려주는 메서드
			if (Lotto.isWin(winNum, lotto)) {
				System.out.println("당첨 용지가 나왔습니다.");

				lotto.view(); // 해당 용지 정보를 출력하는 메서드
				System.out.println("--------------------");
				System.out.println("당첨번호 : " + Arrays.toString(winNum));
				break;
			}
		}
		System.out.printf("당첨 용지는 %d번 만에 나왔습니다.\n", count);
	}

}
