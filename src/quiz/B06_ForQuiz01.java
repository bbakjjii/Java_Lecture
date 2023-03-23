package quiz;

public class B06_ForQuiz01 {

	/*
	 1. 2000미만의 9의 배수를 모두 출력해보세요 (양수만) 
	 2. 100부터 300까지의 총합을 구해보세요 (100과 300포함) 
	 3. 1000 부터 1500까지 10의 배수를 한 줄 에 7개씩 출력해보세요.
	 */

	public static void main(String[] args) {

		System.out.println("-----정답 1 -----");
		// 정답 1-1.
		for (int i = 0; i < 2000; ++i) {
			if (i % 9 == 0) {
				System.out.println(i);
			}
		}

		// 정답 1-2.
		for (int i = 0; i < 2000; i += 9) {
			System.out.println(i);
		}

		System.out.println("-----정답 2 -----");
		// 정답 2.
		// 총합을 구할 때는 변수를 하나 만들어 계속 누적시킨다.
		int total = 0;

		for (int i = 100; i <= 300; ++i) {
			total += i;
		}
		System.out.printf("2번 문제 답: %d\n", total);
		System.out.println("-----정답 3 -----");

		// 정답 3.
		// 7번에 한번씩 \n을 출력해주면 된다.
		// 조건을 넣을 때는 ,(콤마)로 구분한다.
		int count = 0;

		for (int i = 1000; i <= 1500; ++i) {
			if (i % 10 == 0) {
				System.out.printf("%d(%02d번째) ", i, count);
				if (count % 7 == 6) {
					System.out.println();
				}
				count++;	
			}
		}
		System.out.println();
		
		System.out.println("-----정답 3-2 -----");
		// 정답 3-2.
		// 1000 부터 1500까지 10의 배수를 한 줄 에 7개씩 출력해보세요.
		for (int i = 1000, count1 = 0; i <= 1500; ++i) {
			if (i % 10 == 0) {
				System.out.printf("%d(%02d번째) ", i, count1);
				if (count1 % 7 == 6) {
					System.out.println(); // == System.out.print("\n");
				}
				++count1;
			}
		}
	}
}