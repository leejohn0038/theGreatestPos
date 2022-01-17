package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.main.object.Emp_addData;
import project.components.employees_companents.Select_layout;
import project.components.employees_companents.Table;
import project.components.employees_companents.Table_layout;
import project.database.employee_customer.SQLs;

//����ü�� �۱淡 �Ѱ����� �ϱ�� ����...
public class SelectBtn extends JButton{
	public SelectBtn(Select_layout sl, Table_layout tl) {
		//view
		super("�˻�");
		setBounds(0,0,100,30);
		
		//action
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Emp_addData addDate = new Emp_addData();
				Table jt = tl.get_table();
				DefaultTableModel dtm = jt.getDtm();
				SQLs sql;
				Object[][] str;
				
				addDate.setSelectValue(sl.getComboBox().getSelectedIndex(), sl.getSelectTxt().getText());
				sql = new SQLs("�˻�", null, addDate, 1);
				
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
}
