package quiz;

public class B02_ConditionQuiz01 {

	/*
# 알맞은 비교 연산을 만들어보세요.
1. int형 변수 a가 10보다 크고 20보다 작을 때 true
2. int형 변수 b가 짝수일 때 true
3. int형 변수 c가 7의 배수일 때 true
4. int형 변수 d와 e의 차이가 30일 때 true
5. int형 변수 year가 400으로 나누어 떨어지거나
	또는 4로 나누어 떨어지고 100으로 나누어 떨어지지 않을 때 true
6. boolean형 변수 powerOn이 false일 때 true
7. 문자열 참조변수 str이 "yes"일 때 true
	 */

	public static void main(String[] asg) {
		// 1. int형 변수 a가 10보다 크고 20보다 작을 때 true
		int a = 30;
		boolean result1 = a > 10 && a < 20; // int + int = boolean, boolean + boolean = boolean
		// 오답 1) 10 < a < 20 : int + int + int → boolean + int = 무조건 true만 됨
		// 오답 2) 10 < a && a < 20 : 연산을 할 때 변수가 왼쪽에 있는 것이 좋다.
		System.out.println("1번 결과 : " + result1); 

		// 2. int형 변수 b가 짝수일 때 true
		int b = 3;
		System.out.println("2번 결과 : " + (b % 2 == 0));

		// 3. int형 변수 c가 7의 배수일 때 true
		int c = 49;
		System.out.println("3번 결과 : " + (c % 7== 0));

		// 4. int형 변수 d와 e의 차이가 30일 때 true
		int d = 70, e = 41;
		boolean result4 = Math.abs(d - e) == 30;
		System.out.println("4번 결과 : " + result4);

		// 5. int형 변수 year가 400으로 나누어 떨어지거나 또는 4로 나누어 떨어지고 100으로 나누어 떨어지지 않을 때 true
		// ⇒ 2월이 하루 더 있나 없나를 알 수 있는 공식 (윤년)
		int year = 2100;
		boolean result5 = year % 400 == 0 || (year % 4 == 0 && year % 100 !=0);
		System.out.printf("%d년에는 2월이 하루 더 있나요? %s\n", year, result5);

		// 6. boolean형 변수 powerOn이 false일 때 true
		// ⇒ 전원의 켜짐/꺼짐 여부
		boolean powerOn = false;
		System.out.printf("지금 전원이 꺼져있나요? %s\n", (!powerOn));	

		// 7. 문자열 참조변수 str이 "yes"일 때 true (이해 못함!!!!!!!!!)
		// 기본형 : 데이터를 차곡차곡 쌓는 곳(스택)에 용량을 확보하고 거기에 값을 직접 저장
		//		ex) int, float, double, ...
		// 참조형 : 데이터의 길이가 어떻게 될지 모르기 때문에 데이터를 차곡차곡 쌓는 곳에 넣으면 비효율적이다.
		//        스택에는 실제 데이터의 주소(메모리상의 위치)를 저장하고 실제 데이터는 데이터를 유동적으로 저장하는 곳(힙)에 저장한다.
		//		ex) String, ...
		// * 스택, 힙(참고 사이트) : https://n1tjrgns.tistory.com/213

		// String은 ==(비교 연산)으로 비교하면 안된다.
		String str1 = "yes"; // str1, str2는 같은 주소값
		String str2 = "yes";
		String str3 = new String("yes"); // str3은 새로운 주소값

		// * 참조형 변수(str1, str2)끼리 ==(비교연산)을 통해 비교하면 실제 내용이 아닌 주소끼리 비교한다.
		//   참조형 변수는 ==로 비교하지 않는다.
		// new String("yes") : 억지로 새로 하나 만들어서 넣은 것.
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);

		// * 참조형 변수의 실제 내용을 통해 비교하기 위해서는 equals() 메서드를 사용해야 한다.
		System.out.println(str1.equals(str3)); // 정답
		System.out.println(str2.equals(str3)); // 정답
	}
}
