import myobj.Apple;
import myobj.Banana;
import myobj.Coffeemachine;

public class C04_Constructor {
	
/*
 # 클래스의 생성자(Constructor)
 · 새로운 인스턴스를 생성할 때 new와 함께 호출하는 것
 · 클래스 이름과 동일한 이름은 가진 메서드
 · 생성자를 정의하지 않은 클래스에는 아무것도 없는 기본 생성자를 자동으로 생성해준다.
 · 생성자는 새로운 인스턴스 생성시 가장 먼저 호출할 수 밖에 없는 메서드이기 때문에 주로 해당 인스턴스의 초기화에 많이 사용된다.
*/
	
	public static void main(String[] args) {
		
		// new Apple_1024 : 새 인스턴스를 만들때 반드시 호출
		Apple a = new Apple();
		// F3 : 어디서 가져왔는지 볼 수 있음(?)
		Apple a2 = new Apple(99, 8, "red");	
		Apple a3 = new Apple(77,5);
		
		a.info(); // 기본 설정
		System.out.println("----------");
		a2.info(); // 변경 설정
		System.out.println("----------");
		a3.info(); // 변경 설정
		System.out.println("----------");
		
		// 기본 생성자의 사용을 막아놓은 클래스
		// · 장점 : 이상한 바나나의 생성을 막는다(개수만 있거나 색깔만 있는 것을 방지)
		//Banana b1 = new Banana(8, "푸르딩딩");
		
		// 연습 : C03에서 연습으로 만들었던 클래스에 생성자 추가해보기
		Coffeemachine c = new Coffeemachine();
		Coffeemachine c2 = new Coffeemachine("grande");
		Coffeemachine c3 = new Coffeemachine("caffelatte", "tall");
		Coffeemachine c4 = new Coffeemachine("vanillalatte", "venti", 6000);
		
		c.info();
		System.out.println("**********");
		c2.info();
		System.out.println("**********");
		c3.info();
		System.out.println("**********");
		c4.info();
		System.out.println("**********");
	}
}
