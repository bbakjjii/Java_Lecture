package gui.quiz.gallery;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S14_ImageGallery extends JFrame { //JFrame 상속받음
	
	/*
	(1) images 폴더에 모든 이미지들을 GridLayout으로 보여주기

	(2) 해당 이미지를 클릭하면 확대된 이미지가 새 창에 나오게 만들기
	 */
	
	public S14_ImageGallery(String path) {
		File dir = new File(path);
		
		// 모든 ThumbnailButton에서 사용할 ViewImageFrame을 하나 생성하여 전달
		ThumbnailButton.setViewFrame(new ViewImageFrame());	// 새로운 프레임을 하나 만들어서 썸네일버튼에 넣어둠
		int imageCount = 0; 
		for (File f : dir.listFiles()) { // dir의 목록을 보면서 하나씩 꺼내서 버튼을 만든다
			if (f.isFile()) { // 파일만 가지고 만든다
			add(new ThumbnailButton(f));
			++imageCount;
			}
		}
		
		while (imageCount++ < 16) { // 버튼 16개 : GridLayout이 4x4이기 때문에
			add(new JButton("empty"));	
		}
		
		setLayout(new GridLayout(4, 4));
		setTitle("Thumbnails");
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		// 이 디렉토리에 있는 이미지를 보여주세요(디렉토리 경로 전달)
		new S14_ImageGallery("images/"); 
	}
	
}