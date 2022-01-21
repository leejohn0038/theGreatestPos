package project.components.receipts_components;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;


public class ReceiptsBtnImg {
	private static final HashMap<String, String> IMG_MAP = new HashMap<>();
	
	static {
		IMG_MAP.put("포인트 적립" , "point_save");
		IMG_MAP.put("현금 영수증", "cashreceipt");
		IMG_MAP.put("영수증 발급", "bill");
		IMG_MAP.put("반품업무", "refund");
		IMG_MAP.put("검색", "search");
		IMG_MAP.put("승인", "submit");
		IMG_MAP.put("카드", "card");
	}
	
	public static ImageIcon search(int x, int y) {
		ImageIcon img = new ImageIcon("./image/receipts/icons/search.png");
		img = new ImageIcon(img.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
		return img;
	} 
	
	
	public static ImageIcon rcpIcon(String btn, int x, int y) {
		ImageIcon img = new ImageIcon(String.format("./image/receipts/icons/%s.png", btn));
		img = new ImageIcon(img.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
		return img;		
	}

	public static ImageIcon getIcon(String btn, int x, int y) {
		return rcpIcon(IMG_MAP.get(btn), x, y);
	}
}
