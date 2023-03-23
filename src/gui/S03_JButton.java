package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;


// 한번에 여러 객체를 생성할 수 있는 프레임이 된다(?)
public class S03_JButton extends JFrame{ // 이 클래스 자체가 프레임이 된다.
	
	// 인스턴스로 버튼 만들기
	JButton mainBtn = new JButton("Main"); 
	JButton subBtn = new JButton("Sub Button");
	
	public S03_JButton() { // 나 자신에게 들어있는 것처럼 사용할 수 있다.
		super("JButton 테스트"); // JFrame의 생성자를 부르는 것
		
		add(mainBtn, "Center");
		add(subBtn, "South");
		
		// 버튼 텍스트 설정
		mainBtn.setText("안녕하세요!");
		
		HashMap<TextAttribute, Object> attributeMap = new HashMap<>(); // Attribute 타입의 Integer
		attributeMap.put(TextAttribute.FONT, "굴림체");
		attributeMap.put(TextAttribute.SIZE, 30);
		attributeMap.put(TextAttribute.STRIKETHROUGH, true);
		attributeMap.put(TextAttribute.TRANSFORM, 20);
		subBtn.setFont(new Font(attributeMap));
		
		// 어떤 것들이 있는지 보기 위해서 적은 것
//		Attribute[] attrs = new Font(null, 0, 0).getAvailableAttributes(); // 자세히 쓰기
//		System.out.println(Arrays.toString(attrs));
		
		/* 
		# Attribute : 속성
		- family attribute : 글꼴
		- weight attribute : 글씨 무게 (굵기)
		- width attribute : 너비
		- posture attribute : ?
		- size : 크기
		- transform : 방향 회전
		- superscript : 위첨자 및 아래첨자
		- char_replacement : ?
		- foreground : 글씨색
		- background : 배경색
		- underline : 밑줄
		- strikethrough : 취소선
		- run_direction : ?
		- bidi_embedding : ?
		- justification : 정렬
		- input method highlight : ?
		- input method underline : ?
		- swap_colors : ?
		- numberic_shaping : ?
		- kerning : ?
		- ligatures : ?
		- tracking : ?			
	 */
		
		// 글꼴 설정
		mainBtn.setFont(new Font("궁서체", Font.BOLD, 55)); // 글씨체, 글씨타입, 글씨크기 - 가볍게 쓰기
		mainBtn.setFont(new Font("굴림체", Font.PLAIN, 30)); // PLAIN : 아무것도 설정하지 않은?
		
		// 버튼의 글씨 색 변경
		subBtn.setForeground(Color.RED);
		
		// 버튼의 배경 색 변경
		subBtn.setBackground(new Color(31, 236, 255));
		
		// 버튼의 이벤트 설정 (버튼에 액션 리스너 추가)
		subBtn.addActionListener(new ActionListener() {
			int num = 1; // 인스턴스 변수
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼이 눌렸을 때의 동작을 설정할 수 있음
				System.out.println("Hello, Button Event!!");
				mainBtn.setText("<html>" + num++ + "번째 <br> 눌림</html>");	
			}
		});
		
		setVisible(true); // super.setVisible에서 super는 생략 가능함
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new S03_JButton();
	}

}
