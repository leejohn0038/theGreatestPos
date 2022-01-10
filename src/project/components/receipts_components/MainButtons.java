package project.components.receipts_components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import project.MainFrame;
import project.actions.MainButtonAL;

public class MainButtons extends JButton {
	

	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();

	static {
		
		BUTTON_MAP.put("상품", new Point(100, 100));
		BUTTON_MAP.put("영수증", new Point(100, 200));
		BUTTON_MAP.put("직원", new Point(100, 300));
		BUTTON_MAP.put("회원", new Point(100, 400));
		BUTTON_MAP.put("업무가이드", new Point(100, 500));

	}
	
	public MainButtons(MainFrame main, String btn) {
		addActionListener(new MainButtonAL(main, btn));
		setText(btn);
		setFont(Font.getFont("돋움"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn));
	}
}
