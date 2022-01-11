package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.main.Function_emp;
import project.actions.employees_actions.main.object.AddData;

public class Updata implements ActionListener{
	
	JFrame f;
	DefaultTableModel dtm;
	AddData addData;
	String[] title;
	HashMap<String,Object> txts = new HashMap<>();
	Object[] data;
	
	public Updata(JFrame f, DefaultTableModel dtm, HashMap<String,Object> txts, String[] title) {
		this.dtm = dtm;
		this.f = f;
		this.txts = txts;
		this.title = title;
	}

	AddData getData() {
		addData = new AddData(Integer.parseInt(String.valueOf(data[0])), 
				(String)data[1], LocalDate.parse((String)data[2], DateTimeFormatter.ISO_DATE), 
				(String)data[3], (String)data[4]);
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
				
				stop = new Function_emp().regex(title[i], tempTxt.getText());
				
				if(stop == false) {
					break;
				}
				
				data[i] = tempTxt.getText();
			}
		}
		
		if(stop == true) {
			new SQLs("¼öÁ¤", f, getData());
			dtm.fireTableDataChanged();
			f.dispose();
		}
	}
}
