package project.components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

public class Buttons2 extends JButton{
	
	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("����Ʈ ����", new Point(300, 500));
		BUTTON_MAP.put("���� ������", new Point(450, 500));
		BUTTON_MAP.put("������ �߱�", new Point(600, 500));
	}
	
	public Buttons2(String btn) {
		setText(btn);
		setFont(Font.getFont("����"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn));
	}
}
