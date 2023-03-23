package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class S06_JTextArea {

	// 여러 줄의 텍스트를 보여주기 위한 컴포넌트


	public static void main(String[] args) {
		JFrame f = new JFrame();

		JTextArea ta = new JTextArea(10, 30); // 열 : 10, 행 : 30
		JTextField tf = new JTextField(50); // 50 사이즈
		
		ta.setBounds(50, 50, 200, 200);
		tf.setBounds(50, 260, 200, 30);
		// 자동 줄바꿈 설정
		ta.setLineWrap(true);
		
		// 수정 가능 여부 설정
		ta.setEditable(false); // 수정 불가
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// append : 기존의 텍스트를 없애지 않고 계속 추가하는 메서드
				ta.append("You > " + tf.getText() + "\n");
				tf.setText(null);
			}
		});
		
		f.add(ta);
		f.add(tf);

		f.setLocation(100, 100);
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

