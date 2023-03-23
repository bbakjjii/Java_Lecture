
public class B14_Array01 {

	/*
# 배열 (Array)
· 같은 타입 변수를 한번에 여러개 선언하는 문법
· 같은 이름으로 변수를 여러개 선언한 후에 각 변수를 방 번호(index)로 구분한다.
· 배열은 반드시 선언과 동시에 크기를 정해야 한다.
· 크기가 정해지고 나면 크기를 변경할 수 없다.
· 배열의 인덱스는 0 ~ 길이-1번 까지 있다.
· 배열의 값은 생성과 동시에 자동으로 초기화 되어 있다.
  (정수(char은 정수형) : 0, 실수 : 0.0, boolean : false, 참조형 : null(String은 참조형)로 초기화 되어있다.)

# 배열 선언 방법
1. 타입[] 변수명 = new 타입[크기];
   ex) int[] numbers = new int[10];
2. 타입[] 변수명 = { 값1, 값2, 값3, 값4, ... };
3. 타입[] 변수명 = new 타입[]{ 값1, 값2, ... };

	 */

	public static void main(String[] args) {
		int[] numbers = new int[10]; // int형 변수를 10개 선언

		// 배열 이름에 방 번호로 접근하여 값을 사용할 수 있다.

		// 배열에 값 대입하기
		numbers[0] = 77;
		numbers[5] = 9999;
		numbers[9] = 1;

		// 배열의 값 꺼내서 사용하기
		System.out.println(numbers[5]);
		System.out.println(numbers[0] + numbers[9]);

		char[] str = new char[10]; // char형 변수 10개 선언

		// 배열 선언 방식
		int[] arr1 = new int[100];
		int[] arr2 = {44, 123, 9999, 7, 11, 5};
		// 0    1    2    3   4  5 ⇒ 길이 : 6
		int[] arr3 = new int[] {3, 4, 5, 5, 5, 1, 2, 1};

		System.out.println(arr2[4]); // 11이 나옴. 0부터 세어야 함.
		System.out.println(arr3[1]); // 4가 나옴.

		// 배열에 .을 찍고 length를 통해 길이를 구할 수 있다.
		// (String과 다르게 ()를 쓰지 않는다.)
		String[] animals = {"zibra", "monkey", "pig", "cat", "dog"};

		System.out.println("동물은 모두 몇 마리? " + animals.length);
		System.out.println("마지막 인덱스? " + (animals.length - 1));
		System.out.println(animals[0]);
		System.out.println(animals[1]);
		// System.out.println(animals[999]);

		// 변수는 반드시 초기화해야 사용할 수 있다. 어떤 값이 들어있는지 모르기 때문에.
		int apple = 0;
		System.out.println(apple);

		String fruit = "Dragon Fruits";
		System.out.println(fruit); 

		// but 배열의 값은 초기화 한적 없어도 사용할 수 있다.
		String[] fruits = new String[15];

		fruits[0] = "Initiallized Fruit";

		// 초기화한적 없는 fruits[7]도 사용할 수 있다.
		System.out.println(fruits[0]);
		System.out.println(fruits[7]);

		boolean[] complete = new boolean[22];

		// complete[22] = true; // 0~21까지 밖에 없기 때문에 아무것도 들어있지 않다.

		System.out.println(complete[5]); // false
		// System.out.println(complete[22]); // 0~21까지 밖에 없기 때문에 아무것도 들어있지 않다.

		// 배열은 반복문과 함께 사용하기 아주 좋은 형태로 설계되어있다.
		for (int index = 0; index < animals.length; ++index) {
			System.out.println(animals[index]);
		}

		// String 타입은 char[]로 변환하여 사용할 수 있다.
		String message = "Welcome to my web server";

		// char[] msg = {'W', 'e', 'l', 'c', 'o'}; 
		// 이렇게 수동으로 하나하나 입력하기 힘들기 때문에 한번에 입력하기 위해 toCharArray를 사용함.
		char[] messageArr = message.toCharArray();

		System.out.println(messageArr[0]);
		System.out.println(messageArr[1]);
		System.out.println(messageArr[messageArr.length - 1]);
	}
}
