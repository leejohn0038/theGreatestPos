package project.components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

public class Buttons2 extends JButton{
	
	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("포인트 적립", new Point(300, 500));
		BUTTON_MAP.put("현금 영수증", new Point(450, 500));
		BUTTON_MAP.put("영수증 발급", new Point(600, 500));
	}
	
	public Buttons2(String btn) {
		setText(btn);
		setFont(Font.getFont("돋음"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn));
	}
}
