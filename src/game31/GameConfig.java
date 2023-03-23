package game31;

public class GameConfig {
	
	int lastNum; // 마지막 숫자
	int players; // 플레이어
	int bound; // 선택할 수 있는 숫자 범위
	
	public GameConfig(int lastNum, int players, int bound) {
		this.lastNum = lastNum;
		this.players = players;
		this.bound = bound;
	}

	@Override
	public String toString() {
		return"[마지막번호=" + lastNum + ", 플레이어"	+ players
				+ "명, 숫자범위1~" + bound + "]";
	}
}
