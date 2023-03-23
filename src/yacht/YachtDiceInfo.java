package yacht;

public class YachtDiceInfo {
	
	// 왜 check에 와서 점수를 수정해야 하냐?
	// - 생성자를 private로 돌리면 다른 곳에서 생성하는 것을 막아 new를 통해 YachtDiceInfo를 할 수 없게 된다.?
	// - 관련성 있는 코드로 묶어 놓을 수 있다.
	// 외부에서는 미리 생성해놓은 인스턴스만 사용할 수 있다. (접근제어자를 이용한 디자인 패턴)
	// - 디자인패턴 책 따로 구매해서 봐도 좋음
	final public static YachtDiceInfo YACHT = new YachtDiceInfo("Yacht!!!!!", 50);
	final public static YachtDiceInfo FULL_HOUSE = new YachtDiceInfo("풀 하우스!!", 40);
	final public static YachtDiceInfo FOUR_OF_A_KIND = new YachtDiceInfo("4 Dice!!", 30);
	final public static YachtDiceInfo LARGE_STRAIGHT = new YachtDiceInfo("Large Straight", 35);
	final public static YachtDiceInfo SMALL_STRAIGHT = new YachtDiceInfo("Small Straight", 25);
	final public static YachtDiceInfo NOTHING = new YachtDiceInfo("Nothing...", 0);
	
	private String name;
	private int value;
	
	private YachtDiceInfo(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d)", name, value);
	}
}
