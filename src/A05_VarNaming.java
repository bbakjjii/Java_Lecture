/*
	# 우리가 변수를 사용하는 이유
	· 가독성을 높일 수 있다.
	· 여러곳에서 사용되는 값을 한번에 변경할 수 있다.

	# 변수 작명 규칙 (권장)
	1. 두 단어 이상을 이어붙인 변수명을 사용할 때 _(언더바)를 사용한다.(snake_case)
		ex) apple_price, apple_weight, apple_qty(수량)
	2. 두 단어 이상을 이어붙인 변수명을 사용할 때 대문자를 사용한다. (camelCase)
	· 자바에서 가장 많이 사용함, snake_case 보다 많이 사용함
		ex) applePrice, appleWeight, appleQty
	3. 변수명의 첫 글자는 소문자를 사용해야 한다.
	· True와 true는 서로 다른 것으로 간주된다.
	4. 프로그램 내에서 프로그램이 꺼질때까지 변하지 않을 변수는 모두 대문자를 사용한다.
		ex) MAX_WEIGHT, MAX_QTY, PI(파이, 원주율)
	5. 클래스명의 첫 글자는 대문자를 사용한다.
	· 이름만으로 클래스와 변수를 구분하기 위한 장치
	6. 패키지명은 모두 소문자를 사용한다.
	7. 해당 변수의 목적이나 들어있는 값을 쉽게 파악할 수 있는 단어를 변수명으로 사용해야 한다.
	8. 변수의 이름은 나중에 알아볼 수 있도록 쉽게 써놔야 한다.
	9. 변수(변하는 수) ↔ 상수(변하지 않는 수)
 
	# 변수 작명 규칙 (필수)
	1. 변수의 첫 번째 글자는 숫자를 사용할 수 없다.
		ex) 7eleven, 1st, 2nd, 4pple
	2. 변수명 사이에는 공백을 사용할 수 없다.
	3. 특수문자는 _와 $만 사용할 수 있다.
		ex) $uperman
	4. 이미 자바에서 사용하고 있는 키워드(예약어)들은 변수명으로 사용할 수 없다.
		(Eclipse에서 예약어들은 보라색으로 표시된다)
		ex) public, static, void, double, ...
	
	Q. 다음 중 변수의 이름으로 사용할 수 있는 것은? (모두 고르시오)
	A. a, d, e, g
	a. $ystem : O 
	∵ 특수문자는 _와 $만 사용할 수 있다.
	b. channel#5 : X 
	∵ # 때문에
	c. 7eleven : X
	∵ 변수의 첫 번째 글자는 숫자를 사용할 수 없다.
	d. If : O
	e. 자바 : O
	f. new : X
	∵ 이미 자바에서 사용하고 있는 키워드(예약어)들은 변수명으로 사용할 수 없다.
	g. $MAX_NUM : O
	∵ 특수문자는 _와 $만 사용할 수 있다.
	∵ 두 단어 이상을 이어붙인 변수명을 사용할 때 _(언더바)를 사용한다.(snake_case)
	∵ 프로그램 내에서 프로그램이 꺼질때까지 변하지 않을 변수는 모두 대문자를 사용한다.
	h. hello@com : X
	∵ 특수문자는 _와 $만 사용할 수 있다.
*/
	
public class A05_VarNaming {	
	public static void main(String[] args) {
		int apple = 19; //apple = 변수명
		int apple_price = 483;
		double apple_weight = 123.47;
		
		System.out.println("사과의 개수: " + apple);
		System.out.println("사과의 총 가격(￦) : " + apple * apple_price + "원");
		System.out.println("사과의 총 무게(g) : " + apple_weight + "g");
		System.out.println("사과의 g당 가격 : " + (apple * apple_price) / (apple * apple_weight) + "원");
	}

}

