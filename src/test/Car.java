package test;

import java.util.Random;

public class Car {

	String number;
	CarType type;

	private static Random r;

	final private static String USAGE_SYMBOLS = 
			"가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주하허호배공해육합국";


	final private static CarType[] CAR_TYPES = {
			CarType.NORMAL, CarType.NORMAL, CarType.NORMAL, CarType.NORMAL,
			CarType.NORMAL, CarType.NORMAL, CarType.NORMAL, CarType.NORMAL,
			CarType.EMERGENCY, CarType.EMERGENCY, CarType.EMERGENCY,CarType.EMERGENCY,
			CarType.KID, CarType.DISABLED
	};

	private static String randomCarNumber() {
		if (r == null) {
			r = new Random();
		}

		StringBuilder sb = new StringBuilder();
		sb.append(
				r.nextBoolean() ? 
						String.format("%02d", r.nextInt(99) + 1) : 
							String.format("%03d", r.nextInt(900) + 100));


		sb.append(USAGE_SYMBOLS.charAt(r.nextInt(USAGE_SYMBOLS.length())));
		sb.append(String.format("%04d", r.nextInt(10000)));

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
