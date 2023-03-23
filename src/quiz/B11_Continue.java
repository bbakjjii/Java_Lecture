package quiz;

public class B11_Continue {

	/*
문제.
1. 1부터 30까지 한 줄에 숫자를 5개씩 출력
2. 1부터 200까지의 숫자 중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합
	 * While문을 사용해야 함
	 * While문 내부에도 break와 continue를 사용할 수 있다.
	 */

	public static void main(String[] args) {

		// 1.
		int num = 1;
		while (num <= 30) {
			System.out.print(num + "\t");
			num++;

			if (num % 5 == 1) {
				System.out.println();
			}
		}
		System.out.println("-----------");

		System.out.print(1 + "\t");
		System.out.print(2 + "\t");
		System.out.print(3 + "\t");
		System.out.print(4 + "\t");
		System.out.print(5 + "\t");
		System.out.println();
		System.out.print(6 + "\t");
		System.out.print(7 + "\t");
		System.out.print(8 + "\t");
		System.out.print(9 + "\t");
		System.out.print(10 + "\t");
		System.out.println();

		System.out.println("-----------");

		// 2.
		int sum = 0;
		num = 0;

		while (num++ < 200) {
			System.out.println(num);

			if (num % 2 != 0 && num % 3 != 0) {
				sum += num;
			}
		}
		System.out.println("sum : " + sum);
		System.out.println("------------");

		// while문에서 가장 중요한 것은 증감값의 위치에 따라
		// 숫자가 몇 부터 몇 까지 반복될지 정확하게 아는 것
		int i;

		// 1)
		i = 0;

		while (i++ < 10) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("------------");

		// 2) 10이지만 9번 반복하므로 별로인 반복문
		i = 0;

		while (++i < 10) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("------------");

		// 3)
		i = 0;

		while (i < 10) {
			System.out.print(i++ + " ");
		}
		System.out.println();

		i = 0;

		System.out.println("------------");

		// 4)
		while (i < 10) {
			System.out.print(++i + " ");
		}
		System.out.println();
	}
}