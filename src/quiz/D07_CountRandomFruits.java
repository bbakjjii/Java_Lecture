package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class D07_CountRandomFruits {

	/*
	 문제.
	 리스트에 String 타입 랜덤 과일 이름을 300개 추가하고
	 각 과일이 몇 번 등장했는지 세어보세요.
	 (apple, banana, kiwi, orange, grape, peach, pineapple)
	 */

	public static void main(String[] args) {

		String[] fruitNames = {"apple", "banana", "kiwi", "orange", "grape", "peach", "pineapple"};

		List<String> fruits = new ArrayList<>();

		Random r = new Random();

		for (int i = 0; i < 300; ++i) {
			fruits.add(fruitNames[r.nextInt(fruitNames.length)]);
		}

		HashMap<String, Integer> fruitCount = new HashMap<>();

		// Map을 쓰면 apple을 바로 key값으로 쓰면 된다.
		// Map을 쓰면 배열에 비해서 인덱스를 내가 원하는대로 마음대로 쓸 수 있다.
		for (String fruit : fruits) {
			// 새로운 과일이 등장했을 때는 1을 넣고 null을 리턴한다.
			// 이미 값이 들어가 있을때는 값을 꺼낸다.
			Integer count = fruitCount.putIfAbsent(fruit, 1);

			// 이미 count를 세기 시작했던 과일이라면 1증가 시킨다.
			if (count != null) {
				fruitCount.put(fruit,  count + 1);
			}
		}
		System.out.println(fruitCount);
		System.out.println("----------");

		// 배열을 사용하는 방법 : 노가다 필요
		int size = fruits.size();
		int[] count = new int[fruitNames.length];

		for (int i = 0; i < size; ++i) {
			String fruit = fruits.get(i);
			if (fruits.equals("apple")) {
				count[0] += 1;
			} else if (fruit.equals("banana")) {
				count[1] += 1;
			}
		}
		System.out.println(Arrays.toString(count));
		System.out.println("----------");

		// 비효율적 : 아래의 for문은 300개 fruit 중에서 apple 하나만 검사하려면 300번을 봐야하고,
		//			banana 하나만 검사하려면 또 300번을 봐야한다.

		for (int i = 0; i < fruitNames.length; ++i) {
			System.out.printf("%s count : %d\n", fruitNames[i],
					Collections.frequency(fruits, fruitNames[i])); 
		}
	}
}