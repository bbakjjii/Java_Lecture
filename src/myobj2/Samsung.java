package myobj2;

public class Samsung extends Notebook{
	
	String model = "그램";
	
	public Samsung(String model, String manufacturer, int price) {
		super(model, manufacturer, price);
	}
		
	@Override
	public void information() {
		String model = "갤럭시북";
		System.out.printf("이 노트북의 모델명은 %s, 제조사는 %s, 가격은 %d원 입니다.\n", model, manufacturer, price);
	}
	
	public void modelName() {
		System.out.println("그냥 model: " + model);
		System.out.println("this.model: " + this.model); 
		System.out.println("super.model: " + super.model);
	}
	
	public void version(int vers) {
		System.out.printf("모델명 : %s %d세대, 제조사 : %s, 가격 : %d원\n", super.model, vers, super.manufacturer, super.price);		
	}
}
