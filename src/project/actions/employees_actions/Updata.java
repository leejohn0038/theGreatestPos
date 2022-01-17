package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.main.Function_emp;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.customers_components.object.Cus_addData;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;

public class Updata implements ActionListener{
	
	Table jp;
	JFrame f;
	DefaultTableModel dtm;
	Emp_addData emp_addData;
	Cus_addData cus_addData;
	String[] title;
	HashMap<String,Object> txts = new HashMap<>();
	String[] datas;
	boolean stop;
	int type;
	int row;
	
	public Updata(Table jp, JFrame f, int row, HashMap<String,Object> txts, String[] title, int type) {
		this.jp = jp;
		this.f = f;
		this.row = row;
		this.txts = txts;
		this.title = title;
		this.type = type;
	}

	Emp_addData emp_getData() {
		emp_addData = new Emp_addData(datas);
		return emp_addData;
	}
	
	Cus_addData cus_getData() {
		cus_addData = new Cus_addData(datas);
		return cus_addData;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		stop = true;
		
		if(type == 1) {
			emp();
		}else {
			cus();
		}
		
		if(stop == true) {
			f.dispose();
		}
		
	}
	
	void emp() {
		
		JLabel lab;
		datas = new String[title.length];
		
		for(int i = 0; i<title.length; i++) {
			if(title[i].contains("사원번호")) {
				lab = (JLabel) txts.get(title[i]);
				datas[i] = lab.getText();
			}else {
				JTextField tempTxt = (JTextField)txts.get(title[i]);
				stop = new Function_emp().regex(title[i], tempTxt.getText());
				if(stop == false) {
					break;
				}
				datas[i] = tempTxt.getText();
			}
		}
		if(stop == true) {
			new SQLs("수정", f, emp_getData(), 1);
			new Function_emp().updateView(jp, row, emp_getData());
		}
		
	}
	
	void cus() {
		
		datas = new String[title.length];
		
		for(int i = 0; i<title.length; i++) {
			
			JTextField tempTxt = (JTextField)txts.get(title[i]);
			
			stop = new Function_emp().regex(title[i], tempTxt.getText());
			
			if(stop == false) {
				break;
			}
			
			datas[i] = tempTxt.getText();
			
		}
		if(stop == true) {
			new SQLs("수정", f, cus_getData(), 2);
			new Function_emp().updateView(jp, row, cus_getData());
		}
		
	}
}
