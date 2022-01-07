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
		CustomerButtonMap.put("이름 : ", new Point(300, 150));
		CustomerButtonMap.put("휴대폰 번호 : ", new Point(300, 200));
		CustomerButtonMap.put("주소 : ", new Point(300, 250));
		CustomerButtonMap.put("가입일자 : ", new Point(300, 300));
		CustomerButtonMap.put("멤버십 포인트 : ", new Point(300, 350));
		
	}
	//위에 키값을 빼서 
	public CustomerInputButtonUi(String st) {
		//addActionListener(new GuessButtonAction(mainframe));
		setText(st);
		setFont(Font.getFont("돋음"));
		setSize(80, 50);
		setLocation(CustomerButtonMap.get(st));
		
	}
}