package myobj2;

public class TropicalFruit extends Fruit {

//	String fruitName;
	String fruitName = "파인애플";
	
	public TropicalFruit(String fruitName, String color) {
		super(fruitName, color);
	}
	
	@Override
	public void intro() {
		String fruitName = "망고";
		int sugar = 30;
		
		System.out.printf("열대과일 %s는 %s색 과일이고, 일반 과일에 비해 %d%%당도가 더 높다\n", fruitName, color, sugar);
	}
	// name --> 망고, this.name --> 파인애플, super.name --> 바나나
	
	public void origin(String country) {
		System.out.printf("원산지는 %s이다.\n", country);
	}

	
	
}
