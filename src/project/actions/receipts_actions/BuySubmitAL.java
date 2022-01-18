package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.database.receipts_DB.Buying;

public class BuySubmitAL implements ActionListener{
	
	MainFrame main; 
	
	public BuySubmitAL(MainFrame main) {
		this.main = main;
	}

	public void actionPerformed(ActionEvent e) {
		JTable jT = main.getJTable();
		String now = LocalDate.now().toString();
		int maxId;
		//System.out.println(n1);
		if((maxId = Buying.getMaxId()) == 0) {
			System.out.println("���� ���̺� �����Ͱ� ����");
		} else if(jT.getRowCount() > 0) {
			Buying.insertReceiptDatas(maxId + 1, main.getTotalPrice(), now);
		} else {
			System.out.println("����� ���� ����");
		}
//		Buying.insertReceiptDatas(, 0, n1);
		//System.out.println(main.getTotalPrice());
		
	}

}
