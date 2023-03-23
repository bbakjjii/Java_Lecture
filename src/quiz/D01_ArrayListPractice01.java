package quiz;

import java.util.ArrayList;

public class D01_ArrayListPractice01 {
	
	/*
	 1. ArrayList에 4000 ~ 5000의 랜덤 정수를 100개 추가한다.
	 2. 모든 숫자의 총합과 평균을 구한다.
	 3. 원본에서 짝수를 모두 제거한 후 총합을 구한다.
	 4. 원본에서 홀수를 모두 제거한 후 총합을 구한다.
	 5. 10번째 홀수를 구한다.
	 
	 ※ 제네릭에는 기본형 타입은 사용할 수 없다.
	 · 기본형 타입 int 대신 Integer 사용.
	 */
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> evens = new ArrayList<>();
		ArrayList<Integer> odds = new ArrayList<>();
		
		// 1. ArrayList에 4000 ~ 5000의 랜덤 정수를 100개 추가한다.
		for (int i = 0; i < 100; ++i) {
			list.add((int)(Math.random() * 1001 + 4000)); //0+4000 ~ 1000+4000
		}
		System.out.println(list);
		
		
		// 2. 모든 숫자의 총합과 평균을 구한다.
		int sum = 0;
		
		for (int i = 0; i < list.size(); ++i) {
			sum += list.get(i);
		}
		System.out.println("총 합 : " + sum);
		System.out.println("평 균 : " + sum / (double)list.size());
		
		
		// 3. 원본에서 짝수를 모두 제거한 후 총합을 구한다.
		// 4. 원본에서 홀수를 모두 제거한 후 총합을 구한다.
		// → 해당 위치의 짝수를 제거하면 뒤에 있던 아이템이 앞으로 당겨지는 문제가 있으므로 해결해야 함
		// [33, 2, 5, 8, 10, 99, 100]
		// [33, 5, 8, 10, 99, 100]
		// ⇒ 순서대로 보기 때문에 0, 1, 2, 3 순으로 보면서 앞으로 당겨진 숫자는 안 보고
		// 바로 다음 숫자로 보게 되기 때문에 짝수가 일부 남아있다.
		for (int i = 0; i < list.size(); ++i) {
			int num = list.get(i);
			// 제거는 안 한 방법
			if (num % 2 == 0) {
				evens.add(list.get(i));	
			} else {
				odds.add(list.get(i));
			}
		}
		
		int evenSum = 0; // 짝수 합계
		for (int i = 0; i < evens.size(); ++i) {
			evenSum += evens.get(i);
		}
		int oddSum = 0; // 홀드 합계
		for(int i = 0; i < odds.size(); ++i){
			oddSum += odds.get(i);
		}
		System.out.println("짝수합 : " + evenSum);
		System.out.println("홀수합 : " + oddSum);

		// 5. 10번째 홀수를 구한다.
		System.out.println("10번째 홀수 : " + odds.get(9)); 
	}
}
		
		
//		ArrayList<Integer> list = new ArrayList<>(); // 객체 생성?
//		ArrayList<Integer> oddList = new ArrayList<>(); // 객체 생성?
//		
//		int sum = 0;
//		int cnt = 0;
//		
//		int oddSum = 0;
//		int evenSum = 0;
//		
		
//		// 1. ArrayList에 4000 ~ 5000의 랜덤 정수를 100개 추가한다.
//		for (int i = 0; i < 100; ++i) { // 초기화, 조건식, 증감값
//			int rannum = (int)(Math.random() * 1001 + 4000);
//			list.add(rannum);
//			
//			sum += rannum;
//			++cnt;
//			
//			if (rannum % 2 != 0){
//				oddSum += rannum;
//				oddList.add(rannum);
//			} else {
//				evenSum += rannum;
//			}
//		}
		
//		System.out.println("1번 : " + list);
//		System.out.println("2번 총합 : " + sum);
//		System.out.println("2번 평균 : " + sum / 100.0 );
//		System.out.println("3번 짝수제거 : " + oddSum);
//		System.out.println("4번 홀수제거 : " + evenSum);
//		System.out.println(oddList);
//		System.out.println("5번 10번째 홀수 : " + oddList.get(9));
//
//	}
//}