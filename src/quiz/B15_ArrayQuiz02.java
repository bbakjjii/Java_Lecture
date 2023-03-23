package quiz;

import java.util.Arrays;

public class B15_ArrayQuiz02 {

	public static void main(String[] args) {

		// 보기.	
		int[][] numArr = {
				{1, 1, 1, 1, 1,}, // 0
				{1, 1, 1}, // 1
				{1, 1, 1, 1, 1, 1, 1, 1}, //2
				{1, 1}, // 3
				{1, 1, 1, 1}  //4
		};

		// 문제.
		// 1. numArr의 모든 값을 100 ~ 200 사이의 랜덤 정수로 바꾸기
		// 2. 랜덤으로 바뀐 모든 값의 총합과 평균(소수점 둘째자리)을 구하기
		// 3. numArr의 각 행(가로, row)의 합을 구해서 출력하기
		// 4. numArr의 각 열(세로, column)의 합을 구해서 출력하기

		// 1. numArr의 모든 값을 100 ~ 200 사이의 랜덤 정수로 바꾸기
		for (int i = 0; i < numArr.length; ++i) {
			// i : numArr.length : 배열의 갯수
			for (int j = 0; j < numArr[i].length; ++j) {
				// j : 해당 i번째 배열의 길이
				numArr[i][j] = (int)(Math.random() * 101 + 100);
			}
			System.out.println(Arrays.toString(numArr[i]));
		}

		// 2. 랜덤으로 바뀐 모든 값의 총합과 평균(소수점 둘째자리)을 구하기
		int sum = 0, cnt = 0;
		// sum : 총합, cnt : 갯수
		for (int i = 0; i < numArr.length; ++i) {
			// 내부 배열의 길이로 요소의 개수를 구할 수 있음
			//		cnt += numArr[i].length; // 하나씩 구하기
			for (int j = 0; j < numArr[i].length; ++j) {
				sum += numArr[i][j];
				++cnt; // 한번에 구하기
			}
		}
		System.out.printf("총합 : %d\n개수 : %d\n평균: %.2f\n",
				sum, cnt, sum / (double)cnt);


		// 3. numArr의 각 행(가로, row)의 합을 구해서 출력하기
		int[] rowSum = new int[numArr.length];

		// 가장 길이가 긴 행을 찾아야 컬럼의 개수를 알 수 있다.
		int max_column_size = numArr[0].length;
		for (int i = 0; i < numArr.length; ++i) {
			if (max_column_size < numArr[i].length) {
				max_column_size = numArr[i].length;
			}
		}
		// System.out.println("가장 길이가 긴 행 : " + max_column_size); // 테스트

		// 열의 합은 컬럼의 개수만큼 있다.
		int[] colSum = new int[max_column_size]; // 제일 column길이가 긴 애를 찾아서 넣어야 함
		for (int row = 0; row < numArr.length; ++row) {
			for (int col = 0; col < numArr[row].length; ++col) {

				rowSum[row] += numArr[row][col];
				colSum[col] += numArr[row][col];
				// ↑↓ 둘 다 같은 말임
				//----------				
				//if(row == 0) {
				//	rowSum[0] += numArr[row][col];
				//} else if (row == 1) {
				//		rowSum[1] += numArr[row][col];
				//}
				//if (col == 0) {
				//	colSum[0] += numArr[row][col];
				//} else if (col == 1) {
				//	colSum[1] += numArr[row][col];
				// ----------
			}
		}
		System.out.println("행의 합 : " + Arrays.toString(rowSum));
		System.out.println("열의 합 : " + Arrays.toString(colSum));
	}
}