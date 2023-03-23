package gui.quiz.gallery;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//크기 조절되는 아이콘 메서드
public class ImageIconTools {
	
	public static ImageIcon getScaledImageIcon(File img, int w, int h) 
			throws IOException {
		return new ImageIcon(
				ImageIO.read(img).getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING));
	}
}
