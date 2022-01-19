package project.actions.employees_actions.main;

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

public class TopBtn extends JButton{
	
	final private static HashMap<Integer, String> BTN_MAP = new HashMap<>();
	
	Table jt;
	JFrame addframe;
	int type;
	
	static {
		BTN_MAP.put(0, "등록");
		BTN_MAP.put(1, "삭제");
	}

	public TopBtn(Table jt, int num, SQLs sql, int[] size, int type) {
		
		int padding = 20;
		
		int wight = (size[0]/2) - padding;
		int hight = size[1] - (padding/2);
		
		this.jt = jt;
		this.type = type;
		
		addframe = new Adds(jt, sql, type);
		
		setText(BTN_MAP.get(num));
		setBounds((wight+10)*num, 0, wight, hight);
		
		btnEvent(num);	
	}
	
	
	public void btnEvent(int num) {
		
		switch (num) {
		case 0:
			addActionListener(new FrameVisible(addframe));
			break;
		case 1:
			addActionListener(new Delete(jt.getTsd(),type));
			break;
		default:
			break;
		}
	}
}

//class Right
