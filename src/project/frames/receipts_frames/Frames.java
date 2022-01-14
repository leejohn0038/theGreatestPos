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
		FRAMES.put("영수증", r = new Receipts(main));
		FRAMES.put("상품", new GoodsFrame(main));
		FRAMES.put("직원", new Employees(main));
		FRAMES.put("포인트 적립", new PointCollect(main));
		FRAMES.put("현금 영수증", new CashReceipt());
		FRAMES.put("반품업무", new Refunding(main));
		FRAMES.put("영수증 조회하기", new ReceiptSearch(main));
	}
	
	public JFrame getFrame(String btn) {
		return FRAMES.get(btn);
	}

}
