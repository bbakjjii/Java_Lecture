package gui.quiz.gallery;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class S14_ImageGallery_Me {

	public static void open1() {
		JFrame f = new JFrame();
		JButton appleBtn = new JButton();

		try {
			BufferedImage bufferedImage = 
					ImageIO.read(new File("images/apple.jpg"));
			Image scaledImage = 
					bufferedImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT); // 이미지 크기 조절
			appleBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		f.add(appleBtn);
		f.setLocation(300, 100);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void open2() {
		JFrame f = new JFrame();
		JButton appleBtn = new JButton();

		try {
			BufferedImage bufferedImage = 
					ImageIO.read(new File("images/kiwi.jpg"));
			Image scaledImage = 
					bufferedImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT); // 이미지 크기 조절
			appleBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		f.add(appleBtn);
		f.setLocation(300, 100);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void open3() {
		JFrame f = new JFrame();
		JButton appleBtn = new JButton();

		try {
			BufferedImage bufferedImage = 
					ImageIO.read(new File("images/strawberry.jpg"));
			Image scaledImage = 
					bufferedImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT); // 이미지 크기 조절
			appleBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		f.add(appleBtn);
		f.setLocation(300, 100);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public static void main(String[] args) {
		JFrame f = new JFrame();

		GridLayout layout = new GridLayout(3, 0, 5, 0);

		f.setLayout(layout);

		JButton btn1 = new JButton();
		JButton btn2 = new JButton();
		JButton btn3 = new JButton();


		try {
			BufferedImage bufferedImage = 
					ImageIO.read(new File("images/apple.jpg"));
			Image scaledImage = 
					bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			btn1.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e2) {
			e2.printStackTrace();
		}


		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				S14_ImageGallery_Me.open1();
			}
		});

		try {
			BufferedImage bufferedImage = 
					ImageIO.read(new File("images/kiwi.jpg"));
			Image scaledImage = 
					bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT); // 이미지 크기 조절
			btn2.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e2) {
			e2.printStackTrace();
		}


		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				S14_ImageGallery_Me.open2();
			}
		});


		try {
			BufferedImage bufferedImage = 
					ImageIO.read(new File("images/strawberry.jpg"));
			Image scaledImage = 
					bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT); // 이미지 크기 조절
			btn3.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e2) {
			e2.printStackTrace();
		}


		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				S14_ImageGallery_Me.open3();
			}
		});

		f.add(btn1);
		f.add(btn2);
		f.add(btn3);

		f.setLocation(100, 100);
		f.setSize(200, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}