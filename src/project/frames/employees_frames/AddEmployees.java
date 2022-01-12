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
import project.actions.employees_actions.SQLs;
import project.actions.employees_actions.main.object.AddData;
import project.components.employees_companents.Table_emp;

public class AddEmployees extends JFrame{
	
	private int frame_size[] = {700,500}; 
	Table_emp jp;
	public HashMap<String,Object> txts;
	
	public AddEmployees(Table_emp jp, SQLs sql) {
		
		this.jp = jp;
		
		add(inner_lay(sql));
		setBounds(500,500,frame_size[0],frame_size[1]);
		setVisible(false);
	}
	
	JPanel inner_lay(SQLs sql) {
		
		JPanel inner = new JPanel();
		JLabel exLab = new JLabel("등록하실 직원 정보를 입력해주세요");
		
		JButton btn = new JButton("등록");
		
		String[] title_labs = {"ID", "이름", "전화번호", "직책"}; 
		ArrayList<JLabel> labs = new ArrayList<>();
		txts = new HashMap<>();
		
		int exLab_x; 
		
		inner.setLayout(null);
		//inner.setSize(100,100);
		
		//상단 설명란
		exLab.setSize(300, 50);
		exLab_x = Math.abs((frame_size[0]-exLab.getSize().width)/2);
		exLab.setLocation(exLab_x,0);
		exLab.setFont(new Font("consolas|돋움", Font.BOLD, 15));
		
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel lab = new JLabel();
			JLabel idLab = new JLabel();
			JTextField txt = new JTextField(20);
			int txtLoc[] = new int[2];
			
			//라벨로 정보 표시
			lab.setText(title_labs[i]);
			lab.setBounds(50,(i+1)*75,200,50);
			lab.setFont(new Font("consolas|돋움", Font.BOLD,20));
			lab.setBorder(new LineBorder(Color.black));
			
			//텍스트필드
			txtLoc[0] = lab.getSize().width + lab.getLocation().x + 50;
			txtLoc[1] = lab.getLocation().y;
			
			labs.add(lab);
			
			//아이디 값은 db에 넣은 순서대로 배정할할 예정
			if(i==0) {
				idLab.setText(Integer.toString(sql.getEmp_id()));
				idLab.setBounds(txtLoc[0], txtLoc[1], 300, 50);
				txts.put(title_labs[i], idLab);
				inner.add(idLab);
			}else {
				txt.setBounds(txtLoc[0], txtLoc[1], 300, 50);
				txts.put(title_labs[i], txt);
				inner.add(txt);
			}
			inner.add(lab);
			
		}
		
		btn.setSize(100,50);
		btn.setLocation(frame_size[0]-btn.getSize().width-100, frame_size[1]-btn.getSize().height-50);
		btn.addActionListener(new AddBtn(jp, this, txts, title_labs));
		
		inner.add(exLab);
		inner.add(btn);
		
		return inner;
	}
}














