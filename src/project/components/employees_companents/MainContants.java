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


//������ �ȿ� ��� ���� ���� �г�
public class MainContants extends JPanel{
	
	private JFrame f;
	private SQLs sql;
	
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
		
		//SIDE_BAR// (���� ����� �������� / �ؿ� �������� �����ؼ� �ϳ� ������ ����ϱ� ���������⿡ ����׽��ϴ�.)
		SideBar_layout side = new SideBar_layout(main, layViewData, f.getTitle());
		side.setBackground(Color.white);
		side.setSize(0,0);
		
		//�����ư//
		//arr_list�� ����� ������ ���, ȸ���� ����̶� ������ ���� ���������� ���谡�Ǽ�
		QuitBtn quitBtn = new QuitBtn(fs, main); 
		quitBtn.setBackground(null);
		quitBtn.setBorderPainted(false);
		quitBtn.setSize(40,25);
		quitBtn.setText("");
		quitBtn.setIcon(new ImageIcon("image/employees/new_home.png"));
		
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
		add(quitBtn);
		add(btns);
		
		
		//�ΰ� �� Ÿ��Ʋ JLable
		JLabel logo = logo();
		
		add(logo);
		add(frameName(logo));
		
	}
	
	//�����Ӹ�
	JLabel frameName(JLabel logo) {
		
		JLabel title = new JLabel();
		
		if(f.getTitle() == "����") {
			title.setText("Employees");
		}else {
			title.setText("Customers");
		}
		
		//�ΰ�� ���� �پ��ֱ�ٷ��� ��ġ�� �����޾ҽ��ϴ�.
		title.setBounds(logo.getLocation().x + logo.getSize().width + 50, 10, 200, 100);
		title.setFont(new Font("���� ���", Font.BOLD, 20));
		//title.setBorder(new LineBorder(Color.black));
		
		return title;
	}
	
	//�ΰ�
	JLabel logo() {
		int[] logoSize = new int[] {200,100};
		
		JLabel logo = new JLabel();
		
		logo.setIcon(new ImageIcon("./image/logo_hori.png"));
		logo.setBounds(50, 10, logoSize[0], logoSize[1]);
		logo.setFont(new Font("Serif", Font.BOLD, 40));
		return logo;
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
