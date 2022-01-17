package project.actions.employees_actions.main;

import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import project.actions.employees_actions.Delete;
import project.actions.employees_actions.FrameVisible;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;
import project.frames.employees_frames.Adds;


//여긴 직원프레임의 상단 버튼입니다.

public class TopBtn extends JButton{
	
	final private static HashMap<Integer, String> BTN_MAP = new HashMap<>();
	
	Table jp;
	JFrame addframe;
	int type;
	
	static {
		BTN_MAP.put(0, "삭제");
		BTN_MAP.put(1, "등록");
	}

	public TopBtn(Table jp, int num, SQLs sql, int[] lw, int lh, int type) {
		
		int wight = 100;
		int hight = lh/2;
		int x = lw[1]-(((num+1)*wight)+50);
		int y = hight/2;
		
		this.jp = jp;
		this.type = type;
		
		addframe = new Adds(jp, sql, type);
		
		setText(BTN_MAP.get(num));
		setBounds(x, y, wight, hight);
		
		btnEvent(num);	
	}
	
	
	public void btnEvent(int num) {
		
		switch (num) {
		case 0:
			addActionListener(new Delete(jp.getTsd(),type));
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
