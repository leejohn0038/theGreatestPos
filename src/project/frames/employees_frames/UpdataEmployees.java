package project.frames.employees_frames;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.actions.employees_actions.Updata;
import project.actions.employees_actions.main.Function_emp;
import project.components.employees_companents.Table;
import project.components.employees_companents.Table_layout;
import project.database.employee_customer.SQLs;

public class UpdataEmployees extends JFrame{
	
	int row;
	int[] txtLoc;
	
	String[] title_labs;
	
	Table jp;
	JPanel inner;
	JTextField txt;
	
	ArrayList<JLabel> labs;
	HashMap<String,Object> txts;
	
	
	public UpdataEmployees(Table_layout tl, Table jp, SQLs sql, int row, int type, ArrayList<JFrame> fs) {
		this.row = row;
		this.jp = jp;
		
		fs.add(this);
		
		int deletValueY = tl.getSize().height + tl.getLocation().y + 10;
		int[] size = {tl.getSize().width, fs.get(0).getSize().height - deletValueY + 10};
		
		//frame 셋팅
		setAlwaysOnTop(true);
		setUndecorated(true);
		setBounds(fs.get(0).getLocation().x+(fs.get(0).getSize().width-size[0])+1,fs.get(0).getLocation().y+(fs.get(0).getSize().height-size[1])+1,
				(int)(size[0]/1.2),size[1]-5);
		setVisible(false);
		
		add(inner_lay(sql, type));
	}
	
	JPanel inner_lay(SQLs sql, int type) {

		int[] size = {100, 20};
		
		txtLoc = new int[2];
		txts = new HashMap<>();
		labs = new ArrayList<>();
		inner = new JPanel();
		
		JLabel exLab = new JLabel("수정하실 데이터를 작성해주세요");
		JButton btn = new JButton("수정");
		
		title_labs = new Function_emp().getTitle(type); 
		
		inner.setLayout(null);
		inner.setBackground(Color.white);
		
		//상단 설명란
		exLab.setSize(300, 50);
		exLab.setLocation((this.getSize().width - exLab.getSize().width)/2 ,0);
		exLab.setFont(new Font("consolas|돋움", Font.BOLD, 15));
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel title_lab = new JLabel();
			txt = new JTextField(20);
			
			JLabel idLab = new JLabel();
			
			//라벨로 정보 표시
			title_lab.setText(title_labs[i]);
			title_lab.setBounds(30,(i*(size[1]+30))+60,size[0],size[1]);
			title_lab.setFont(new Font("consolas|돋움", Font.BOLD,20));
			
			//텍스트필드
			txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
			txtLoc[1] = title_lab.getLocation().y;
			
			if(type == 1) {
				emp(title_lab, idLab, i , sql);
			}else if(type == 2) {
				cus(title_lab, i);
			}
		}
		
		btn.setText("");
		btn.setIcon(new ImageIcon("./image/employees/modify.png"));
		btn.setBackground(null);
		btn.setBorderPainted(false);
		btn.setSize(100,50);
		btn.setLocation(this.getSize().width-btn.getSize().width, this.getSize().height-btn.getSize().height-26);
		btn.addActionListener(new Updata(jp, this, row, txts, title_labs, type));
		
		inner.add(exLab);
		inner.add(btn);
		
		return inner;
	}
	
	void emp(JLabel title_lab, JLabel idLab, int i, SQLs sql) {
		
		labs.add(title_lab);
		
		if(i==0) {
			idLab.setText(Integer.toString((int)jp.dtm.getValueAt(row, 0)));
			idLab.setBounds(txtLoc[0], txtLoc[1], 200, 30);
			txts.put(title_labs[i], idLab);
			inner.add(idLab);
		}else {
			txt.setBounds(txtLoc[0], txtLoc[1], 200, 30);
			txt.setText(jp.dtm.getValueAt(row, i).toString());
			txts.put(title_labs[i], txt);
			inner.add(txt);
		}
		inner.add(title_lab);
	}
	
	void cus(JLabel title_lab, int i) {
		
		labs.add(title_lab);
		
		txt.setBounds(txtLoc[0], txtLoc[1], 200, 30);
		txt.setText(jp.dtm.getValueAt(row, i).toString());
		txts.put(title_labs[i], txt);
		inner.add(txt);
		inner.add(title_lab);
	}
}
