package quiz;

import java.util.ArrayList;

public class D01_ArrayListPractice02 {

	public static void main(String[] args) {

		// list는 새로 만든 생산품의 주소를 받아온다.
		// list = oddList가 됨. 그렇기 때문에 새로운 ArrayList를 만들어야 함.
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; ++i) {
			list.add((int)(Math.random() * 1001 + 4000));
		}
		
		// 얕은 복사 (shallow copy) - 주소를 복사해준다
		// list는 oddList로 가면된대! (X)
		// ArrayList<Integer> oddList = list;
		
		// 깊은 복사 (deepcopy) (O) - 값을 복사한다
		// ArrayList<Integer> oddList = new ArrayList<>();
		// oddList.addAll(list);
		
		// 깊은 복사를 간단하게 줄이는 방법 - clone으로 만들기
		// (ArrayList<Integer>)list.clone();
		ArrayList<Integer> oddList = (ArrayList<Integer>)list.clone();

		// 짝수 제거
		for (int i = 0; i < oddList.size(); ++i) {
			if(oddList.get(i) % 2 == 0) {
				oddList.remove(i--);
			}
		}
		System.out.println("원본 리스트 : " + list);
		System.out.println("홀수들만 남아있는 리스트 : " + oddList);
	}
}
