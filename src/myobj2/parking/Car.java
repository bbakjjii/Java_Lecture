package myobj2.parking;

import java.util.Random;

public class Car {

	String number;
	CarType type;

	private static Random r;

	// 나무위키 참고 : 대한민국의 차량 번호판
	final private static String USAGE_SYMBOLS = 
			"가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주하허호배공해육합국";

	// 이미 만들어져 있는 인스턴스를 가져다 쓴 것.(CarType에서 만들어 둔 것을 가져다 쓰는 것.) 새로운 CarType을 만든 것이 아니다.
	// CarType 클래스에서 static으로 만들어졌기 때문에 공동영역에 딱 하나만 생기고, 공동영역에 생긴 CarType을 Car 클래스에서 가져다 쓰는 것이다.
	// 여러번 반복하면 출력값의 비중이 많이 나온다.
	final private static CarType[] CAR_TYPES = {
			CarType.NORMAL, CarType.NORMAL, CarType.NORMAL, CarType.NORMAL,
			CarType.NORMAL, CarType.NORMAL, CarType.NORMAL, CarType.NORMAL,
			CarType.LIGHTCAR, CarType.LIGHTCAR, CarType.LIGHTCAR,CarType.LIGHTCAR,
			CarType.KID, CarType.DISABLED
	};

	private static String randomCarNumber() {
		if (r == null) {
			r = new Random();
		}

		// 두자리(1~99번), 세자리(100~999번)
		StringBuilder sb = new StringBuilder();
		sb.append(
				r.nextBoolean() ? 
						String.format("%02d", r.nextInt(99) + 1) : 
							String.format("%03d", r.nextInt(900) + 100));

		sb.append(USAGE_SYMBOLS.charAt(r.nextInt(USAGE_SYMBOLS.length()))); // 가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주하허호배공해육합국
		sb.append(String.format("%04d", r.nextInt(10000))); // 0000 ~ 9999

		return sb.toString();
	}

	private static CarType randomCarType() {
		if (r == null) {
			r = new Random();
		}
		return CAR_TYPES[r.nextInt(CAR_TYPES.length)];
	}

	public Car() {
		number = randomCarNumber();
		type = randomCarType();
		// System.out.println("차번호 : " + number); // test용
		// System.out.println("타입  : " + type); // test용
	}

	public String getNumber() {
		return number;
	}

	public CarType getType() {
		return type;
	}

	@Override
	public String toString() {
		return number + "/" + type.getDisplayName();
	}
}
