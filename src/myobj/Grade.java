package myobj;

public class Grade {
	
	public int kor;
	public int eng;
	public int math;
	
	public Grade(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public boolean equals(Object obj) {
		// obj가 더 상위 클래스. 업캐스팅 되어 들어왔기 때문에 자식 클래스에 있는 것을 사용할 수 없다.
		// 다운 캐스팅을 해줘야 한다.
		return this.kor == ((Grade)obj).kor
				&& this.eng == ((Grade)obj).eng
				&& this.math == ((Grade)obj).math;
	}
}
