
package project.components.receipts_components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

public class SearchBoxButtons extends JButton {	
	
private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("������ ��ȸ�ϱ�", new Point(100, 150));
	}
	
	public SearchBoxButtons(String btn) {
		setFont(Font.getFont("����"));
		//��ư�� �ؽ�Ʈ 2�� ���̰��ϱ� ���� ���ڿ�
		setText( "<html>" + btn + "<br></html>");
		setSize(150, 50);
		setLocation(BUTTON_MAP.get(btn));
	}
}

