package gui.quiz.gallery;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ThumbnailButton extends JButton implements ActionListener { // JButton을 상속받음

	
	private static ViewImageFrame viewFrame;  // static으로 만들어 하나만 만들어서 전달(?)
	
	public static void setViewFrame(ViewImageFrame f) { // 동일한 view이미지 프레임에서 가져고 온다?
		viewFrame = f;
	}
	
	File f;

	final private static int THUMBNAIL_WIDTH = 100;
	final private static int THUMBNAIL_HEIGHT = 80;


	// 문자열을 받으면 파일을 이쪽으로 보내주겠다
	public ThumbnailButton(String path) {
		this(new File(path));
	}

	public ThumbnailButton(File f) { // 아이콘과 버튼 싸이즈는 정해놓은 변수로 만듦
		this.f = f;

		try {
			setIcon(new ImageIcon(ImageIO.read(f).getScaledInstance(
					THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, Image.SCALE_AREA_AVERAGING)));	
			setSize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
			addActionListener(this); // ActionListener를 인스턴스로 가지고 옴
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	// 버튼이 눌릴때마다 제어한다
	// view프레임의 이미지라벨을 바꾸고, view프레임을 보이게 한다
	@Override
	public void actionPerformed(ActionEvent e) {
		viewFrame.setImageLabel(f); // newViewImageFrame이 들어있다
		viewFrame.setVisible(true);
	}
}
