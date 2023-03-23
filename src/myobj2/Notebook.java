package myobj2;

public class Notebook {
	
	String model;
	String manufacturer ;
	int price;
	
	public Notebook(String model, String manufacturer, int price) {
		this.model = model;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	
	public void information() {
		System.out.printf("노트북 - 모델 : %s, 제조사 : %s, 가격 : %d원\n", model, manufacturer, price);	
	}	
}
