package quiz;

import java.util.Arrays;

public class C01_MethodQuiz02 {

/*
문제.
1. 사과의 개수와 바구니의 크기를 전달하면 필요한 바구니의 개수를 리턴하는 메서드
2. 문자열을 전달하면 해당 문자열을 랜덤으로 뒤섞은 결과를 반환하는 메서드
3. 문자열을 전달하면 해당 문자열을 거꾸로 한 문자열을 반환하는 메서드
4. 메서드를 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 반환하는 메서드
*/
	// 1
	public static int howManyBasket(int apple, int size) {
		if (apple % size == 0) {
			return apple / size;
		} else {
			return apple / size + 1;
		}
	}

	// 2.
	public static String shuffleText(String text) {
		char[] arr = text.toCharArray();

		for(int i = 0; i < 1000; ++i) {
			int index = (int)(Math.random() * arr.length);
			char tmp = arr[0];
			arr[0] = arr[index];
			arr[index] = tmp;
		}
		return new String(arr);
	}

	// 3.
	public static String reverseText(String text) {
		char[] ori = text.toCharArray();
		int len = ori.length;
		char[] reversed = new char[len];

		for (int i = 0; i < ori.length; ++i) {
			reversed[len - 1 - i] = ori[i];
		}
		return new String(reversed);
	}

	// 4.
	public static int getRandomNumber() {
		return (int)(Math.random() * 45 + 1);
	}

	public static int[] getLottoNumber() {
		int[] lotto = new int[7];

		for (int i = 0; i < lotto.length; ++i) {
			lotto[i] = getRandomNumber();
			for (int j = 0; j < i; ++j) {
				if (lotto[i] == lotto[j]){
					lotto[i] = getRandomNumber();
					j = -1;
				}
			}
		}
		return lotto;
	}

	public static void main(String[] args) {
		// 1.
		int basket = howManyBasket(30, 10);

		System.out.printf("필요한 바구니는 모두 %d개 입니다.\n", basket);
		// ↑ 바구니 크기도 전달

		// 2.
		System.out.println(shuffleText("Hello, world!"));

		// 3.
		System.out.println(reverseText("Hello, world!"));

		// 4.
		System.out.println(Arrays.toString(getLottoNumber()));
	}
}