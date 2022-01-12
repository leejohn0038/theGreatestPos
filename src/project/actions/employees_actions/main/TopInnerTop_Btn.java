package project.actions.employees_actions.main;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import project.actions.employees_actions.Delete;
import project.actions.employees_actions.FrameVisible;
import project.actions.employees_actions.SQLs;
import project.components.employees_companents.Table_emp;
import project.frames.employees_frames.AddEmployees;


//���� ������������ ��� ��ư�Դϴ�.

public class TopInnerTop_Btn extends JButton{
	final private static HashMap<Integer, String> BTN_MAP = new HashMap<>();
	
	Table_emp jp;
	JFrame addEmp;
	
	static {
		BTN_MAP.put(0, "���");
		BTN_MAP.put(1, "����");
	}

	public TopInnerTop_Btn(Table_emp jp, int num, int lh, SQLs sql) {
		
		this.jp = jp;
		
		addEmp = new AddEmployees(jp, sql);
		
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
			addActionListener(new FrameVisible(addEmp));
			break;
		case 1:
			addActionListener(new Delete(0));
			break;
		default:
			break;
		}
	}
}

//class Right
