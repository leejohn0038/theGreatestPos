package project.actions.customers_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import project.actions.customers_actions.CustomersSQLs;
import project.actions.customers_actions.main.object.CustomersAddData;
import project.components.customers_components.CustomersSelectLayout;
import project.components.customers_components.Table_ctm;
import project.components.customers_components.CustomersTableLayout;

//����ü�� �۱淡 �Ѱ����� �ϱ�� ����...
public class CustomersSelectBtn extends JButton{
	public CustomersSelectBtn(CustomersSelectLayout sl, CustomersTableLayout tl) {
		//view
		super("�˻�");
		setBounds(0,0,100,30);
		
		//action
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(sl.getComboBox().getSelectedItem()+ " " + sl.getComboBox().getSelectedIndex() +" " +sl.getSelectTxt().getText());
				
				CustomersAddData addDate = new CustomersAddData();
				Table_ctm jt = tl.get_table();
				DefaultTableModel dtm = jt.getDtm();
				CustomersSQLs sql;
				Object[][] str;
				
				addDate.setSelectValue(sl.getComboBox().getSelectedIndex(), sl.getSelectTxt().getText());
				sql = new CustomersSQLs("�˻�", null, addDate);
				
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
