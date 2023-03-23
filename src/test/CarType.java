package test;

public class CarType {
	
	
	final public static CarType NORMAL = new CarType(0); // 일반
	final public static CarType DISABLED = new CarType(1); // 장애인
	final public static CarType KID = new CarType(2); // 유아동승
	final public static CarType EMERGENCY = new CarType(3); // 긴급
	
	private static String[] displayNames = {"일반", "장애인", "유아동승", "긴급"};
	
	int value;
	
	private CarType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getDisplayName() {
		return displayNames[value];
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return this.value == ((CarType)obj).value;
	}

}
