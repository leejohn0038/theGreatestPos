package project.components.employees_companents;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.main.TopBtn;
import project.database.employee_customer.SQLs;

//프레임의 상단 레이아웃 (logo / 조회 / 등록 / 편집 버튼)
public class NavBar extends JPanel{
	
	Table jt;
	SQLs sql;
	int[] loc;
	int[] size;
	int padding;
	
	public NavBar(int[] viewData, Table jt, SQLs sql, int type) {
		
		this.jt = jt;
		this.sql = sql;
		
		size = new int[] {250,50};
		loc = new int[] {viewData[2]-size[0], viewData[3]-size[1]};
		padding = 10;
		
		setLayout(null);
		setBounds(loc[0]-padding, loc[1]-padding, size[0], size[1]);
		setVisible(true);
		
		for(int i = 0; i<2; i++) {
			TopBtn tb = new TopBtn(jt, i, sql, size, type);
			add(tb);
		}		
	}
	
	int getLocX() {
		return loc[0]-padding;
	}
	
	int getLocY() {
		return ((loc[1]-padding) - size[1]) - padding;
	}
}
