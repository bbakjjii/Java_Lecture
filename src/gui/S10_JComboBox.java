package gui;

import java.awt.event.ItemEvent;

import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import database.model.J05_Fruit;
import myobj2.Fruit;

public class S10_JComboBox extends JFrame {

	JComboBox cb;
	
	// 다른 곳에서 호출해서 관리할 수 있게 한다
	public S10_JComboBox() {
		
		// database > model > fruit
		// Obeject의 toString을 알아서 ComboBox에 가져다 쓴다
		// (J05_Fruit의 하단의 @override toStirng name, sweet만 설정함)
		J05_Fruit[] fruits = {
				new J05_Fruit("Apple", 3.3, 5000, "KR", "A+"),
				new J05_Fruit("Mango", 3.5, 5000, "EN", "B+"),
				new J05_Fruit("Kiwi", 5.3, 5000, "BR", "D"),
				new J05_Fruit("Grape", 7.7, 5000, "CO", "F"),
				new J05_Fruit("Podo", 19.9, 5000, "JP", "B-")
		};
		// String[] fruits = {"apple", "mango", "kiwi", "orange"};
		
		cb = new JComboBox(fruits);
		
		// Object 타입이기 때문에 문자열 외에도 다른 타입이 들어갈 수도 있다
		// cb.addItem(123.123); 
		
		this.add(cb);
		cb.setBounds(50, 100, 150, 25);
		
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() ==  ItemEvent.SELECTED) {
					System.out.println(e.getItem());
				}
			}
		});
		
		setTitle("JComboBox Test Frame");
		setLayout(null);
		setLocation(100, 100);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 다른 곳에서 호출해서 관리할 수 있게 한다
	public void open() {
		setVisible(true);
	}

	public static void main(String[] args) {
		S10_JComboBox f = new S10_JComboBox(); // 다른 곳에서 호출
		f.open(); // 다른 곳에서 호출
	} 

}
