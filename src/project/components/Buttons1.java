package project.components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

public class Buttons1 extends JButton {
	
private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("�Ǹ�", new Point(100, 100));
		BUTTON_MAP.put("������", new Point(100, 200));
		BUTTON_MAP.put("����", new Point(100, 300));
		BUTTON_MAP.put("ȸ��", new Point(100, 400));
		BUTTON_MAP.put("�������̵�", new Point(100, 500));
	}
	
	public Buttons1(String btn) {
		setText(btn);
		setFont(Font.getFont("����"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn));
	}
}
