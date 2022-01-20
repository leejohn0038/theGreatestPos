package project.actions.employees_actions.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project.actions.employees_actions.Delete;
import project.actions.employees_actions.FrameVisible;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;
import project.frames.employees_frames.Adds;


//여긴 직원프레임의 상단 버튼입니다.

public class NavBtn extends JButton{
	
	final private static HashMap<Integer, String> BTN_MAP = new HashMap<>();
	
	Table jt;
	JFrame addframe;
	int type;
	
	static {
		BTN_MAP.put(0, "삭제");
		BTN_MAP.put(1, "등록");
	}

	public NavBtn(JFrame f, Table jt, int num, SQLs sql, int[] size, int type, ArrayList<JFrame> fs) {
		
		int padding = 20;
		
		int wight = 100;
		int hight = 30;
		
		this.jt = jt;
		this.type = type;
		
		addframe = new Adds(f, jt, sql, type, size, fs);
		
		setText(BTN_MAP.get(num));
		setBounds(size[0]-(((wight+10)*(num+1))+10), size[1] - (hight+30), wight, hight);
		
		btnEvent(num, size);	
	}
	
	
	public void btnEvent(int num, int[] size) {
		
		switch (num) {
		case 0:
			addActionListener(new Delete(jt.getTsd(),type));
			break;
		case 1:
			addActionListener(new FrameVisible(addframe));
			break;
		default:
			break;
		}
	}
}

//class Right
