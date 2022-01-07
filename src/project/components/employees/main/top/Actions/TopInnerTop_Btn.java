package project.components.employees.main.top.Actions;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project.components.employees.frame.Guide_manual;
import project.employees.components.Actions.DelectValue;
import project.employees.components.Actions.FrameVisible;
import project.components.employees.frame.AddEmployees;

//여긴 직원프레임의 상단 버튼입니다.

public class TopInnerTop_Btn extends JButton{
	final private static HashMap<Integer, String> BTN_MAP = new HashMap<>();
	
	JFrame addEmp = new AddEmployees();
	
	static {
		BTN_MAP.put(0, "등록");
		BTN_MAP.put(1, "삭제");
	}

	public TopInnerTop_Btn(int num, int lh) {
		
		int btnX = 0;
		int btnY;
		
		setText(BTN_MAP.get(num));
		setPreferredSize(new Dimension(100,30));
		btnY = (lh-getPreferredSize().height)/2;
		//x 좌표는 
		setLocation((btnX+num)*150,btnY);
		
		btnEvent(num);	
	}
	
	
	public void btnEvent(int num) {
		
		switch (num) {
		case 0:
			addActionListener(new FrameVisible(addEmp));
			break;
		case 1:
			addActionListener(new DelectValue());
			break;
		default:
			break;
		}
	}
}

//class Right
