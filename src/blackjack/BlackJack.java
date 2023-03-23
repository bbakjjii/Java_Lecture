package blackjack;

// -- 19 -- BlackJack(룰, 규칙) 클래스 만들기
public class BlackJack {
// -- 19 --
	
	// -- 23-1 --
	// switch를 0, 1로 쓸거면 그냥 int[]로 쓰는게 낫다.
	static int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	// -- 23-1 --
	
	
	// -- 20, 22, 23-2, 25-1, 25-2 --
	// -- 20 --
	// 1. 카드 배열을 전달 받으면 총합을 구하는 메서드
	public static int getValue(Card[] card) {
		// -- 22 --
		int value = 0;
		// -- 22 --
		
		// -- 25-1 --
		int aCount = 0;
		// -- 25-1 --
		
		
		for (int i = 0; i < card.length && card[i] != null; ++i) {
//			System.out.println(card[i]);
			value += values[card[i].rank];
			
			// -- 25-2 --
			// 나중에 21이 넘는 경우 'A'의 개수만큼 10을 빼기 위해 a의 개수를 센다.
			if (card[i].rank == 0) {
				++aCount;
			}
		}
			// 카드 가치의 합이 21이 넘고, A를 보유하고 있다면 10 감소(11 → 1)
			while (value > 21 && aCount > 0) {
				value -= 10; // value 10씩 감소
				--aCount; // aCount 1씩 감소
			}
			// -- 25-2 --
			
			
			
			// -- 23-2 --
//			switch (card[i].rank) {
//			case 0:
//				value += 11;
//				break;
//			case 1:
//				value += 2;
//				break;				
//			}
			// -- 23-2 --
			// -- 22 --
		return value;
		// -- 20 --
	}
	// -- 20, 22, 23-2, 25-1, 25-2 --

}
