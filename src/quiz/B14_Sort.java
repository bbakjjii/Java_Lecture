package quiz;

import java.util.Arrays;

public class B14_Sort {

/*
문제.
랜덤 int 30개가 들어있는 배열을 생성한 후
(1) 해당 배열의 내용을 작은 값 부터 차례대로(오름차순) 저장한 
	새로운 배열을 생성하여 출력해보세요.
(2) 해당 배열의 내용을 큰 값 부터 차례대로(내림차순) 저장한
	새로운 배열을 생성하여 출력해보세요.
*/

	public static void main(String[] args) {
		// ① 랜덤 int 30개 배열 생성
		int[] nums = new int[30]; // 랜덤으로 값 30개 입력
		// *1-1. 왜 결과값이 정렬 전 배열 nums랑 오름차순 ascending이 같게 나오는지?
		// 결과값 - 정렬 전 배열 : [-489, -484, -401, -384, -366, -296, -286, -203, -185, -126, -112, -99, -77, -73, -48, -32, 18, 90, 122, 161, 226, 270, 278, 301, 330, 352, 382, 422, 425, 440]
		// 결과값 - 오름차순 : [-489, -484, -401, -384, -366, -296, -286, -203, -185, -126, -112, -99, -77, -73, -48, -32, 18, 90, 122, 161, 226, 270, 278, 301, 330, 352, 382, 422, 425, 440]
		// *1-2. nums와 ascending 출력값이 똑같이 나오는 이유!
		// - 배열을 만들면 3개의 방이 생기고 30x4(byte)(=120byte)가 생김
		// - 처음 배열 30칸 만들어짐 → 쓰기 위해 가장 처음의 위치만 알려달라 → index 번호를 통해서 내가 몇 번째 칸에 가야하는지 알 수 있으니까
		// - nums : 첫번째 값의 주소가 들어있다. 배열의 첫번째 위치가 들어있다.
		//    ↓
		// - [7][8][9][1][2][3][-5]

		// Arrays.fill(arr, value) : 해당 배열을 원하는 값으로 가득 채울 때 사용
		// Arrays.fill(nums, 100);

		for (int i = 0; i < nums.length; ++i) {
			nums[i] = (int)(Math.random() * 1000 - 500);
			// -500 ~ 499(-500 + 1000 - 1)까지의 랜덤숫자 중 30개를 뽑는다.
		}

		// ② 오름차순 정렬
		int[] ascending = new int[30]; // 랜덤으로 된 값 30개 입력
		// *1-3. ascending : 첫번째 값의 주소가 들어있다. 배열의 첫번째 위치가 들어있다

		// *1-4. 배열의 시작 주소 전달 → 두 배열 변수가 같은 배열을 가리키게 된다.
		// *1-5. 그래서 ascending을 수정했을 때 nums도 수정된다.
		// *1-6. ascending = nums; // 랜덤 nums값과 랜덤 ascending 값이 같다.
		// *1-7. ascending에다가 nums을 넣겠다. ascending이 랜덤이었다가 이부분에서 nums로 똑같이 바뀐다.
		// - 결국 ascending 랜덤 숫자는 어디론가 사라지고 nums만 남는 것!
		// - ascending에서 값을 바꾸면 nums에서도 바뀐다(?)

		// ↑와 ↓이 차이 : 값이 같거나 다르거나 

		// *1-8. 배열 내부의 값 복사
		// *1-9. ↓ 이렇게 넣으면 ascening과 nums값이 다르게 입력된다?
		for (int i = 0; i < nums.length; ++i) {
			ascending[i] = nums[i];
		}

		for (int i = 29; i >= 0; --i) {
			// 29번방에 넣겠다.↑   ↑ 랜덤숫자 30개중 최대값을 구해야 하기 때문에 0보다 크거나 같음으로 설정
			// i : 제일 큰 값을 찾아서 넣어야 하는 위치
			// --i : 29번방 → 28번방 → 27번방...으로 앞(왼쪽)으로 하나씩 빼아하기 때문에 --i로 입력
			// max : □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□
			//       ↑0번방 : 최대값 비교 후 제일 작은 값  ↑29번방 : 최대값 비교 후 제일 큰 값

			// 제일 큰 값 찾기
			// 최대값을 구한다 : {55, 1, 3, 9, 88, 8, 17, 53}
			//                0  1  2  3  4   5   6   7 번방
			// 0번방부터 1번방 비교 후 그 중 큰 값과 2번방 비교ing → 53(7번방, 끝방)과 최대값인 88(4번방) 교환

			// 제일 큰 값의 위치를 찾는 곳
			int max_index = 0; // 0 : 0번방, 현재까지의 최고 index 값을 남겨두는 곳
			for(int j = 1; j <= i; ++j) {
				if (ascending[max_index] < ascending[j]) {
					max_index = j; // 더 큰 값을 남긴다
				}
			}

			// 찾은 가장 큰 값과 마지막 위치의 값을 교환
			int temp = ascending[i];
			ascending[i] = ascending[max_index];
			ascending[max_index] = temp;
		}

		// ③ ★★★ 내림차순은 숙제!!!! 오름차순이랑 그냥 꺼꾸로 쓰면 됨 ★★★ 
		int[] descending = new int[30];

		for (int i = 0; i < nums.length; ++i) {
			descending[i] = nums[i];
		}

		for (int i = 29; i >= 0; --i) { // 제일 작은 값을 오른쪽에 넣는다.
			int min_index = 0;
			for(int j = 1; j <= i; ++j) {
				if (descending[min_index] > descending[j]) {
					// min_index 보다 작은 값 j
					// ascending과 descending의 차이가 나는 부분! 부등호! 나머지는 다 똑같음!
					min_index = j; // min_index 보다 작은 값 j를 min_index에 넣겠다.
				}
			}

			int temp = descending[i];
			descending[i] = descending[min_index];
			descending[min_index] = temp;
		}
		System.out.println("정렬 전 배열 : " + Arrays.toString(nums));
		System.out.println("오름차순 : " + Arrays.toString(ascending));
		System.out.println("내림차순 : " + Arrays.toString(descending));
	}
}