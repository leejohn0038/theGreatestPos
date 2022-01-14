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
import project.actions.employees_actions.main.object.AddData;
import project.components.employees_companents.Table_emp;

public class Updata implements ActionListener{
	
	Table_emp jp;
	JFrame f;
	DefaultTableModel dtm;
	AddData addData;
	String[] title;
	HashMap<String,Object> txts = new HashMap<>();
	String[] datas;
	int row;
	
	public Updata(Table_emp jp, JFrame f, int row, HashMap<String,Object> txts, String[] title) {
		this.jp = jp;
		this.f = f;
		this.row = row;
		this.txts = txts;
		this.title = title;
	}

	AddData getData() {
		addData = new AddData(datas);
		return addData;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel lab;
		datas = new String[title.length];
		
		boolean stop = true;
		
		for(int i = 0; i<title.length; i++) {
			if(i==0) {
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
			
			new SQLs("¼öÁ¤", f, getData());
			
			new Function_emp().updateView(jp, row);
			
			f.dispose();
		}
	}
}
