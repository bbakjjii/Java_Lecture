package blackjack;

//-- 8 -- Deck class 만들기
public class Deck {
	//-- 8 --


// // -- 9-1(일부 주석처리함), 9-2 -- 카드를 여러 장 넣어놓을 공간
	Card[] cards;
	
	
	// -- 16 --
	int cursor = 0;
	// -- 16 --
	
	
	// -- 13 -- 
	// 기본생성자로 만들면 사이즈 1짜리로 만들러 간다?
	public Deck() {
		this(1); // this() : 내 클래스의 다른 생성자
	}
	// -- 13 --
	


		// -- 9 --
//		int slen = Card.shapes.length; // shapes의 길이
//		int rlen = Card.ranks.length; // ranks의 길이
//		cards = new Card[rlen * slen];
//
//		for (int shape = 0; shape < slen; ++shape) { 
//			for (int rank = 0; rank < rlen; ++rank) {
//				// shape가 0일 때 ranks 13를 아무리 곱해도 0이다. 
//				// shape가 1일 때 ranks를 곱하면 수가 올라간다.
//				// shape가 2일 때 ranks를 곱하면 수가 올라간다.
//				// shape가 3일 때 ranks를 곱하면 52가 된다.			
//				cards[shape * rlen + rank] = new Card(shape, rank);
//			}
//		} // -- 9-1, 9-2 -- 카드를 여러 장 넣어놓을 공간
	
	
	// -- 10 --
	// 카드를 여러 벌 사용하고 싶은 경우
	public Deck(int size) {
		int slen = Card.shapes.length;
		int rlen = Card.ranks.length;

		cards = new Card[slen * rlen * size];

		// index = 장수? size = 장수? 뭐여...????
		for (int i = 0; i < size; ++i) {
			// i가 1일 때 52, i가 2일 때 104, i가 3일 때 156부터 시작
			int index = i * slen * rlen; 
		
			for (int shape = 0; shape < slen; ++shape) { 
				for (int rank = 0; rank < rlen; ++rank) {
					cards[index + shape * rlen + rank] = new Card(shape, rank);
					
					// System.out.println(index + shape * rlen + rank); // test용
				}
			}
				
		}
		
		// -- 12 --
		// 카드를 다 만든 후에 셔플
		shuffle();
		// -- 12 --
	}
	// -- 10 --
	
	
	// -- 11 -- 카드 섞기
	public void shuffle() {
		// 카드 장수의 2배만큼 섞기
		for (int i = 0; i < cards.length * 2; ++i) { 
			int ran = (int)(Math.random() * cards.length);
			Card tmp = cards[0];
			cards[0] = cards[ran];
			cards[ran] = tmp;
		}
	}
	// -- 11 --
	
	// -- 17 --
	public Card draw() {
		// 카드를 다 뽑은 상태 : 커서를 다시 0번으로 돌리고 카드를 섞는다.
		if (cursor == cards.length) {
			cursor = 0; 
			shuffle();
		}
		
		return cards[cursor++];
	}
	// -- 17 --
	
}
