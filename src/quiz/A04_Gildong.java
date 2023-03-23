package quiz;

public class A04_Gildong {
	public static void main(String[] args) {
		// 변수명은 소문자로 시작한다.
		String name = "홍길동"; //문자열
		int age = 20; //정수
		String tel = "010-1234-1234"; // int 사용 불가
		float heigh = 178.5F; // double height = 178.5
		double weight = 75; // 몸무게는 소수점까지 나올 수 있기 때문에 double 타입으로 저장
		String blood_type = "O"; 
		//char 타입(문자 하나만을 저장할 수 있기 때문에)으로 저장하지 않는다. 나중에 AB형이 나올 수 도 있기 때문에 
		
		System.out.println("========== 출력 결과 ==========");
		System.out.println("이름\t: " + name);
		System.out.println("나이\t: " + age);
		System.out.println("Tel\t: " + tel);
		System.out.println("키\t: " + heigh);
		System.out.println("몸무게    : " + weight);
		System.out.println("혈액형    : " + blood_type);		
	}
}

