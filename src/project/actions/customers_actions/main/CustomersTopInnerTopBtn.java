package project.actions.customers_actions.main;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import project.actions.customers_actions.CustomersSQLs;
import project.actions.customers_actions.CustomersDelete;
import project.actions.customers_actions.CustomersFrameVisible;
import project.components.customers_components.Table_ctm;
import project.frames.customers_frames.AddCustomers;

//���� ������������ ��� ��ư�Դϴ�.
public class CustomersTopInnerTopBtn extends JButton{
	final private static HashMap<Integer, String> BTN_MAP = new HashMap<>();
	
	Table_ctm jp;
	JFrame addCtm;
	
	static {
		BTN_MAP.put(0, "���");
		BTN_MAP.put(1, "����");
	}

	public CustomersTopInnerTopBtn(Table_ctm jp, int num, int lh, CustomersSQLs sql) {
		
		this.jp = jp;
		
		addCtm = new AddCustomers(jp, sql);
		
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
			addActionListener(new CustomersDelete(jp.getTsd()));
			break;
		default:
			break;
		}
	}
}

//class Right
