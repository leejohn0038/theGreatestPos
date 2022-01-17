package project.frames.employees_frames;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.AddBtn;
import project.actions.employees_actions.Updata;
import project.actions.employees_actions.main.Function_emp;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;

public class UpdataEmployees extends JFrame{
	
	private int frame_size[] = {700,500};
	Table jp;
	int row;
	
	public UpdataEmployees(Table jp, SQLs sql, int row) {
		this.row = row;
		this.jp = jp;
		add(inner_lay(sql));
		setBounds(500,500,frame_size[0],frame_size[1]);
		setVisible(false);
	}
	
	JPanel inner_lay(SQLs sql) {
		
		JPanel inner = new JPanel();
		JLabel exLab = new JLabel("�����Ͻ� �����͸� �ۼ����ּ���");
		JButton btn = new JButton("����");
		
		String[] title_labs = new Function_emp().getTitle(1); 
		ArrayList<JLabel> labs = new ArrayList<>();
		HashMap<String,Object> txts = new HashMap<>();
		
		int exLab_x; 
		
		inner.setLayout(null);
		
		//��� �����
		exLab.setSize(300, 50);
		exLab_x = Math.abs((frame_size[0]-exLab.getSize().width)/2);
		exLab.setLocation(exLab_x,0);
		exLab.setFont(new Font("consolas|����", Font.BOLD, 15));
		
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel lab = new JLabel();
			JLabel idLab = new JLabel();
			JTextField txt = new JTextField(20);
			int txtLoc[] = new int[2];
			
			//�󺧷� ���� ǥ��
			lab.setText(title_labs[i]);
			lab.setBounds(50,(i+1)*75,200,50);
			lab.setFont(new Font("consolas|����", Font.BOLD,20));
			lab.setBorder(new LineBorder(Color.black));
			
			//�ؽ�Ʈ�ʵ�
			txtLoc[0] = lab.getSize().width + lab.getLocation().x + 50;
			txtLoc[1] = lab.getLocation().y;
			
			labs.add(lab);
			
			
			//���̵� ���� db�� ���� ������� �������� ����
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
			inner.add(lab);
			
		}
		
		btn.setSize(100,50);
		btn.setLocation(frame_size[0]-btn.getSize().width-100, frame_size[1]-btn.getSize().height-50);
		btn.addActionListener(new Updata(jp, this, row, txts, title_labs));
		
		inner.add(exLab);
		inner.add(btn);
		
		return inner;
	}
}
