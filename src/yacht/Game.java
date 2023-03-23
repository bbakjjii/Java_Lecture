package yacht;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Dice dice = new Dice();

		int rerollChance = 2;
		while (rerollChance > 0) {
			System.out.println(dice);
			System.out.printf("다시 굴리기 (%d회 남음) > ", rerollChance);
			String input = sc.nextLine();

			if (input.equals("0")) { // 0일 때 나가는걸로(시스템 종료로) 치겠다.
				break;
			} else {
				dice.roll(input);
				--rerollChance;
			} 
		}
		System.out.println(dice);
		System.out.println(YachtDiceRules.check(dice));

		// -- 테스트용 ---
		//		Dice d = new Dice();
		//		System.out.println(d); 
		//		d.roll("345");
		//		System.out.println(d);
		// -- 테스트용 ---
	}
}
