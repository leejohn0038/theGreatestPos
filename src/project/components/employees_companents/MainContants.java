package project.components.employees_companents;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.actions.QuitBtn;
import project.database.employee_customer.SQLs;


//프레임 안에 모든 것이 모인 패널
public class MainContants extends JPanel{
	
	JFrame f;
	SQLs sql;
	
	public MainContants(MainFrame main, JFrame f, SQLs sql, int type) {
		
		this.sql = sql;
		this.f = f;
		
		//Jpanel 기본 사이즈
		int[] layViewData = viewCalculate(f);
		
		ArrayList<JFrame> fs = new ArrayList<>();
		fs.add(f);
		
		setBackground(Color.white);
		setLayout(null);
		setBorder(new LineBorder(Color.black));
		setBounds(layViewData[0], layViewData[1], layViewData[2], layViewData[3]);
		
		//SIDE_BAR//
		SideBar_layout side = new SideBar_layout(main, layViewData, f.getTitle());
		side.setBackground(Color.white);
		
		//종료버튼//
		QuitBtn quitBtn = new QuitBtn(fs, main); //fs 쓰는 이유는 기초 공사가 잘못되어 시간상 프레임으로 뷰를 설계할 수 밖에 없기에..
		
		//TBALE//
		Table_layout tl = new Table_layout(side.getSize().width, quitBtn.getHight(), sql, type, fs);
		tl.setBackground(Color.white);
		
		//버튼모음//
		NavBar btns = new NavBar(f, layViewData, tl, tl.get_table(), sql, type, fs);
		btns.setBackground(Color.white);
		
		//검색기능 + 검색버튼//
		Select_layout select = new Select_layout(tl, side.getSideWidth(), tl.getLocation().y, type);
		select.setBackground(Color.white);
		
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
