package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_BorderLayout {
	
/*
	# 레이아웃
	- 컨테이너에는 레이아웃을 설정할 수 있다
	- 레이아웃은 컴포넌트를 배치하는 방식을 결정한다
	
	# BorderLayout
	- 동서남북과 가운데로 이루어진 레이아웃
	- JFrame의 기본값
*/
	
	public static void main(String[] args) {
		
		JFrame f1 = new JFrame("Border Layout 입니다");
		
		BorderLayout layout = new BorderLayout(); //layout도 객체다
		
		layout.setVgap(15); // 세로의 여백
		layout.setHgap(10); // 가로의 여백
		
		f1.setLayout(layout); // 레이아웃 만들기
		
		// BorderLayout에 컴포넌트 배치하기
		f1.add(new JButton("Button1"), BorderLayout.WEST);
		f1.add(new JButton("Button2"), BorderLayout.EAST);
		f1.add(new JButton("Button3"), BorderLayout.SOUTH);
		f1.add(new JButton("Button4"), BorderLayout.NORTH);
		f1.add(new JButton("Button5"), BorderLayout.CENTER);
		
		// setBounds() : 위치와 프레임의 크기를 한번에 설정(가로위치, 세로위치, 가로(x)크기, 세로(y)크기)
		f1.setBounds(300, 100, 400, 500);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true); //창을 보여준다. 입력 안 하면 창을 보여주지 않는다.
	}

}
