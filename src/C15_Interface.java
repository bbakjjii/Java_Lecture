import myobj.Banana;
import myobj3.Running;
import myobj3.Shark;
import myobj3.Swimming;
import myobj3.Turtle;

public class C15_Interface {

	/*
# 인터페이스 (Interface)
· 여러 개 상속받을 수 있는 추상 클래스
· 인터페이스 내부는 구현이 불가능하다.
· 인터페이스 내부에 선언하는 메서드는 모두 자동으로 abstract public이 된다.
· 인터페이스 내부에 선언하는 모든 변수들은 자동으로 final static이 된다.
· 자바는 클래스 상속을 여러 개 받을 수 없기 때문에
  한 클래스가 더욱 다양한 형태를 지니기 위해서는 인터페이스를 사용해야 한다.
	ex) shark만 있으면 그냥 클래스 → 상속을 받으면 Animal(의 Shark가 되는 것)

# 인터페이스의 특징
· 인스턴스화가 불가능하다.
· 클래스처럼 타입 역할이 가능하다.
· 해당 인터페이스 타입으로 업캐스팅 가능 
	 */

	public static void main(String[] args) {
		Swimming s1 = new Shark();
		Swimming s2 = new Turtle();
		
		Running r1 = new Turtle();
		Running r2 = (Turtle)s2;
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(r1);
		System.out.println(r2);
		
		// 에러 : 왜 shark를 turtle로 다운캐스팅??(??)
		// 에러 : shark는 running이 implements되어 있지 않음
		// Running r2 = (Turtle)s1;
		
		Banana b = new Banana(10,"초록색");
		System.out.println(b.toString());
		System.out.println(b);
	}
}
