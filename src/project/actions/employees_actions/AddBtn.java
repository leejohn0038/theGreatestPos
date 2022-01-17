package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import project.actions.employees_actions.main.Function_emp;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.customers_components.object.Cus_addData;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;
import project.frames.employees_frames.Adds;

public class AddBtn implements ActionListener {
	
	Adds f;
	Table jp;
	HashMap<String,Object> txts = new HashMap<>();
	String[] datas;
	String[] title;
	boolean stop;
	int type;

	public AddBtn(Table jp, Adds f, HashMap<String,Object> txts, int type) {
		this.jp = jp;
		this.f = f;
		this.txts = txts;
		this.type = type;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		stop = true;
		
		if(type == 1) {
			title = new Function_emp().getTitle(1);
			datas = new String[title.length];
			emp();
		}else {
			title = new Function_emp().getTitle(2);
			datas = new String[title.length];
			cus();
		}
		
		if(stop == true) {
			f.dispose();
		}
	}
	
	Emp_addData getEmpData() {
		Emp_addData addData = new Emp_addData(datas);
		return addData;
	}
	
	Cus_addData getCusData() {
		Cus_addData addData = new Cus_addData(datas);
		return addData;
	}
	
	void emp() {
		
		JLabel lab;
		
		for(int i = 0; i<title.length; i++) {
			if(title[i].contains("사원")) {
				lab = (JLabel) txts.get(title[i]);
				datas[i] = lab.getText();
			}else if(!title[i].contains("입사일")) {
				
				JTextField tempTxt = (JTextField)txts.get(title[i]);
				
				stop = new Function_emp().regex(title[i], tempTxt.getText());

				
				if(stop == true) {
					
					datas[i] = tempTxt.getText();
				}else {
					break;
				}
			}else {
				datas[2] = null;
			}
		}
		
		//수정 요망
		if(stop == true) {
			SQLs add_sql = new SQLs("등록", f, getEmpData(),type);
			jp.dtm.addRow(add_sql.emp_addData.getDates());
			JLabel temp_lab = (JLabel) f.txts.get(title[0]);
			
			temp_lab.setText(Integer.toString(new SQLs("리셋", type).emp_getAddEmp_id()));
			
			for(int i = 1; i<title.length; i++) {
				if(!title[i].contains("입사")) {
					JTextField temp_txt = (JTextField) f.txts.get(title[i]);
					temp_txt.setText("");
				}
			}
			
		}
	}
	
	void cus() {
		for(int i = 0; i<title.length; i++) {
			if(!(title[i].contains("포인트")||(title[i].contains("등록일")))) {
				JTextField tempTxt = (JTextField)txts.get(title[i]);
				
				stop = new Function_emp().regex(title[i], tempTxt.getText());
				
				if(stop == true) {
					datas[i] = tempTxt.getText();
				}
			}else {
				datas[3] = null;
				datas[4] = null;
			}
		}
		
		//수정 요망
		if(stop == true) {
			SQLs add_sql = new SQLs("등록", f, getCusData(), type);
			jp.dtm.addRow(add_sql.cus_addData.getDates());
			
			for(int i = 1; i<title.length; i++) {
				if(!(title[i].contains("등록일")||title[i].contains("포인트"))) {
					JTextField temp_txt = (JTextField) f.txts.get(title[i]);
					temp_txt.setText("");
				}
			}
		}
	}
}
