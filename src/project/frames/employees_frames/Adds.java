package project.frames.employees_frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import org.w3c.dom.Text;

import project.actions.QuitBtn;
import project.actions.employees_actions.AddBtn;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;

public class Adds extends JFrame{
	
	JFrame f;
	
	public HashMap<String,Object> txts;
	ArrayList<JLabel> labs = new ArrayList<>();

	Table jp;
	JPanel inner;
	JTextField txt;
	
	int[] txtLoc = new int[2];
	String[] title_labs;
	
	public Adds(JFrame f, Table jp, SQLs sql, int type, int[] size, ArrayList<JFrame> fs) {
		
		fs.add(this);
		
		this.jp = jp;
		this.f = f;
		
		setAlwaysOnTop(true);
		setUndecorated(true);
		//���� �����Ӱ� ���� ��ġ�� ��ġ�� �� �ְ� ���
		setBounds(f.getLocation().x+(f.getSize().width-size[0])+1,f.getLocation().y+(f.getSize().height-size[1])+1,
				(int)(size[0]/1.23),size[1]-5);
		setVisible(false);
		
		add(inner_lay(sql, type));
	}
	
	JPanel inner_lay(SQLs sql, int type) {
		
		int[] size = {100, 20};
		
		inner = new JPanel();
		
		JLabel exLab = new JLabel("����Ͻ� ���� ������ �Է����ּ���");
		JButton btn = new JButton("���");
		
		title_labs = sql.getTitle(); 
		txts = new HashMap<>();
		
		//��� �����
		exLab.setSize(300, 50);
		exLab.setLocation((this.getSize().width - exLab.getSize().width)/2 ,0);
		exLab.setFont(new Font("consolas|����", Font.BOLD, 15));
		
		int cnt = 0;
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel title_lab = new JLabel();
			
			txt = new JTextField(20);
			
			if(!title_labs[i].contains("�Ի�") && type == 1) {
				JLabel idLab = new JLabel();
				
				//�󺧷� ���� ǥ��
				title_lab.setText(title_labs[i]);
				title_lab.setBounds(30,(cnt*(size[1]+30))+60,size[0],size[1]);
				title_lab.setFont(new Font("consolas|����", Font.BOLD,20));
				
				//����� �Է� �ؽ�Ʈ�ʵ� ��ġ
				txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
				txtLoc[1] = title_lab.getLocation().y;
				
				emp(title_lab, idLab, i, sql);
				cnt++;
			}else if(!(title_labs[i].contains("����Ʈ")||title_labs[i].contains("�����")) && type == 2) {
				
				//�󺧷� ���� ǥ��
				title_lab.setText(title_labs[i]);
				title_lab.setBounds(50,(cnt+1)*75,200,50);
				title_lab.setFont(new Font("consolas|����", Font.BOLD,20));
				title_lab.setBorder(new LineBorder(Color.black));
				
				//����� �Է� �ؽ�Ʈ�ʵ� ��ġ
				txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
				txtLoc[1] = title_lab.getLocation().y;
				
				cus(title_lab, i);
				cnt++;
			}
			
		}
		
		btn.setSize(100,30);
		btn.setLocation(this.getSize().width-btn.getSize().width, this.getSize().height-btn.getSize().height-26);
		btn.addActionListener(new AddBtn(jp, this, txts, type));
		
		inner.setLayout(null);
		inner.add(exLab);
		inner.add(btn);
		
		return inner;
	}
	
	
	void emp(JLabel title_lab, JLabel idLab, int i, SQLs sql) {

		labs.add(title_lab);
		
		//���̵� ���� db�� ���� ������� �������� ����
		if(i==0) {
			idLab.setText(Integer.toString(sql.emp_getAddEmp_id()));
			idLab.setBounds(txtLoc[0], txtLoc[1], 200, 30);
			txts.put(title_labs[i], idLab);
			inner.add(idLab);
		}else {
			txt.setBounds(txtLoc[0], txtLoc[1], 200, 30);
			txts.put(title_labs[i], txt);
			inner.add(txt);
		}
		inner.add(title_lab);
		
	}
	
	void cus(JLabel title_lab, int i) {
		
		labs.add(title_lab);
		
		txt.setBounds(txtLoc[0], txtLoc[1], 200, 30);
		txts.put(title_labs[i], txt);
		inner.add(txt);
		inner.add(title_lab);
	}
}














