package project.actions.customers_actions.main;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project.actions.customers_actions.CustomersDelectValue;
import project.actions.customers_actions.CustomersFrameVisible;
import project.frames.customers_frames.AddCustomers;
import project.frames.customers_frames.CustomersGuideManual;

//���� ������������ ��� ��ư�Դϴ�.

public class CustomersTopInnerTopBtn extends JButton{
	final private static HashMap<Integer, String> BTN_MAP = new HashMap<>();
	
	JFrame addCtm = new AddCustomers();
	
	static {
		BTN_MAP.put(0, "���");
		BTN_MAP.put(1, "����");
	}

	public CustomersTopInnerTopBtn(int num, int lh) {
		
		int btnX = 0;
		int btnY;
		
		setText(BTN_MAP.get(num));
		setPreferredSize(new Dimension(100,30));
		btnY = (lh-getPreferredSize().height)/2;
		//x ��ǥ�� 
		setLocation((btnX+num)*150,btnY);
		
		btnEvent(num);	
	}
	
	
	public void btnEvent(int num) {
		
		switch (num) {
		case 0:
			addActionListener(new CustomersFrameVisible(addCtm));
			break;
		case 1:
			addActionListener(new CustomersDelectValue());
			break;
		default:
			break;
		}
	}
}

//class Right
