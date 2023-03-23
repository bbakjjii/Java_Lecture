package gui.quiz.gugudan.component;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class GugudanButton extends JButton{ //구구단버튼 보다는 구구단라벨로 보는게 맞음
	
	private int dan = 2;
	private int gop; // 자기가 몇 번째 버튼인지
	
	public GugudanButton(int i) {
		gop = i;
		setFont(new Font(null, Font.PLAIN, 30));
		setText(String.format("%d x %d = %d", dan, i, i * dan));
		setBounds(0, (i - 1) * 55, 500, 55);
		setBackground(Color.WHITE);
	}

	public void plusDan() {
		if (dan == 19) {
			dan = 1;
		}
		setText(String.format("%d x %d = %d", ++dan, gop, gop * dan));
	}
	
	public void MinusDan() {
		if (dan == 2) {
			dan = 19;
		}
		setText(String.format("%d x %d = %d", --dan, gop, gop * dan));
	}
}
