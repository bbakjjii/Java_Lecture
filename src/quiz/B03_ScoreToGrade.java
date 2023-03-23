package quiz;

import java.util.Scanner;

public class B03_ScoreToGrade {



	/*
Q. 국어, 영어, 수학 점수를 차례대로 입력받아 평균 점수를 구한 후에
   각 과목 점수, 평균 점수, 등급을 출력해주는 프로그램을 만들어보세요.

1. 90점 이상 A
   80점 이상 B
   70점 이상 C
   60점 이상 D
   그 외 F

 2. 유효한 점수는 0 ~ 100점이다. (유효하지 않은 점수가 하나라도 있다면 F) ??????

 3. 평균 점수는 소수 둘째 자리에서 반올림하여 저장 ???????????
	 */



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int kor, eng, math;
		double avg;

		System.out.print("국어, 영어, 수학 점수를 입력 >> ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();

		avg = Math.round((kor + eng + math) / 3.0 * 100) / 100.0;

		char grade;

		if(kor < 0 || kor > 100 || eng < 0 || eng > 100 || math < 0 || math > 100) { 
			System.out.println("유효하지 않은 점수가 있습니다.");
			grade = 'F';
		} else if (avg >= 90) {			
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}	

		System.out.printf("국어 %d, 영어 %d, 수학 %d, 평균 %.2f, 등급 %c\n", kor, eng, math, avg, grade);
	}
}


