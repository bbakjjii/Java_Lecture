public class B15_Array02 {
	
/*
배열 안에 배열을 넣을 수 있다.
(배열로 이루어진 배열을 만들 수 있다.)
 
*/
	
	public static void main(String[] args) {
		String[] animals = {"abc", "lion", "tiger", "cat", "dog"};
		int[] lotto = {1, 3, 99, 84, 0x123};
		int[] numbers = {1, 2, 3, '4', 5, 6}; //가능! '4' = 52가 들어간다. 
		// int[] numbers = {1, 2, 3, "안녕하세요", 5, 6}; // 불가능! : int안에 String이 섞여 있어서
		
		// int형 배열이 들어가는 
		// · 배열이 요소로서 들어가는 배열
		int[][] arr2 = { // 2중 반복문
				lotto, 
				numbers, // 가능
				{1, 2, 3, 4, 5}, // 0번방의 배열의 0번방, 1번방, 2번방, 3번방, 4번방, 5번방
				{'a', '3', 'b', '가', '힣'}, // 1번방의 배열의 0번방, 1번방, 2번방, 3번방, 4번방, 5번방
				{3, 3, 3, 3, 3, 3, 3}, // 2번방의 배열의 0번방, 1번방, 2번방, 3번방, 4번방, 5번방
				// {"tiger", "peach", "watermelon"}, // String형 불가능!
		};
				
		System.out.println(arr2[0][4]);
		System.out.println((char)arr2[3][2]); // B(98)가 나옴
		System.out.println(arr2[1][5]);
		
		// arr2[0], arr2[1], lotto는 모두 같은 배열을 가리키고 있다.
		System.out.println(arr2[1][2]); // 98(B)가 나옴
		System.out.println(lotto[2]);
		
		// arr2[0][2]를 변경 시켜도 다른 모든 배열의 값이 변한다.
		// lotto와 출력값이 모두 7로 바뀜
		arr2[0][2] = 7; 
		System.out.println(arr2[1][2]);
		System.out.println(lotto[2]);
		
		// ★ n차원 배열은 n중 반복문으로 모두 탐색할 수 있다.
		// ⇒ 2차원 배열은 2중 반복문으로 모두 탐색할 수 있다.
		
		// arr2.length : 배열이 몇 개 있는지를 의미함
		for (int i = 0; i < arr2.length; ++i) {
			// i가 0에서 그 길이만큼 탐색
			
			// arr2[i].length : 내부에 있는 i번째 배열의 길이를 의미
			for (int j = 0; j < arr2[i].length; ++j) {
				// j가 0에서 그 길이만큼 탐색
				System.out.printf("arr2[%d][%d] == %d\n", i, j, arr2[i][j]);
			}
		}
	}
}

