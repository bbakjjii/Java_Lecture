package pirate;

import java.util.Scanner;

public class PirateGame {

	Scanner sc = new Scanner(System.in);
	Player[] players;
	Tong tong;

	public PirateGame() {
		int size, lose,  playerNum;

		System.out.print("통의 크기는? ");
		size = sc.nextInt();
		System.out.print("꽝의 개수는? ");
		lose = sc.nextInt();
		tong = new Tong(size, lose);	

		System.out.print("플레이어는 몇 명? "); 
		playerNum = sc.nextInt(); // 이름을 입력 받고

		players = new Player[playerNum]; // 배열을 받고

		for (int i = 0; i < playerNum; ++i) {
			System.out.print("플레이어" + (i + 1) + "의 이름을 입력 : ");
			players[i] = new Player(sc.next());
		}

		System.out.println("게임 설정 완료..");
	}

	public void start() {
		int turn = 0;


		while (true) {
			int playing = turn % players.length;
			System.out.printf("%s님의 차례입니다.\n", players[playing]);

			// 통의 현재 상태 출력
			tong.view();
			System.out.print("몇 번 구멍에 칼을 꼽으시겠니까? ");
			if (tong.stab(sc.nextInt())) {
				System.out.printf("%s님의 패배입니다.\n", players[playing].name);

				for(int i = 0; i < players.length; ++i) {
					if (i == playing) {
						players[i].lose();
					} else {
						players[i].win();
					}
				}
				players[playing].lose();
				break;
			}
			++turn;
		}
	}

	public static void main(String[] args) {
		PirateGame game = new PirateGame();

		game.start();
	}
}
