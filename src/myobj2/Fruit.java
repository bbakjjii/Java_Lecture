package myobj2;

public class Fruit {

	String fruitName;
	String color;
	
	public Fruit (String fruitName, String color) {
		this.fruitName = fruitName;			
		this.color = color;
	}
	
	public void intro() {
		System.out.printf("%s는 %s의 색상을 가진 과일이다.\n", fruitName, color);
	}
	
	
	
	
	
	
	
}
