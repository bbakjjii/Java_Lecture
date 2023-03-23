package myobj2;

public class Electronics {

	String name;
	String manual;
	int price;

	public Electronics(String name, int price) { // 가격은 반드시 채워야 한다.
		this.name = name;
		this.price = price;
	}

	public void info() { // 제품 정보
		System.out.printf("제품명 : %s, 가격 : %d\n", name, price);
	}

	public void printManual() { // 메뉴얼이 비어있다면 메뉴얼이 없는 제품입니다.
		if (manual != null) {
			System.out.println(manual);
		} else {
			System.out.println("메뉴얼이 없는 제품입니다.");
		}
	}

	public void start() { // 모든 전자제품은 start버튼이 있다.
		System.out.println("전자제품이 작동하기 시작했습니다.");
	}

	// 진공청소기에만 있는 기능 (모든 전자제품, 에어프라이어에 없는 기능)
	public void replaceFilter() {
		System.out.println("진공 청소기의 필터를 새것으로 교환했습니다.");
	}
}
