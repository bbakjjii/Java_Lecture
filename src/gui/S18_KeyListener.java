package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class S18_KeyListener {

	// 키보드 이벤트 처리
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Keyboard Event!!");
		
		JTextArea textarea = new JTextArea();
		
		textarea.setRows(10);
		
		// KeyListener 대신 KeyAdapter를 이용할 수 있다
		// 엄청 어려운 게임을 만들 때..
		textarea.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// System.out.println("입력한 내용이 화면에 나올 때");
//				// ※ 방향키 같은 것에 반응이 없음
//			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// 어떤 키가 눌렸는지 파악하여 로직을 구성할 수 있다
				System.out.printf("방금 누른 키 (문자) : %c\n", e.getKeyChar()); // 방금 눌린 키를 문자로 가져온다
				System.out.printf("방금 누른 키 (코드) : %d\n", e.getKeyCode()); // 방금 눌린 키를 코드로 가져온다
				// System.out.println("손을 뗌");
				// ※ 방향키 같은 것에 반응이 있음
			}
			
//		@Override
//		public void keyPressed(KeyEvent e) {
//			System.out.println("pressed!");
//			}
		});
		
		f.add(textarea, "South");
		
		f.setLocation(100, 100);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}