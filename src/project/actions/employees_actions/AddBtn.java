package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import project.actions.employees_actions.main.Function_emp;
import project.actions.employees_actions.main.object.AddData;
import project.components.employees_companents.Table_emp;
import project.frames.employees_frames.AddEmployees;

public class AddBtn implements ActionListener {
	
	AddEmployees f;
	Table_emp jp;
	HashMap<String,Object> txts = new HashMap<>();
	String[] datas;

	public AddBtn(Table_emp jp, AddEmployees f, HashMap<String,Object> txts) {
		this.jp = jp;
		this.f = f;
		this.txts = txts;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] title = new Function_emp().getTitle();
		JLabel lab;
		datas = new String[title.length];
		boolean stop = true;
		
		for(int i = 0; i<title.length; i++) {
			if(title[i].contains("사원")) {
				lab = (JLabel) txts.get(title[i]);
				datas[i] = lab.getText();
			}else if(!title[i].contains("입사일")) {
				
				JTextField tempTxt = (JTextField)txts.get(title[i]);
				
				if((title[i].contains("전화") && !(Pattern.matches("010\\-*\\d{4}\\-*\\d{4}", tempTxt.getText()))) ||
						(title[i].contains("직책") && (!(Pattern.matches("\\W{2,}", tempTxt.getText()))|| tempTxt.getText() == ""))) {
					JOptionPane massge = new JOptionPane();
					massge.showMessageDialog(null, title[i] + " 잘못된 값 입력");
					stop = false;
				}else if(i == title.length-1 && stop == true) {
					datas[i] = tempTxt.getText();
					stop = true;
				}else {
					datas[i] = tempTxt.getText();
				}
				
			}else {
				datas[2] = null;
			}
		}
		
		//수정 요망
		if(stop == true) {
			SQLs add_sql = new SQLs("등록", f, getData());
			jp.dtm.addRow(add_sql.addData.getDates());
			JLabel temp_lab = (JLabel) f.txts.get(title[0]);
			temp_lab.setText(Integer.toString(new SQLs("리셋", null, null).getEmp_id()));
			for(int i = 1; i<title.length; i++) {
				if(!title[i].contains("입사")) {
					System.out.println(title[i]);
					JTextField temp_txt = (JTextField) f.txts.get(title[i]);
					temp_txt.setText("");
				}
			}
			f.dispose();
		}
	}
	
	AddData getData() {
		AddData addData = new AddData(datas);
		return addData;
	}
	
}
