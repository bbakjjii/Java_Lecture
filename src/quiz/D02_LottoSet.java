package quiz;

import java.util.HashSet;

public class D02_LottoSet {
	
	/*
	 HashSet을 이용해 1 ~ 45 사이의 중복없는 7개의 랜덤 숫자를 생성해보세요.
	 */
	
	public static void main(String[] args) {
		
		HashSet<Integer> lottoSet = new HashSet<>();
		
		while(lottoSet.size() != 7) { // 길이가 7이 아니면 계속 뽑아라!
			lottoSet.add((int)(Math.random() * 45 + 1));
		}
		System.out.println(lottoSet);
	}
}
		
//		HashSet<Integer> lotto = new HashSet<>();
//		
//		for (int i = 0; i < 7; ++i) {
//			lotto.add((int)(Math.random() * 45 + 1)); 
//			}
//			
//		System.out.println(lotto);
//	}
//}
	