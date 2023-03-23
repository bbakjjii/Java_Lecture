package blackjack;

// -- 1 -- Card class 만들기
public class Card {
// -- 1 --
	
	// -- 2 -- 
	// 모양 : ♠ ♡ ♣ ◇
	// 숫자 : A 2 3 4 5 6 7 8 9 1 0 J Q K
	// static을 안 붙이면 카드 갯수가 52개 생길 동안에 배열이 똑같이 52개 생긴다. (메모리 낭비)
	static char[] shapes = {'♠', '♡', '♣', '◇'};
	static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	// -- 26-1 --  카드 가리기
	boolean hidden;
	// -- 26-1 -- 
	
	// 이 숫자가 나타내는 의미는 모든 인스턴스에서 동일해야 한다.
	// = 이 번호가 나타내는 의미는 모든 카드에서 동일해야 한다.
	// 그렇기 때문에 배열에 static을 붙인다.
	int shape; //shape가 0일 때는 ♠, 1일 때는 ♡, 2일 때는 ♣, 3일 때는 ◇
	int rank; // ranks가 0일 때는 A, 1일 때는 2, 2일 때는 3.... 12일 때는 K
	// -- 2 -- 
	
	// -- 7-1 -- 생성자 만들기
	public Card(int shape, int rank) {
		this.shape = shape;
		this.rank = rank;
	}
	// -- 7-1 --
	
	//-- 27 --
	public void hide() {
		hidden = true;
	}
	
	public void open() {
		hidden = false;
	}
	//-- 27 --
	
	// -- 4 --
	@Override
		public String toString() {
			return String.format("%c%s", shapes[shape], ranks[rank]); // D05_Collections Test용
			//-- 26-2 --
//			if (hidden) {
//				return 	"┌──────┐\n│  XX  │\n└──────┘";
//			} else {
//				//-- 26-2 --
//				return String.format(
//					"┌──────┐\n"
//				  + "│ %c%-1s   │\n"
//				  +	"└──────┘", shapes[shape], ranks[rank]);
//			}
	}
			//-- 26-2 --
	// -- 4 --
}
