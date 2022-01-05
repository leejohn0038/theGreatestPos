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

import project.actions.ButtonActionListener;


public class Buttons1 extends JButton {
	
	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	JFrame emp = new Employees();

	static {
		
		BUTTON_MAP.put("상품", new Point(100, 100));
		BUTTON_MAP.put("영수증", new Point(100, 200));
		BUTTON_MAP.put("직원", new Point(100, 300));
		BUTTON_MAP.put("회원", new Point(100, 400));
		BUTTON_MAP.put("업무가이드", new Point(100, 500));

	}
	
	public Buttons1(JFrame main, String btn) {
		addActionListener(new ButtonActionListener(main, btn));
		setText(btn);
		setFont(Font.getFont("돋음"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn));
		
		switch (btn) {

		case "직원":

			addActionListener(new FrameVisible(emp));
			break;
		default:
			break;
		}
	}
}
