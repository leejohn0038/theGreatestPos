package project.components.receipts_components;

import java.awt.Point;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.MainButtonAL;

public class MainButtons extends JButton {
	

	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();

	static {
		
		BUTTON_MAP.put("상품", new Point(10, 170));
		BUTTON_MAP.put("영수증", new Point(10, 230));
		BUTTON_MAP.put("직원", new Point(10, 290));
		BUTTON_MAP.put("회원", new Point(10, 350));
	}
	
	public MainButtons(MainFrame main, String btn) {
		addActionListener(new MainButtonAL(main, btn));
		setText(btn);
		setSize(150, 40);
		setLocation(BUTTON_MAP.get(btn));
	}
	
	public MainButtons(MainFrame main, String btn, ImageIcon img) {
		addActionListener(new MainButtonAL(main, btn));
		setIcon(img);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setSize(150, 40);
		setLocation(BUTTON_MAP.get(btn));
	}
}
