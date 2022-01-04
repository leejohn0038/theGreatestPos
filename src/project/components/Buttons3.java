
package project.components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

public class Buttons3 extends JButton {	
	
private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("매출구분", new Point(100, 100));
		BUTTON_MAP.put("구매시기", new Point(230, 100));
		BUTTON_MAP.put("결제수단", new Point(360, 100));
		BUTTON_MAP.put("판매금액", new Point(490, 100));
		BUTTON_MAP.put("상품코드", new Point(620, 100));
		BUTTON_MAP.put("영수증번호", new Point(750, 100));
	}
	
	public Buttons3(String btn) {
		setFont(Font.getFont("돋음"));
		//버튼에 텍스트 2줄 보이게하기 위한 문자열
		setText( "<html>" + btn + "<br></html>");
		setSize(100, 70);
		setLocation(BUTTON_MAP.get(btn));
	}
}

