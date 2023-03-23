package rock_paper_scissors;

public class Player {
	
	static int total = 0;
	static int win = 0;
	static int lose = 0;
	static int draw = 0;


	public static void plusTotal() {
		total += 1;
	}
	
	public static void plusWin() {
		win += 1;
	}
	
	public static void plusLose() {
		lose += 1;
	}
	
	public static void plusDraw() {
		draw += 1;
	}
	
	@Override
	public String toString() {
		return String.format("Player님의 전적: %d전 %d승 %d무 %d패",
				total, win, draw, lose);
	}
}
