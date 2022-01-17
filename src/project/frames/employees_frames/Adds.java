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

import project.actions.employees_actions.AddBtn;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;

public class Adds extends JFrame{
	
	private int frame_size[] = {700,500}; 
	Table jp;
	public HashMap<String,Object> txts;
	String[] title_labs;
	ArrayList<JLabel> labs = new ArrayList<>();
	JPanel inner;
	JTextField txt;
	int[] txtLoc = new int[2];
	
	public Adds(Table jp, SQLs sql, int type) {
		
		this.jp = jp;
		
		add(inner_lay(sql, type));
		
		setBounds(500,500,frame_size[0],frame_size[1]);
		setVisible(false);
	}
	
	JPanel inner_lay(SQLs sql, int type) {
		
		inner = new JPanel();
		JLabel exLab = new JLabel("등록하실 직원 정보를 입력해주세요");
		
		JButton btn = new JButton("등록");
		
		title_labs = sql.getTitle(); 
		txts = new HashMap<>();
		
		int exLab_x; 
		
		inner.setLayout(null);

		//상단 설명란
		exLab.setSize(300, 50);
		exLab_x = Math.abs((frame_size[0]-exLab.getSize().width)/2);
		exLab.setLocation(exLab_x,0);
		exLab.setFont(new Font("consolas|돋움", Font.BOLD, 15));
		
		int cnt = 0;
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel title_lab = new JLabel();
			
			txt = new JTextField(20);
			
			if(!title_labs[i].contains("입사") && type == 1) {
				JLabel idLab = new JLabel();
				
				//라벨로 정보 표시
				title_lab.setText(title_labs[i]);
				title_lab.setBounds(50,(cnt+1)*75,200,50);
				title_lab.setFont(new Font("consolas|돋움", Font.BOLD,20));
				title_lab.setBorder(new LineBorder(Color.black));
				
				//사용자 입력 텍스트필드 위치
				txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
				txtLoc[1] = title_lab.getLocation().y;
				
				emp(title_lab, idLab, i, sql);
				cnt++;
			}else if(!(title_labs[i].contains("포인트")||title_labs[i].contains("등록일")) && type == 2) {
				//라벨로 정보 표시
				title_lab.setText(title_labs[i]);
				title_lab.setBounds(50,(cnt+1)*75,200,50);
				title_lab.setFont(new Font("consolas|돋움", Font.BOLD,20));
				title_lab.setBorder(new LineBorder(Color.black));
				
				//사용자 입력 텍스트필드 위치
				txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
				txtLoc[1] = title_lab.getLocation().y;
				
				cus(title_lab, i);
				cnt++;
			}
			
		}
		
		btn.setSize(100,50);
		btn.setLocation(frame_size[0]-btn.getSize().width-100, frame_size[1]-btn.getSize().height-50);
		btn.addActionListener(new AddBtn(jp, this, txts, type));
		
		inner.add(exLab);
		inner.add(btn);
		
		return inner;
	}
	
	void emp(JLabel title_lab, JLabel idLab, int i, SQLs sql) {

		labs.add(title_lab);
		
		//아이디 값은 db에 넣은 순서대로 배정할할 예정
		if(i==0) {
			idLab.setText(Integer.toString(sql.emp_getAddEmp_id()));
			idLab.setBounds(txtLoc[0], txtLoc[1], 300, 50);
			txts.put(title_labs[i], idLab);
			inner.add(idLab);
		}else {
			txt.setBounds(txtLoc[0], txtLoc[1], 300, 50);
			txts.put(title_labs[i], txt);
			inner.add(txt);
		}
		inner.add(title_lab);
		
	}
	
	void cus(JLabel title_lab, int i) {
		
		labs.add(title_lab);
		
		txt.setBounds(txtLoc[0], txtLoc[1], 300, 50);
		txts.put(title_labs[i], txt);
		inner.add(txt);
		inner.add(title_lab);
	}
}














