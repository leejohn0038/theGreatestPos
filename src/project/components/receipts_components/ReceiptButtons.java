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
		BUTTON_MAP.put("����Ʈ ����", new Point(300, 500));
		BUTTON_MAP.put("���� ������", new Point(450, 500));
		BUTTON_MAP.put("������ �߱�", new Point(600, 500));
		BUTTON_MAP.put("��ǰ����", new Point(750, 500));
	}
	
	public ReceiptButtons(MainFrame main, String btn, int minusX) {
		addActionListener(new ReceiptsButtonsAL(main, btn));
		setText(btn);
		setFont(Font.getFont("����"));
		setSize(100, 50);
		setLocation(BUTTON_MAP.get(btn).x - minusX, BUTTON_MAP.get(btn).y);
	}
}
