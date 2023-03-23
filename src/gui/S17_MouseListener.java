package gui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class S17_MouseListener {
	
	// 마우스 이벤트 처리
	
/*
	# MouseListener
	- 인터페이스
	- 모든 추상 메서드를 구현해야 해서 불편하다
	
	# MouseAdapter
	- 추상 클래스
	- 원하는 메서드만 구현하면 된다
*/

	public static void main(String[] args) {
		JFrame f = new JFrame("Mouse Event!!");
		
		f.setLayout(new GridLayout(2, 1));
	
		JButton top = new JButton("위");
		JLabel bottom = new JLabel("아래");
		
		// 버튼이 아니더라도 모든 컴포넌트에 사용할 수 있는 공통 이벤트가 있다
		bottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 이벤트 발생시 e에 이벤트 정보가 실려서 도착함
				// 마우스의 위치
				// System.out.println(e.getClickCount()); // 몇번 눌렀는지 알려줌
				System.out.printf("마우스 좌표 (프로그램에서) : (%d, %d)\n", e.getX(), e.getY());
				System.out.printf("마우스 좌표 (모니터상에서) : (%d, %d)\n", e.getXOnScreen(), e.getYOnScreen());
				
				// 이벤트를 발생시킨 컴포넌트의 인스턴스 (컴포넌트 타입이므로 다운캐스팅이 필요)
				System.out.println(((JLabel)e.getComponent()).getText());
				System.out.println("누른 시간 : " + new Date(e.getWhen())); // 마우스를 클릭한 시간
				System.out.println("아래쪽에서 마우스 클릭됨");
				super.mouseClicked(e);
			}
		});
		
		// 인터페이스의 단점 : 5개를 다 구현해야 함
//		bottom.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		f.add(top);
		f.add(bottom);
		
		f.setLocation(100, 100);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}