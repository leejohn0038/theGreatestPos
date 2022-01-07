package project.frames;

import java.util.HashMap;

import javax.swing.JFrame;

import project.MainFrame;
import project.frames.receipts_frames.CashReceipt;
import project.frames.receipts_frames.PointCollect;
import project.frames.receipts_frames.Receipts;
import project.frames.receipts_frames.Refunding;

public class Frames {
	
	public HashMap<String, JFrame> FRAMES = new HashMap<String, JFrame>();
	
	public Frames(MainFrame main) {
		FRAMES.put("������", new Receipts(main));
		FRAMES.put("����Ʈ ����", new PointCollect());
		FRAMES.put("���� ������", new CashReceipt());
		FRAMES.put("��ǰ����", new Refunding());
	}

}
