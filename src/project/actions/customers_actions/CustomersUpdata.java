package project.actions.customers_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import project.actions.customers_actions.CustomersSQLs;
import project.actions.customers_actions.main.Function_ctm;
import project.actions.customers_actions.main.object.CustomersAddData;
import project.components.customers_components.Table_ctm;

public class CustomersUpdata implements ActionListener{
	
	Table_ctm jp;
	JFrame f;
	DefaultTableModel dtm;
	CustomersAddData addData;
	String[] title;
	HashMap<String,Object> txts = new HashMap<>();
	String[] datas;
	int row;
	
	public CustomersUpdata(Table_ctm jp, JFrame f, int row, HashMap<String,Object> txts, String[] title) {
		this.jp = jp;
		this.f = f;
		this.row = row;
		this.txts = txts;
		this.title = title;
	}

	CustomersAddData getData() {
		addData = new CustomersAddData(datas);
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
				
				stop = new Function_ctm().regex(title[i], tempTxt.getText());
				
				if(stop == false) {
					break;
				}
				
				datas[i] = tempTxt.getText();
			}
		}
		if(stop == true) {
			
			new CustomersSQLs("¼öÁ¤", f, getData());
			
			new Function_ctm().updateView(jp, row);
			
			f.dispose();
		}
	}
}
