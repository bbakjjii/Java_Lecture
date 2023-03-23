package gui.quiz.gugudan.component;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import gui.quiz.gugudan.event.PlusDanEvent;

public class PlusButton extends JButton{
	// 버튼 자체에 대한 설정(View) -버튼 자체에 대한 설정과 액션에 대한 분리도 필요한다
	// event package : plus 단 이벤트
	public PlusButton(List<GugudanButton> gugudanBtns) {
		setText("+");
		setBounds(250, 500, 250, 50);
		setFont(new Font(null, Font.PLAIN, 35));
		setFocusable(false);
		
		// 버튼이 어떤 액션을 해야할지에 대한 설정
		addActionListener(new PlusDanEvent(gugudanBtns));
	}
}
