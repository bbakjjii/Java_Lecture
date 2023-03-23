package game31;

import java.util.Scanner;

public class Game31 {

	static Scanner sc = new Scanner(System.in);
	GameConfig config; // 이 안에 설정파일이 있다.

	// 게임을 진행할 때 필요한 값
	int gameNum; 
	int turn;
	int currentPlayer;

	// 게임 안에 자기가 가지고 있는 설정을 보여줄 수 있는 기능
	public Game31() {
		config = new GameConfig(31, 4, 3); //마지막 31, 4명, 1~3입력가능
	}

	// 게임 컨피그의 투스트링을 오버라이딩 한다 // 보여주기 위해 만든 것.
	// public void viewConfig() {
	//	System.out.println(config);
	// }

	//set + Ctrl + Space 후 변형
	public void setConfig(int lastNum, int players, int bound) { 
		config.lastNum = lastNum; 
		config.players = players; 
		config.bound = bound;
	}

	// 새게임이 시작될 때 값을 처음으로 돌리기(초기화)
	private void init() {
		gameNum = 0;
		turn = 0;
		currentPlayer = 1;
	}

	// 게임 시작
	public void start() {
		init();

		// 진행
		while (gameNum < config.lastNum) { // 작은 동안 
			System.out.printf("1 ~ %d 사이의 숫자 (현재: %d) > ",
					config.bound, gameNum);
			int select = sc.nextInt(); // 플레이어의 선택

			if(select < 1 || select > config.bound) {
				System.out.println("숫자를 다시 선택해주세요.");
				continue;
			}

			// gameNum += select; // 선택한 값을 일단은 더해주는걸로 시작
			for (int i = 0; i < select; ++i) {
				System.out.printf("%d!\n", ++gameNum);
				if (gameNum >= config.lastNum) {
					break;
				}
			}
		}		
		System.out.println("게임이 끝났습니다."); // 31이 넘으면 게임이 끝났습니다. 라고 출력된다.	
	}

	public static void main(String[] args) {

		// 컨피그는 이렇게 할꺼다. 변경할 수 있으면 좋겠다.라고 생각하고 만들어야 함.
		Game31 game = new Game31();

		while(true) {
			System.out.print("설정을 변경하시겠습니까? 1.예 2.아니오");

			switch(sc.nextInt()) {
			case 1:
				int lastNum, players, bound;
				System.out.print("마지막 번호 > ");
				lastNum = sc.nextInt();
				System.out.print("플레이어 수 >");
				players = sc.nextInt();
				System.out.println("선택 숫자 범위 >");
				bound = sc.nextInt();
				game.setConfig(lastNum, players, bound);
				break;
			default:
				System.out.println("변경 없이 기본 설정으로 진행합니다.");
				break;
			}

			// 게임을 계속 하고 싶으면 여기서 돌리면 됨.
			while(true) {
				game.start();
			}
		}
	}
}
