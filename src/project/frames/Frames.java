package project.frames;

import java.util.HashMap;

import javax.swing.JFrame;

import project.MainFrame;
import project.frames.employees_frames.Employees;
import project.frames.goods_frames.GoodsFrame;
import project.frames.receipts_frames.CashReceipt;
import project.frames.receipts_frames.PointCollect;
import project.frames.receipts_frames.Receipts;
import project.frames.receipts_frames.Refunding;

public class Frames {
	
	public HashMap<String, JFrame> FRAMES = new HashMap<String, JFrame>();
	
	public Frames(MainFrame main) {
		FRAMES.put("영수증", new Receipts(main));
		FRAMES.put("상품", new GoodsFrame(main));
		FRAMES.put("직원", new Employees(main));
		FRAMES.put("포인트 적립", new PointCollect());
		FRAMES.put("현금 영수증", new CashReceipt());
		FRAMES.put("반품업무", new Refunding());
	}

}
