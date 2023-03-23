package rock_paper_scissors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Save {
	/*
  		(1) 컴퓨터와 진행하는 간단한 가위바위보 게임을 만든 후 
  		
  		(2) 프로그램 종료시 전적을 파일에 저장하고
  	
  		(3) 프로그램 실행시에는 파일을 읽어 파일에 저장된 전적 데이터를 읽어 
  			예전 전적이 그대로 이어지도록 만들어보세요 
	 */
 
	
	static Scanner sc = new Scanner(System.in);
	
	static String[] rockPaperScissorsName = new String[] {"가위", "바위", "보"};
	static int nameRanNum = (int)(Math.random() * rockPaperScissorsName.length);
	
	
	static Player player = new Player();

	
	public Save() {
		game();
		
	}	
	public static void game (){	
		int num;
		System.out.println("[Rock Paper Sicssors]");
		while (true) {
			try {
				System.out.println("1.Rock 2.Paper 3.Sicssors");
				num = sc.nextInt();
				if (num >= 1 && num <= 3) {
					break;
				} else {
					System.out.println("잘못된 입력값입니다.\n1.Rock 2.Paper 3.Sicssors");
					num = sc.nextInt();
				}
			}catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}
		}//while문 끝 

		winLossConfirmation(num - 1);
		
		
	}// 메소드 game();
		
	
	public static void winLossConfirmation(int userNum) {
		String playerChoice = rockPaperScissorsName[userNum];
		String computerChoice = rockPaperScissorsName[nameRanNum];
		
		System.out.println();
		System.out.println("----------대결----------");
		System.out.printf("Player\t\tComputer\n"
							+ "[%s]\tVS\t [%s]\n",
							playerChoice, computerChoice);
	
		player.plusTotal();
		if (playerChoice.equals(computerChoice)) {
			System.out.println("\t비겼습니다");
			player.plusDraw();
		} else if (userNum == 1 && nameRanNum == 1 || userNum == 2 && nameRanNum == 2 || userNum == 3 && nameRanNum == 0) {
			System.out.println("패!\t\t  ☆승☆");
			player.plusLose();
		} else {
			System.out.println("☆승☆\t\t  패!");
			player.plusWin();
		}
			
		System.out.println(player);
	}// 메소드 winLossConfirmation();
	
	
	public static void reGame() {
		int input;
			System.out.println();
			System.out.println("계속 게임을 진행하시겠습니까?");
			System.out.println("1.Yes 2.No");
			input = sc.nextInt();
			
			switch(input) {
			case 1:
				game(); 
			case 2:
				//System.out.println("게임을 종료합니다..");
				break;
			default:
				System.out.println("잘못된 값입니다. 게임을 종료합니다...");
			}
		
	}
	
	public static void playerRecord() {
		try {
			FileInputStream in = new FileInputStream("myFiles/playerRecord.txt");
			byte[] allData = in.readAllBytes();
			String pData = new String(allData);
			String[] playerScores = pData.split("/"); // 0/0/0의 전적을 /으로 끊어서 배열에 저장
			
			
			
			in.close();
		} catch (IOException e) {
			System.out.println("문제가 생김");
		}// 불러오는 try 
		
		
		try {
			
			
			FileOutputStream out = new FileOutputStream("myFiles/playerRecord.txt");
			
			String totalScore, winScore, drawScore, loseScore;
					
			//String totalScore = "" + ;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}// 내보내는 try
		
		
		
	} //메소드 playerRecord(); 
	
	
	public static void main(String[] args) {
		Save s1 = new Save();
		// Player 클래스를 만들어서 출력하는 방법을 써봤는데 실패
		// 게임 한 판을 진행 할 때 마다 새로운 클래스를 생성해서 누적이 안됨
		// -> 한 판 끝날 떄 마다 파일에 저장하고 불러와보자  
		System.out.println();
	
		
	
		
	}
	
}

























