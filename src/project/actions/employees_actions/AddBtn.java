package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project.actions.employees_actions.main.object.AddData;

public class AddBtn implements ActionListener {
	JFrame f, emp_f;
	String[] title;
	HashMap<String,Object> txts = new HashMap<>();
	
	Object[] data;

	public AddBtn(JFrame emp_f, JFrame f, HashMap<String,Object> txts, String[] title) {
		this.emp_f = emp_f;
		this.f = f;
		this.title = title;
		this.txts = txts;
	}
	
	AddData getData() {
		AddData addData = new AddData(Integer.parseInt(String.valueOf(data[0])), (String)data[1], null, (String)data[2], (String)data[3]);
		return addData;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel lab;
		data = new Object[title.length];
		boolean stop = true;
		
		for(int i = 0; i<title.length; i++) {
			if(i==0) {
				lab = (JLabel) txts.get(title[i]);
				data[i] = Integer.parseInt(String.valueOf(lab.getText()));
			}else {
				
				JTextField tempTxt = (JTextField)txts.get(title[i]);
				
				if((i == 2 && !(Pattern.matches("010\\-*\\d{4}\\-*\\d{4}", tempTxt.getText()))) ||
						(i == 3 && !(Pattern.matches("\\W{2,}", tempTxt.getText())))) {
					JOptionPane massge = new JOptionPane();
					massge.showMessageDialog(null, title[i] + " 잘못된 값 입력");
					stop = false;
				}else if(i == title.length-1 && stop == true) {
					data[i] = tempTxt.getText();
					stop = true;
				}else {
					data[i] = tempTxt.getText();
				}
				
			}
		}
		
		if(stop == true) {
			new SQLs("등록", f, getData());
			f.dispose();
		}
	}
	
}
