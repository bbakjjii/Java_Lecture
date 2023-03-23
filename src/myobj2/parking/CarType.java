package myobj2.parking;

public class CarType {
	
	// static이기 때문에 공동영역에 딱 하나만 생기고, 공동영역에 생긴 CarType을 Car 클래스에서 가져다 쓰는 것이다.
	final public static CarType NORMAL = new CarType(0); // 일반
	final public static CarType DISABLED = new CarType(1); // 장애인
	final public static CarType KID = new CarType(2); // 유아동승
	final public static CarType LIGHTCAR = new CarType(3); // 경차
	
	private static String[] displayNames = {"일반", "장애인", "유아동승", "경차"};
	
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
	
	// 주소가 같은 게 같은 것이다(?)
	@Override
	public boolean equals(Object obj) {
		return this.value == ((CarType)obj).value;
	}
}
