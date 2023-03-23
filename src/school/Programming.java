package school;

import java.util.Random;

// -- 5 --
// 과목을 상속 받는 프로그래밍반
// 국어, 영어, 수학, 프로그래밍 언어, 운영체제, 자료구조 점수가 있다.
// kor, eng, math, programming language, OS, data structure

public class Programming extends Subject {
	
	int kor;
	int eng;
	int math;
	int programingLanguage;
	int operatingSystem;
	int dataStructure;
	// -- 5 --
	
	// -- 7 --
	public Programming() {
		kor = ran.nextInt(101);
		eng = ran.nextInt(101);
		math = ran.nextInt(101);
		programingLanguage = ran.nextInt(101);
		operatingSystem = ran.nextInt(101);
		dataStructure = ran.nextInt(101);
		
	}
	// -- 7 --
	
	
	// -- 6 --
	public Programming (int kor, int eng, int math, int programingLanguage, int operatingSystem, int dataStructure) {
		
		this.kor = kor;
		this.eng = eng;
		this.math = math ;
		this.programingLanguage = programingLanguage;
		this.operatingSystem = operatingSystem;
		this.dataStructure = dataStructure;

	}
	// -- 6 --
	
	
	// -- 16 --
	@Override
	public int getTotal() {
		return kor + eng + math + programingLanguage + operatingSystem + dataStructure;
	}
		

	
	@Override
	public double getAvg() {
		return getTotal() / 6.0;
	}


	@Override
	public char getGrade() {
		double avg = getAvg();
		if (getAvg() >= 90) {
			return 'A';
		} else if (avg >= 80) {
			return 'B';
		} else if (avg >= 70) {
			return 'C';
		} else if (avg >= 60) {
			return 'D';
		} else {
		return 'F';
		}
	}

	
	// -- 17 --
	@Override
	public String[] getSubjectNames() {
		return new String[] {"국어", "영어", "수학", "프로그래밍 언어", "운영체제", "자료구조"};
	}
	// -- 17 --
	
		
	@Override
	public int[] getSubjectScores() {
		return new int[] {kor, eng, math, programingLanguage, operatingSystem, dataStructure};
		
		// -- 16 --
	}
}
