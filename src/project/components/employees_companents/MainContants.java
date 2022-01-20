package project.components.employees_companents;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.actions.QuitBtn;
import project.database.employee_customer.SQLs;


//������ �ȿ� ��� ���� ���� �г�
public class MainContants extends JPanel{
	
	JFrame f;
	SQLs sql;
	
	public MainContants(MainFrame main, JFrame f, SQLs sql, int type) {
		
		this.sql = sql;
		this.f = f;
		
		//Jpanel �⺻ ������
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
		
		//�����ư//
		QuitBtn quitBtn = new QuitBtn(fs, main); //fs ���� ������ ���� ���簡 �߸��Ǿ� �ð��� ���������� �並 ������ �� �ۿ� ���⿡..
		
		//TBALE//
		Table_layout tl = new Table_layout(side.getSize().width, quitBtn.getHight(), sql, type, fs);
		tl.setBackground(Color.white);
		
		//��ư����//
		NavBar btns = new NavBar(f, layViewData, tl, tl.get_table(), sql, type, fs);
		btns.setBackground(Color.white);
		
		//�˻���� + �˻���ư//
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
		//1_row : frame ��갪
		int[] total = new int[4];
		
		//��ġ
		total[0] = f.getInsets().left;
		total[1] = f.getInsets().top;
		//������
		total[2] = f.getSize().width - (f.getInsets().left + f.getInsets().right);
		total[3] = f.getSize().height - (f.getInsets().top + f.getInsets().bottom);
		
		//System.out.println(Arrays.toString(total));
		
		return total;	
	}
}
