import java.util.Random;

public class B12_Random {

	/*
# 무작위 숫자 생성하기
1. Math.random() 함수 사용하기 (어려워서 안 함..)
2. java.util.Random 클래스 사용하기
	 */

	public static void main(String[] args) {

		// 2. java.util.Random 클래스 사용하기
		// # new Random()으로 새로운 랜덤 시드 생성
		// · 시드 : 여러 숫자가 순서대로 저장되어 있는 것
		// · 같은 시드 번호로 설정하면 계속 같은 숫자가 순서대로 나오게 된다
		// · 원하는 타입을 선택하여 꺼낼 수 있다.
		Random ran = new Random();

		// nextInt()에 int 값을 전달해 랜덤 숫자의 범위를 설정할 수 있다.
		// · 100을 전달하면 0부터 99까지의 정수를 반환 (100개)
		// · 101을 전달하면 0부터 100까지의 정수를 반환 (101개)
		// · 먼저 숫자의 개수를 정하고 더하거나 빼서 숫자의 시작 지점을 정할 수 있다.
		System.out.println(ran.nextInt()); // 양수나 음수가 나옴
		System.out.println(ran.nextInt(100)); // 양수만 나옴
		System.out.println(ran.nextInt(100) - 200); // -200 ~ -101까지 나옴
		System.out.println(ran.nextInt(101) - 200); // -200 ~ -100까지 나옴
		System.out.println(ran.nextInt(100));
		System.out.println(ran.nextDouble());
		System.out.println(ran.nextDouble());
		System.out.println(ran.nextDouble());
		System.out.println(ran.nextBoolean());

		System.out.println("----------");

		// 1. Math.random() 함수 사용하기 (어려워서 안 함..)
		// Math.random() : 0 <= x < 1의 랜덤 소수를 생성한다.
		// · 0은 포함하되 1미만인 소수를 생성
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());

		System.out.println("----------");

		// Math.randome()을 사용해 원하는 범위의 랜덤 정수 만들기
		// (1) 소수를 int로 변환하면 소수점 아래를 모두 버린다.
		System.out.println((int)Math.random()); 

		// (2) 0 <= x < 1인 소수에 원하는 범위를 곱한 후 int로 변환하면
		//     원하는 범위의 랜덤 정수를 생성할 수 있다.
		//     ⇒ ran.nextInt(int bound)에 범위를 설정하는 것과 같음
		// 0 * 10 <= x < 1 * 10 : 0 ~ 9까지 나옴
		System.out.println((int)(Math.random() * 10));

		// 0 * 100 <= x < 1 * 100 = 0 ~ 99까지 나옴
		System.out.println((int)(Math.random() * 100));

		// 0 * 1000 <= x < 1 * 1000 : 0 ~ 999까지 나옴
		System.out.println((int)(Math.random() * 1000));

		// 0 * 85 <= x < 1 * 85 = 0 ~ 84까지 나옴
		System.out.println((int)(Math.random() * 85));

		System.out.println("----------");

		// (3) 만들어진 정수에 값을 더하거나 빼서 원하는 범위를 설정
		System.out.println((int)(Math.random() * 85) - 300); // // 84 - 300 = -300 ~ -216까지 나옴
		System.out.println((int)(Math.random() * 85) + 100); // 100 ~ 184

		System.out.println("----------");

		// 연습 : 1 ~ 45의 랜덤 정수를 10개 출력해보세요		
		for (int i = 0; i < 10; ++i) {
			// 0 ~ 44 + 1 => 1 ~ 45
			System.out.print(ran.nextInt(45) + 1 + " ");	
		}
		System.out.println();

		System.out.println("----------");		

		System.out.println((int)(Math.random() * 10) + 37);
		System.out.println(0 + 36);
		System.out.println(1 + 36);
		System.out.println(2 + 36);
		System.out.println(3 + 36);
		System.out.println(4 + 36);
		System.out.println(5 + 36);
		System.out.println(6 + 36);
		System.out.println(7 + 36);
		System.out.println(8 + 36);
		System.out.println(9 + 36);
	}
}
