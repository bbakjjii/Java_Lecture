package quiz;

import java.util.Arrays;

public class C02_Range {

	/*
문제.
1. 최대값을 매개변수로 전달하면
	0부터 최대값 미만의 int[]을 생성하여 반환하는
	range 메서드를 만들어 보세요.
	ex) range(8)의 결과 ⇒ [0, 1, 2, 3, 4, 5, 6, 7]

2. 최소값과 최대값을 인자로 전달하면
	최소값부터 최대값 미만의 int[]을 생성하여 반환하는
	range 메서드를 만들어 보세요.
	ex) range(10, 15)의 결과 ⇒ [10, 11, 12, 13, 14]
		range(15, 10)의 결과 ⇒ [15, 14, 13, 12, 11]

3. 최소값, 최대값, 증가값을 인자로 전달하면
	최소값부터 최대값 미만까지 증가값만큼 증가하는 int[]을 반환하는
	range 메서드를 만들어 보세요.
	ex) range(30, 40, 2) ⇒ [30, 32, 34, 36, 38]
		range(50, 40, -3) ⇒ [50, 47, 44, 41]
		range(50, 40, 5) ⇒ []
	 */

	// 1.
	public static int[] range(int num) {
		return range(0, num);
	}

	// 2. 
	public static int[] range(int begin, int end) {	
		// ----- 삼항 연산자
		if (begin == end) {
			return null;
		} else {
			if (begin > end) {
				return range(begin, end, -1);
			} else {
				return range(begin, end, 1);
			}
		}
		// ----- 삼항 연산자

		// return begin == end ? null :
		//	begin > end ? range(begin, end, -1) : range(begin, end, 1);
		// begin이 더 크면 -1, 아니면 1	
	}

	// 3.
	public static int[] range(int begin, int end, int inc) {
		int diff = end - begin; // 차이 = 최대값 - 최소값

		// inc가 0인 경우 증가값이 0이라 이상하므로 함수를 종료해버림
		if (inc == 0) { // 증가값 == 0
			return null; // null 아무값도 들어있지 않다?
		}

		// 길이 계산 (요소의 개수 계산)
		int len = diff / inc; // +2씩 증가하면 2로 나누고, +3씩 증가하면 3으로 나눈다.
		// 길이 계산이 음수가 나오면 뭔가 이상하다는 뜻이므로 함수를 종료해버림
		if (len <= 0) {
			return null;
		}

		// 차이가 증가값과 나누어 떨어지지 않는 경우 숫자가 하나 더 나온다
		len = diff % inc == 0 ? len : len + 1; // 0으로 나누어 떨어지면 len이고, 나누어 떨어지지 않으면 len + 1

		int[] arr = new int[len];


		for (int i = 0; i < len; ++i) {
			//       ↑0번째  요소의 갯수만큼 반복 ?
			arr[i] = begin + i * inc;
		}
		return arr;
	}

	// 1. 2. 3 결과 출력
	public static void main(String[] args) {
		System.out.println(Arrays.toString(range(8))); // 1.
		System.out.println(Arrays.toString(range(15, 20))); // 2.
		System.out.println(Arrays.toString(range(15, 8))); // 2.
		System.out.println(Arrays.toString(range(10, 14, 2))); // 3.
		System.out.println(Arrays.toString(range(10, 15, 2))); // 3.
		System.out.println(range(30, 10, 5));
		range(10, 30, 2); // 왼쪽값이 더 작을 때 : 양수
		range(30, 10, -2); // 왼쪽값이 더 클 때 : 음수

	}
}
