package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.main.object.Emp_addData;
import project.components.customers_components.object.Cus_addData;
import project.components.employees_companents.Select_layout;
import project.components.employees_companents.Table;
import project.components.employees_companents.Table_layout;
import project.database.employee_customer.SQLs;

//뷰자체가 작길래 한곳에서 하기로 결정...
public class SelectBtn extends JButton{
	
	int type;
	
	public SelectBtn(Select_layout sl, Table_layout tl, int[] size, int[] loc, int type) {
		//view
		super("검색");
		setLocation(loc[0],loc[1]);
		setBackground(null);
		setBorderPainted(false);
		setSize(28,28);
		setText("");
		setIcon(new ImageIcon("image/emp_search.png"));
		
		this.type = type;
		
		//action
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Table jt = tl.get_table();
				DefaultTableModel dtm = jt.getDtm();
				SQLs sql;
				Object[][] str;
				
				if(type == 1) {
					sql = emp(sl);
				}else {
					sql = cus(sl);	
				}
				
				str = sql.getRowData();
				
				dtm.setRowCount(str.length);
				
				for(int row = 0; row<str.length; row++) {
					for(int col = 0; col<str[row].length; col++) {
						dtm.setValueAt(str[row][col], row, col);
					}
				}
			}
		});
	}
	
	SQLs emp(Select_layout sl) {
		Emp_addData addDate = new Emp_addData();
		addDate.setSelectValue(sl.getComboBox().getSelectedIndex(), sl.getSelectTxt().getText());
		SQLs sql = new SQLs("검색", null, addDate, type);
		
		return sql;
	}
	
	SQLs cus(Select_layout sl) {
		Cus_addData addDate = new Cus_addData();
		addDate.setSelectValue(sl.getComboBox().getSelectedIndex(), sl.getSelectTxt().getText());
		SQLs sql = new SQLs("검색", null, addDate, type);
		
		return sql;
	}
}
