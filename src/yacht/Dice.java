package yacht;

import java.util.ArrayList;
import java.util.Collections;

public class Dice {
	
	private final boolean DEBUG = false;
	
	ArrayList<Integer> hand = new ArrayList<>(5); // 주사위 5개로 크기 설정
	
	public Dice() {
		Collections.addAll(hand, 2, 2, 2, 4, 4);
		roll();
	}
	
	// 주사위 5개 다 던지기
	public void roll() { 
		int size = hand.size();
		for (int i = 0; i < size; ++i) {
			roll(i);
		}
	}
	
	// 주사위 하나 정해서 던지기
	public void roll(int index) {
		if (DEBUG) { // bug를 잡다. 
		System.out.printf("hand[%d] 주사위 다시 던짐!\n", index);
		}
		hand.set(index,  (int)(Math.random() * 6 + 1));
	}
	
	// 주사위 여러개 던지기
	// 원하는 주사위 몇개만 골라서 던지기
	// 문자열로 "13" → 1,3번 다시 던지기, "123" → 1,2,3번 다시 던지기
	public void roll (String indexs) {
		for(int i = 0; i < indexs.length(); ++i) {
			roll(indexs.charAt(i) - '0' - 1);
		}
	}
	
	@Override
	public String toString() {
		return hand.toString();
	}
}
