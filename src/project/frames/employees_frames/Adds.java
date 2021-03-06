package project.frames.employees_frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
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
	
	public HashMap<String,Object> txts = new HashMap<>();
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
		//상위 프레임과 같은 위치에 위치할 수 있게 계산
		setBounds(f.getLocation().x+(f.getSize().width-size[0])+1,f.getLocation().y+(f.getSize().height-size[1])+1,
				(int)(size[0]/1.2),size[1]-5);
		setVisible(false);
		
		add(inner_lay(sql, type));
	}
	
	JPanel inner_lay(SQLs sql, int type) {
		
		int[] size = {100, 20};
		
		inner = new JPanel();
		
		JLabel exLab = new JLabel("등록하실 정보를 입력해주세요");
		
		title_labs = sql.getTitle(); 
		txts = new HashMap<>();
		
		//상단 설명란
		exLab.setSize(300, 50);
		exLab.setLocation((this.getSize().width - exLab.getSize().width)/2 ,0);
		exLab.setFont(new Font("consolas|돋움", Font.BOLD, 15));
		
		int cnt = 0;
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel title_lab = new JLabel();
			
			txt = new JTextField(20);
			
			if(!title_labs[i].contains("입사") && type == 1) {
				JLabel idLab = new JLabel();
				
				//라벨로 정보 표시
				title_lab.setText(title_labs[i]);
				title_lab.setBounds(30,(cnt*(size[1]+30))+60,size[0],size[1]);
				title_lab.setFont(new Font("consolas|돋움", Font.BOLD,20));
				
				//사용자 입력 텍스트필드 위치
				txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
				txtLoc[1] = title_lab.getLocation().y;
				
				emp(title_lab, idLab, i, sql);
				cnt++;
			}else if(!(title_labs[i].contains("포인트")||title_labs[i].contains("등록일")) && type == 2) {
				
				//라벨로 정보 표시
				title_lab.setText(title_labs[i]);
				title_lab.setBounds(30,(i*(size[1]+30))+60,size[0],size[1]);
				title_lab.setFont(new Font("consolas|돋움", Font.BOLD,20));
				
				//사용자 입력 텍스트필드 위치
				txtLoc[0] = title_lab.getSize().width + title_lab.getLocation().x + 50;
				txtLoc[1] = title_lab.getLocation().y;
				
				cus(title_lab, i);
				cnt++;
			}
			
		}
		
		JButton btn = add(type);
		
		inner.setLayout(null);
		inner.setBackground(Color.white);
		inner.add(exLab);
		inner.add(btn);
		inner.add(quit(btn));
		
		return inner;
	}
	
	JButton add(int type) {
		JButton addBtn = new JButton();

		addBtn.setSize(100,50);
		addBtn.setLocation(this.getSize().width-addBtn.getSize().width, (this.getSize().height-(addBtn.getSize().height*2)-26)-10);
		addBtn.setBackground(null);
		addBtn.setBorderPainted(false);
		addBtn.setText("");
		addBtn.setIcon(new ImageIcon("./image/employees/add.png"));
		addBtn.addActionListener(new AddBtn(jp, this, txts, type));

		return addBtn; 
	}
	
	QuitBtn quit(JButton btn) {
		QuitBtn quitBtn = new QuitBtn(this, f);
		
		quitBtn.setIcon(new ImageIcon("./image/employees/cancelar.png"));
		quitBtn.setText("");
		quitBtn.setBackground(null);
		quitBtn.setBorderPainted(false);
		quitBtn.setSize(btn.getSize().width, btn.getSize().height);
		quitBtn.setLocation(btn.getLocation().x, btn.getLocation().y+quitBtn.getSize().height+10);
		
		return quitBtn;
	}
	
	void emp(JLabel title_lab, JLabel idLab, int i, SQLs sql) {

		labs.add(title_lab);
		
		//아이디 값은 db에 넣은 순서대로 배정할할 예정
		if(i==0) {
			idLab.setText(Integer.toString(sql.emp_getAddEmp_id()));
			idLab.setBounds(txtLoc[0], txtLoc[1], 300, 30);
			txts.put(title_labs[i], idLab);
			inner.add(idLab);
		}else {
			txt.setBounds(txtLoc[0], txtLoc[1], 300, 30);
			txts.put(title_labs[i], txt);
			inner.add(txt);
		}
		inner.add(title_lab);
		
	}
	
	void cus(JLabel title_lab, int i) {
		
		labs.add(title_lab);
		
		txt.setBounds(txtLoc[0], txtLoc[1], 300, 30);
		txts.put(title_labs[i], txt);
		inner.add(txt);
		inner.add(title_lab);
	}
}














