package project.customer.customerUi;

import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;

import project.components.MainButtons;

public class CustomerInputButtonUi extends JButton {
	
	public final static HashMap<String, Point> CustomerButtonMap 
		= new HashMap<String, Point>();
		
	
	static {
		CustomerButtonMap.put("ID : ", new Point(300, 100));
		CustomerButtonMap.put("�̸� : ", new Point(300, 150));
		CustomerButtonMap.put("�޴��� ��ȣ : ", new Point(300, 200));
		CustomerButtonMap.put("�ּ� : ", new Point(300, 250));
		CustomerButtonMap.put("�������� : ", new Point(300, 300));
		CustomerButtonMap.put("����� ����Ʈ : ", new Point(300, 350));
		
	}
	//���� Ű���� ���� 
	public CustomerInputButtonUi(String st) {
		//addActionListener(new GuessButtonAction(mainframe));
		setText(st);
		setFont(Font.getFont("����"));
		setSize(80, 50);
		setLocation(CustomerButtonMap.get(st));
		
	}
}