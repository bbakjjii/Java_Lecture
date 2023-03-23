package myobj;

import java.util.Random;

public class Peach implements Comparable {

	String kind; // 백도 황도
	int grade; // 1 ~ 5등급
	double sweet; // 10 ~ 20%
	int country; // 국가 코드
	int price; // 가격
	String countryName; // 국가명

	// 다른 패키지에서는 수정할 수 없도록 제어할 수 있음
	public int getPrice() {
		return price;
	}

	public double getSweet() {
		return sweet;
	}

	public String getCountryName() {
		return countryName;
	}

	// 중국(86), 이탈리아(39), 스페인(34), 미국(1)
	private static Random r = new Random();
	private static int[] countryCodes = {86, 39, 34, 1};
	private static String[] countryNames = {"China", "Italy", "Spain", "USA", };

	public Peach() {
		kind = r.nextBoolean() ? "백도" : "황도";
		grade = r.nextInt(5) + 1;
		sweet = r.nextDouble(10) + 10;
		int randomCountry = r.nextInt(countryCodes.length);
		country = countryCodes[randomCountry];
		countryName = countryNames[randomCountry];
		price = (r.nextInt(21) + 10) * 100; 	
	}

	// Object에 딸려 있는 것
	@Override
	public String toString() {
		return String.format("[%s/%d등급/%.2f%%/%s(%d), %d원\n",
				kind, grade, sweet, countryName, country, price);
	}

	// compareTo : Comparable 인터페이스에 딸려있는 추상 메서드
	// 				현재 인스턴스와 매개변수로 전달받은 인터페이스의 비교 결과를
	//				정의해놓아야 한다.
	@Override
	public int compareTo(Object o) {
		Peach p2 = (Peach)o;

		// this와 매개변수로 전달받은 인스턴스(p2)를 비교
		// return 1 : this가 더 크다(오름차순 시 오른쪽으로 가야한다.)
		// return 0 : 두 인스턴스의 크기가 같다
		// return -1 : this가 더 작다(오름차순 시 왼쪽으로 가야한다.)

		if (this.grade > p2.grade) { // 5등급인 애가 더 크니까 정렬시 뒤로 가라
			return 1; // this.grade가 더 크다.
		} else if (this.grade < p2.grade) {
			return -1;
		} else {
			return 0;
		}
	}
}
