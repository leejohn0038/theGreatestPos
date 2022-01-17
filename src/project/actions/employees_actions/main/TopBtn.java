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
	
	static {
		BTN_MAP.put(0, "등록");
		BTN_MAP.put(1, "삭제");
	}

	public TopBtn(Table jp, int num, SQLs sql, int[] lw, int lh, int type) {
		
		
		int wight = 100;
		int hight = lh/2;
		int x = lw[1]-(((num+1)*wight)+50);
		int y = hight/2;
		
		this.jp = jp;
		
		addframe = new Adds(jp, sql, type);
		
		setText(BTN_MAP.get(num));
		setBounds(x, y, wight, hight);
		
		btnEvent(num);	
	}
	
	
	public void btnEvent(int num) {
		
		switch (num) {
		case 0:
			addActionListener(new FrameVisible(addframe));
			break;
		case 1:
			addActionListener(new Delete(jp.getTsd()));
			break;
		default:
			break;
		}
	}
}

//class Right
