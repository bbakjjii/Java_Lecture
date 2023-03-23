package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


// 창 크기에 맞춰서 자동으로 버튼 크기가 조절되는 기능

public class S13_FlowLayout {

	public static void main(String[] args) {
		JFrame f = new JFrame("Flow");

		JPanel centerPanel = 
				new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // 가운데정렬로 자동으로 쌓인다
		int i = 0;
		while (i < 20) {
			centerPanel.add(new JButton("" + i++));
		}

		f.add(centerPanel, "Center");

		f.add(new JButton("Click!") {
			int i = 20;
			{
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 누를 때마다 버튼이 계속 추가 됨
						System.out.println("Click");
						centerPanel.add(new JButton("" + i++));
						// 해당 프로그램을 다시 그려주는 역할 (클릭을 누를 때마다 버튼이 새로 계속 추가됨)
						centerPanel.validate(); // 컴포넌트의 변화를 업데이트 하는 역할
					}
				});
			}
		}, "South");

		f.setLocation(100, 100);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}