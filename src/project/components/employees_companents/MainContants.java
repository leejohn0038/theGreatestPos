package project.components.employees_companents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.actions.QuitBtn;
import project.actions.employees_actions.main.TopBtn;
import project.database.employee_customer.SQLs;

public class MainContants extends JPanel{
	
	JFrame f;
	SQLs sql;
	
	public MainContants(MainFrame main, JFrame f, SQLs sql, int type) {
		
		this.sql = sql;
		this.f = f;
		
		//Jpanel 기본 사이즈
		int[] layViewData = viewCalculate(f);
		
		setLayout(null);
		setBorder(new LineBorder(Color.black));
		setBounds(layViewData[0], layViewData[1], layViewData[2], layViewData[3]);
		
		//SIDE_BAR//
		SideBar_layout side = new SideBar_layout(main, layViewData, f.getTitle());
		
		//종료버튼//
		QuitBtn quitBtn = new QuitBtn(f, main);
		
		//TBALE//
		Table_layout tl = new Table_layout(side.getSize().width, quitBtn.getHight(), sql, type);
		
		//버튼모음//
		NavBar btns = new NavBar(layViewData, tl.get_table(), sql, type);
		
		//검색기능//
		Select_layout select = new Select_layout(tl, side.getSideWidth(), tl.getLocation().y, type);
		
		add(select);
		add(tl);
		add(side);
		add(quitBtn);
		add(btns);
	}
	
	int[] viewCalculate(JFrame f){
		//0_row : title bar
		//1_row : frame 계산값
		int[] total = new int[4];
		
		//위치
		total[0] = f.getInsets().left;
		total[1] = f.getInsets().top;
		//사이즈
		total[2] = f.getSize().width - (f.getInsets().left + f.getInsets().right);
		total[3] = f.getSize().height - (f.getInsets().top + f.getInsets().bottom);
		
		//System.out.println(Arrays.toString(total));
		
		return total;	
	}
}
