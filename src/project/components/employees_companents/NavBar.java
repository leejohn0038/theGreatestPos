package project.components.employees_companents;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.main.NavBtn;
import project.database.employee_customer.SQLs;

//프레임의 상단 레이아웃 (logo / 조회 / 등록 / 편집 버튼)
public class NavBar extends JPanel{
	
	Table jt;
	SQLs sql;
	
	int[] loc;
	int[] size;
	int padding;
	
	public NavBar(JFrame f, int[] viewData, Table_layout tl, Table jt, SQLs sql, int type, ArrayList<JFrame> fs) {
		
		this.jt = jt;
		this.sql = sql;
		
		int deletValueY = tl.getSize().height + tl.getLocation().y + 10;
		
		size = new int[] {tl.getSize().width,f.getSize().height - deletValueY + 10};
		loc = new int[] {tl.getLocation().x+10, deletValueY};
		
		padding = 10;
		
		setLayout(null);
		setBorder(new LineBorder(Color.black));
		setBounds(loc[0]-padding, loc[1]-padding, size[0], size[1]);
		setVisible(true);
		
		for(int i = 0; i<2; i++) {
			NavBtn tb = new NavBtn(f, jt, i, sql, size, type, fs);
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
