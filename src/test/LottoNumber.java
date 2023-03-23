package test;
import java.util.Random;
import java.util.Scanner;

public class LottoNumber {

	public static void main(String[] args) {

		// 입출력함수 정의
		Scanner sc = new Scanner(System.in);

		// 배열크기 정의
		int LottoNumber[] = new int[7];

		// 랜덤함수 정의
		Random random = new Random();

		// 로또숫자 범의 (min, max 정의)
		int min = 1;
		int max = 45;
		System.out.println("입력 횟수?  ");

		//입력받을 게임 수 입력하기
		int count = sc.nextInt();

		//입력받은 수 만큼 count 증가시키기
		for (int countstart = 1; countstart <= count; countstart++) {

			// for문 돌려서 1 ~ 45번의 랜덤숫자 추출
			for (int i = 0; i < LottoNumber.length; i++) {
				LottoNumber[i] = (random.nextInt((max - min) + 1) + min);

				for (int j = 0; j < i; j++) {
					if (LottoNumber[i] == LottoNumber[j]) {
						LottoNumber[i] = (int)(Math.random() * 45 + 1);
						j--;
					}

					if (LottoNumber[i] < LottoNumber[j]) {
						int LottoNumberTemp = LottoNumber[i];
						LottoNumber[i] = LottoNumber[j];
						LottoNumber[j] = LottoNumberTemp;
					}

				}

			}
			System.out.println("게임 횟 수 " + countstart);

			for (int i = 0; i < LottoNumber.length; i++) {
				System.out.println(LottoNumber[i]);
			}
			System.out.println("----------");
		}
	}
}
