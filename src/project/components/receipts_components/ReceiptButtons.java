package project.components.receipts_components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.ReceiptsButtonsAL;
import project.frames.receipts_frames.Receipts;

public class ReceiptButtons extends JButton{
	
	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("포인트 적립", new Point(300, 500));
		BUTTON_MAP.put("현금 영수증", new Point(450, 500));
		BUTTON_MAP.put("영수증 발급", new Point(600, 500));
		BUTTON_MAP.put("반품업무", new Point(750, 500));
	}
	
	public ReceiptButtons(MainFrame main, String btn, int minusX) {
		addActionListener(new ReceiptsButtonsAL(main, btn));
		setText(btn);
		setFont(Font.getFont("돋움"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn).x - minusX, BUTTON_MAP.get(btn).y);
	}
}
