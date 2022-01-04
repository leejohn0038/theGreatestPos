package project.components;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import project.components.employees.Employees;
import project.components.employees.Actions.FrameVisible;

public class Buttons1 extends JButton {
	
	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	JFrame emp = new Employees();
	
	static {
<<<<<<< HEAD
		BUTTON_MAP.put("ÌåêÎß§", new Point(100, 100));
		BUTTON_MAP.put("ÏòÅÏàòÏ¶ù", new Point(100, 200));
		BUTTON_MAP.put("ÏßÅÏõê", new Point(100, 300));
		BUTTON_MAP.put("ÌöåÏõê", new Point(100, 400));
		BUTTON_MAP.put("ÏóÖÎ¨¥Í∞ÄÏù¥Îìú", new Point(100, 500));
=======
		BUTTON_MAP.put("ªÛ«∞", new Point(100, 100));
		BUTTON_MAP.put("øµºˆ¡ı", new Point(100, 200));
		BUTTON_MAP.put("¡˜ø¯", new Point(100, 300));
		BUTTON_MAP.put("»∏ø¯", new Point(100, 400));
		BUTTON_MAP.put("æ˜π´∞°¿ÃµÂ", new Point(100, 500));
>>>>>>> refs/heads/jang
	}
	
	public Buttons1(String btn) {
		setText(btn);
		setFont(Font.getFont("ÔøΩÔøΩÔøΩÔøΩ"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn));
		
		switch (btn) {

		case "ÏßÅÏõê":

			addActionListener(new FrameVisible(emp));
			break;
		default:
			//System.out.println("");
			break;
		}
	}
}
