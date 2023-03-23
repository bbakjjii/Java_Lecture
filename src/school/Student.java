package school;

public class Student {

	String stuID;
	String name;
	char grade;

	// subject 타입 만들기(subject클래스)
	Subject subject;

	private static int studentCount = 0;

	public Student() {
		// String.format() : 원하는 문자열을 만들 때 서식을 사용할 수 있다.
		stuID = String.format("STU%06d", studentCount++);		

		// 서식을 받지 않았을 때 모양
		// 이 모양 보다 (String.foramt()서식을 사용하는게 더 보기 좋음)
		// stuID = "STU00000" + studentCount++;

		name = RandomNameGenerator.getName();

		switch(Subject.ran.nextInt(3)) {
		case 0:
			subject = new Programming();
			break;
		case 1:
			subject = new Network();
			break;
		case 2 :
			subject = new MachineLearning();
			break;
		}
	}

	public void printScore() {

		String[] subjectNames = subject.getSubjectNames();
		int[] subjectScores = subject.getSubjectScores();

		System.out.println("학번: " + this.stuID);
		System.out.println("이름: " + this.name);
		System.out.println("--------------------");

		for (int i = 0; i < subjectNames.length; ++i) {
			System.out.println(subjectNames[i] + ": " + subjectScores[i]);
		}

		System.out.println("--------------------");
		System.out.println("등급: " + subject.getGrade());
		System.out.printf("평균: %.2f\n", subject.getAvg());
		System.out.println("총점: " + subject.getTotal());
		System.out.println();
		System.out.println();
	}

}
