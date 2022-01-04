
package project.components;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

public class Buttons3 extends JButton {	
	
private final static HashMap<String, Point> BUTTON_MAP = new HashMap<String, Point>();
	
	static {
		BUTTON_MAP.put("���ⱸ��", new Point(100, 100));
		BUTTON_MAP.put("���Žñ�", new Point(230, 100));
		BUTTON_MAP.put("��������", new Point(360, 100));
		BUTTON_MAP.put("�Ǹűݾ�", new Point(490, 100));
		BUTTON_MAP.put("��ǰ�ڵ�", new Point(620, 100));
		BUTTON_MAP.put("��������ȣ", new Point(750, 100));
	}
	
	public Buttons3(String btn) {
		setFont(Font.getFont("����"));
		//��ư�� �ؽ�Ʈ 2�� ���̰��ϱ� ���� ���ڿ�
		setText( "<html>" + btn + "<br></html>");
		setSize(100, 70);
		setLocation(BUTTON_MAP.get(btn));
	}
}

