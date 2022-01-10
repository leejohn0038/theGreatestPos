
package project.components.receipts_components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

public class SearchBoxButtons extends JButton {	
	
private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("영수증 조회하기", new Point(100, 150));
	}
	
	public SearchBoxButtons(String btn) {
		setFont(Font.getFont("돋움"));
		//버튼에 텍스트 2줄 보이게하기 위한 문자열
		setText( "<html>" + btn + "<br></html>");
		setSize(150, 50);
		setLocation(BUTTON_MAP.get(btn));
	}
}

