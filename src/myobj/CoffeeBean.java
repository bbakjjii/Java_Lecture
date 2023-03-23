package myobj;

public class CoffeeBean {
	
	// 번호만 다르면 이름은 모두 공통으로 사용할 수 있다.
	static String[] countryNames = {"브라질", "베트남", "콜롬비아", "인도네시아", "에티오피아", "온두라스", "인도"};
	static String[] variousNames = {"아라비카", "로부스타", "리베리카"};

	int country;
	int various;
	
	// 커피빈이라는 클래스가 존재할 때부터 존재하는 인스턴스
	// static 영역에서 해당 클래스의 인스턴스를 미리 만들어 놓을 수 있다.
	public static CoffeeBean BRAZILIAN_ARABICA = new CoffeeBean(0,0); // 자주 사용되는 커피조합
	public static CoffeeBean COLOMBIAN_ROBUSTA = new CoffeeBean(0,2); // 자주 사용되는 커피조합
		
	public CoffeeBean(int various, int country) { // int 1, int 3 = 아바리카, 콜롬비아
		this.various = various;
		this.country = country;
	}
	
	public void info() {
		System.out.printf("품종:%s, 생산국:%s\n", variousNames[various], countryNames[country]);
	}
}
