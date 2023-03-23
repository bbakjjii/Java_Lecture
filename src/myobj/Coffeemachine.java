package myobj;

public class Coffeemachine {

	// 커피 머신
	// · 상태 : 커피종류(String), 커피사이즈(String), 커피가격(int), 커피갯수(int)
	// · 메서드 : 종류별 가격(int), 사이즈별 가격(int), 10잔 당 1잔 서비스(int)

	public String type;
	public String size;
	public int qty;
	public int price;

	public void sizeUp() {
		price += 500;
	}
	public void sizeDown() {
		price -= 500;
	}

	public void service() {
		if (qty >= 10) {
			System.out.println("서비스 드림 : " + qty / 10);			
		} else {
			System.out.println("서비스 안드림");
		}
	}

	// 기본설정		
	public Coffeemachine() { 
		type = "Americano";
		size = "tall";
		price = 4500; 
	}

	public Coffeemachine(String size) {
		this.type = "Americano";
		this.size = size;
		this.price = 5000;
	}

	public Coffeemachine(String type, String size) {
		this.type = type;
		this.size = size;
		this.price = 5000;
	}

	public Coffeemachine(String type, String size, int price) {
		this.type = type;
		this.size = size;
		this.price = price;						
	}

	public void info() {
		System.out.printf("종류 : %s\n크기 : %s\n가격 : %d\n",
				this.type, this.size, this.price);
	}
}