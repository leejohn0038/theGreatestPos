package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.main.object.AddData;
import project.components.employees_companents.Select_layout;
import project.components.employees_companents.Table_emp;
import project.components.employees_companents.Table_layout;

//뷰자체가 작길래 한곳에서 하기로 결정...
public class SelectBtn extends JButton{
	public SelectBtn(Select_layout sl, Table_layout tl) {
		//view
		super("검색");
		setBounds(0,0,100,30);
		
		//action
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(sl.getComboBox().getSelectedItem()+ " " + sl.getComboBox().getSelectedIndex() +" " +sl.getSelectTxt().getText());
				
				AddData addDate = new AddData();
				Table_emp jt = tl.get_table();
				DefaultTableModel dtm = jt.getDtm();
				SQLs sql;
				Object[][] str;
				
				addDate.setSelectValue(sl.getComboBox().getSelectedIndex(), sl.getSelectTxt().getText());
				sql = new SQLs("검색", null, addDate);
				
				str = sql.getRowData();
				System.out.println(str.length);
				dtm.setRowCount(str.length);
				
				for(int row = 0; row<str.length; row++) {
					for(int col = 0; col<str[row].length; col++) {
						dtm.setValueAt(str[row][col], row, col);
					}
				}
				
				
				//dtm.addRow();
			}
		});
	}
}
