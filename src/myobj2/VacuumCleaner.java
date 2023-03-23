package myobj2;

public class VacuumCleaner extends Electronics {
	
	public VacuumCleaner() {
		super("진공 청소기", 25000);
	}

	@Override
	public void start() {
		System.out.println("원하는 곳을 잘 청소하기 시작했습니다.");
	}
}
