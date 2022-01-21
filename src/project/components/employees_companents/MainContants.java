package project.components.employees_companents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.actions.QuitBtn;
import project.database.employee_customer.SQLs;


//프레임 안에 모든 것이 모인 패널
public class MainContants extends JPanel{
	
	private JFrame f;
	private SQLs sql;
	
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
		side.setSize(0,0);
		
		
		
		//종료버튼//
		QuitBtn quitBtn = new QuitBtn(fs, main); //fs 쓰는 이유는 기초 공사가 잘못되어 시간상 프레임으로 뷰를 설계할 수 밖에 없기에..
		quitBtn.setBackground(null);
		quitBtn.setBorderPainted(false);
		quitBtn.setSize(40,25);
		quitBtn.setText("");
		quitBtn.setIcon(new ImageIcon("image/employees/new_home.png"));
		
		//TBALE//
		Table_layout tl = new Table_layout(side.getSize().width, quitBtn.getHight(), sql, type, fs);
		tl.setBackground(Color.white);
		
		//버튼모음//
		NavBar btns = new NavBar(f, layViewData, tl, tl.get_table(), sql, type, fs);
		btns.setBackground(Color.white);
		
		//검색기능 + 검색버튼//
		Select_layout select = new Select_layout(tl, side.getSideWidth(), tl.getLocation().y, type);
		select.setBackground(Color.white);
		//select.setBorder(new LineBorder(Color.black));
		
		add(select);
		add(tl);
		//add(side);
		add(quitBtn);
		add(btns);
		
		JLabel logo = logo();
		
		add(logo);
		add(frameName(logo));
		
	}
	
	//프레임명
	JLabel frameName(JLabel logo) {
		
		JLabel title = new JLabel(f.getTitle());
		
		title.setBounds(logo.getLocation().x + logo.getSize().width + 50, 10, 
				50, 100);
		title.setFont(new Font("돋움", Font.BOLD, 20));
		//title.setBorder(new LineBorder(Color.black));
		
		return title;
	}
	
	//로고
	JLabel logo() {
		int[] logoSize = new int[] {200,100};
		
		JLabel logo = new JLabel("Team 2nd");
		
		logo.setBounds(50, 10, logoSize[0], logoSize[1]);
		logo.setFont(new Font("Serif", Font.BOLD, 40));
		return logo;
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
