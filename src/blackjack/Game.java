package blackjack;

import java.util.Scanner;

// -- 3 -- Game class 만들기
public class Game {
// -- 3 --
	
	// -- 31-2 -- gameInfo 메서드 만들기
	public static void gameInfo(Card[] user, Card[] dealer) {
		System.out.println("- User");
		for (int i = 0; i < user.length && user[i] != null; ++i) {
			Card c = user[i];
			System.out.printf("[%c%s] ",
					Card.shapes[c.shape], Card.ranks[c.rank]);
		}
		System.out.printf("(%d)", BlackJack.getValue(user));
		System.out.println();
		System.out.println();

		System.out.println("- Dealer");
		for (int i = 0; i < dealer.length && dealer[i] != null; ++i) {
			Card c = dealer[i];
			
			// 딜러는 출력할 때 히든 여부를 따져야 함.
			if (!c.hidden) {
			System.out.printf("[%c%s] ",
					Card.shapes[c.shape], Card.ranks[c.rank]);
			} else {
				System.out.println("[XX]");
			}
		}
		
		System.out.println();
	}
	// -- 31-2 --
	
	
	// -- 6, 14 (내용 주석처리함), 15(내용 주석처리함), 18(주석)--
	public static void main(String[] args) {
		
		// BlackJack 클래스에서 size를 나타냄 = Deck(3) ⇒ size가 3이다.
		Deck d = new Deck(3); 
		
		// -- 21 --
		// 최대 21개?
		Card[] user = new Card[21];
		Card[] dealer = new Card[21];
		
		
		
		// -- 29-1 --
		System.out.println("유저에게 두장");
		// -- 29-1 --
		
		// -- 24 -- test : 카드가 여러장 있어도 잘 작동되나?
		user[0] = d.draw();
		user[1] = d.draw();
		
		
		// -- 29-2 --
		System.out.println("딜러에게 두장");
		// -- 29-2 --
				
		dealer[0] = d.draw();
		
		// -- 28 -- 카드 숨기기
		Card c = d.draw();
		c.hide();
		dealer[1] = c;
		// -- 28 -- 카드 숨기기
		
		
		// -- 30 --
		Scanner sc = new Scanner(System.in);
		
		// -- 32-1 --
		int userIndex = 2;
		int dealerIndex = 2;
		// -- 32-1 --
		
		
		while (true) {
			
			// -- 31-1 -- gameInfo 메서드 만들기
			gameInfo(user, dealer);
			// -- 31-1 --
			
			System.out.println("1. hit\t2. stand");
			int hit = sc.nextInt();
			
			// -- 32-2 --
			if (hit == 1) {
				user[userIndex++] = d.draw();
				if (BlackJack.getValue(user) > 21) {
					gameInfo(user, dealer);
					System.out.println("플레이어 버스트로 패배");
					return;
				} else if (BlackJack.getValue(user) == 21) {					
					dealer[1].open();
					while (BlackJack.getValue(dealer) < 16) {
						dealer[dealerIndex++] = d.draw();
					}
					break;
				}
			} else if (hit == 2) {
				dealer[1].open();
				while (BlackJack.getValue(dealer) < 16) {
					dealer[dealerIndex++] = d.draw();
				}
				break;
			} else {
				continue;
			}
		}
		
		
		// -- 33 --
		int userValue = BlackJack.getValue(user);
		int dealerValue = BlackJack.getValue(dealer);
		
		gameInfo(user, dealer);
		
		if (dealerValue > 21) {
			System.out.printf("%d(user) vs %d(dealer) 딜러의 버스트로 유저 승 ! ", userValue, dealerValue);
		} else if (userValue == dealerValue) {
			System.out.printf("%d(user) vs %d(dealer)로 비김\n", userValue, dealerValue);
		} else if (userValue > dealerValue) {
			System.out.printf("%d(user) vs %d(dealer)로 유저 승!!\n", userValue, dealerValue);
		} else
			System.out.printf("%d(user) vs %d(dealer)로 딜러 승!!\n", userValue, dealerValue);
		}
		// -- 33 --
}

			// -- 32-2 --
		// -- 30 --
		

		// -- 24(주석) --
//		System.out.println("유저 카드의 가치 : " + BlackJack.getValue(user));
//		System.out.println("딜러 카드의 가치 : " + BlackJack.getValue(dealer));
		// -- 24(주석) --
			
		// -- 21 --
		
		
		// -- 18(주석) -- 유저와 딜러 카드 2장씩 뽑기
//		System.out.println("유저 첫번째카드 : \n" + d.draw());
//		System.out.println("유저 두번재카드 : \n" + d.draw());
//		
//		System.out.println("딜러 첫번재카드 : \n" + d.draw());
//		System.out.println("딜러 첫번재카드 : \n" + d.draw());
		// -- 18 --
		

		// --15--
//		System.out.println("카드 개수 : " + d.cards.length);
//		
//		for (int i = 0; i < d.cards.length; ++i) {
//			System.out.println(d.cards[i]);
//		}
		// --15--
		
		
		// -- 14 --
	// System.out.println(Card.shapes[0]);
	// System.out.println(Card.shapes[1]);		
	// System.out.println(Card.ranks[0]);
	// System.out.println("----------);
		
//		for (int shape = 0; shape < Card.shapes.length; ++shape) {
//			for (int rank = 0;rank < Card.ranks.length; ++rank) {
//				
//				// -- 5, 7-2 생성자 사용 --
//				Card c = new Card(shape,rank);
//				System.out.println(c);
//				// -- 5, 7-2 --
//			}
//		}
		// -- 14 --
	// -- 6, 14 (내용 주석처리함), 15(내용 주석처리함), 18(주석)--
