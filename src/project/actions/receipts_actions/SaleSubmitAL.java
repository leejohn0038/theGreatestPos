package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import project.MainFrame;
import project.components.receipts_components.Tables;
import project.database.receipts_DB.Sales;

public class SaleSubmitAL implements ActionListener {

	MainFrame main;
	
	public SaleSubmitAL(MainFrame main) {
		this.main = main;
	}
	
	public void actionPerformed( ActionEvent e) {
		JTable jT = main.getJTable();  
		Tables table = main.getTable();  
		JTextField field = main.getField();
		String gname = field.getText();
		Object[] result = Sales.getData(gname);
		boolean isExist = false;
		if(result[0] != null) {
			for (int i = 0; i < jT.getRowCount(); ++i) {
				if (gname.equals(String.valueOf(jT.getValueAt(i, 1)))) {
					int qty = Integer.parseInt(String.valueOf(jT.getValueAt(i, 2)));
					int price = Integer.parseInt(String.valueOf(jT.getValueAt(i, 3)));
					int gprice = Integer.parseInt(String.valueOf(result[3]));
					jT.setValueAt(++qty, i, 2);
					jT.setValueAt(price+=gprice, i, 3);
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				table.addRow(result);
			}
		} else {
			JOptionPane.showMessageDialog(main, "존재하지 않는 상품입니다.");
		}
	}
}
