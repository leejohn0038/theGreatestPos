package project.frames.employees_frames;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.Updata;
import project.actions.employees_actions.main.Function_emp;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;

public class UpdataEmployees extends JFrame{
	
	private int frame_size[] = {700,500};
	int row;
	int[] txtLoc;
	
	String[] title_labs;
	
	Table jp;
	JPanel inner;
	JTextField txt;
	
	ArrayList<JLabel> labs;
	HashMap<String,Object> txts;
	
	
	public UpdataEmployees(Table jp, SQLs sql, int row, int type) {
		this.row = row;
		this.jp = jp;
		
		add(inner_lay(sql, type));
		
		setBounds(500,500,frame_size[0],frame_size[1]);
		setVisible(false);
	}
	
	JPanel inner_lay(SQLs sql, int type) {

		txtLoc = new int[2];
		txts = new HashMap<>();
		labs = new ArrayList<>();
		inner = new JPanel();
		
		JLabel exLab = new JLabel("�����Ͻ� �����͸� �ۼ����ּ���");
		JButton btn = new JButton("����");
		
		title_labs = new Function_emp().getTitle(type); 
		
		int exLab_x;
		
		inner.setLayout(null);
		
		//��� �����
		exLab.setSize(300, 50);
		exLab_x = Math.abs((frame_size[0]-exLab.getSize().width)/2);
		exLab.setLocation(exLab_x,0);
		exLab.setFont(new Font("consolas|����", Font.BOLD, 15));
		
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel title_lab = new JLabel();
			txt = new JTextField(20);
			
			JLabel idLab = new JLabel();
			
			//�󺧷� ���� ǥ��
			title_lab.setText(title_labs[i]);
			title_lab.setBounds(50,(i+1)*75,200,50);
			title_lab.setFont(new Font("consolas|����", Font.BOLD,20));
			title_lab.setBorder(new LineBorder(Color.black));
			
			//�ؽ�Ʈ�ʵ�
			txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
			txtLoc[1] = title_lab.getLocation().y;
			
			
			if(type == 1) {
				emp(title_lab, idLab, i , sql);
			}else if(type == 2) {
				cus(title_lab, i);
			}
		}
		
		btn.setSize(100,50);
		btn.setLocation(frame_size[0]-btn.getSize().width-100, frame_size[1]-btn.getSize().height-50);
		btn.addActionListener(new Updata(jp, this, row, txts, title_labs, type));
		
		inner.add(exLab);
		inner.add(btn);
		
		return inner;
	}
	
	void emp(JLabel title_lab, JLabel idLab, int i, SQLs sql) {
		
		labs.add(title_lab);
		
		if(i==0) {
			idLab.setText(Integer.toString((int)jp.dtm.getValueAt(row, 0)));
			idLab.setBounds(txtLoc[0], txtLoc[1], 300, 50);
			txts.put(title_labs[i], idLab);
			inner.add(idLab);
		}else {
			txt.setBounds(txtLoc[0], txtLoc[1], 300, 50);
			txt.setText(jp.dtm.getValueAt(row, i).toString());
			txts.put(title_labs[i], txt);
			inner.add(txt);
		}
		inner.add(title_lab);
	}
	
	void cus(JLabel title_lab, int i) {
		
		labs.add(title_lab);
		
		txt.setBounds(txtLoc[0], txtLoc[1], 300, 50);
		txt.setText(jp.dtm.getValueAt(row, i).toString());
		txts.put(title_labs[i], txt);
		inner.add(txt);
		inner.add(title_lab);
	}
}
