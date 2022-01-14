 package project.frames.receipts_frames;

import java.util.HashMap;

import javax.swing.JFrame;

import project.MainFrame;
import project.frames.employees_frames.Employees;
import project.frames.goods_frames.GoodsFrame;

public class Frames {
	
	private HashMap<String, JFrame> FRAMES = new HashMap<String, JFrame>();
	
	Receipts r;
	
	public Frames(MainFrame main) {
		FRAMES.put("������", r = new Receipts(main));
		FRAMES.put("��ǰ", new GoodsFrame(main));
		FRAMES.put("����", new Employees(main));
		FRAMES.put("����Ʈ ����", new PointCollect(main));
		FRAMES.put("���� ������", new CashReceipt());
		FRAMES.put("��ǰ����", new Refunding(main));
		FRAMES.put("������ ��ȸ�ϱ�", new ReceiptSearch(main));
	}
	
	public JFrame getFrame(String btn) {
		return FRAMES.get(btn);
	}

}
