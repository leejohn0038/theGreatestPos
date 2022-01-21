package project.components.receipts_components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.ReceiptsButtonsAL;
import project.components.goods_components.BasicSmallButton;

public class ReceiptButtons extends BasicSmallButton {
	
	private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("포인트 적립", new Point(0, 170));
		BUTTON_MAP.put("현금 영수증", new Point(0, 230));
		BUTTON_MAP.put("영수증 발급", new Point(0, 290));
		BUTTON_MAP.put("반품업무", new Point(0, 350));
	}
	
	public ReceiptButtons(MainFrame main, ImageIcon img, String btn) {
		super(img);
		addActionListener(new ReceiptsButtonsAL(main, btn));
		setSize(150, 40);
		setLocation(BUTTON_MAP.get(btn));
	}
}
