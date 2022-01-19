package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.components.receipts_components.Tables;
import project.database.receipts_DB.Refund;
import project.frames.receipts_frames.Receipts;
import project.frames.receipts_frames.Refunding;


public class RefundingSubmitAL implements ActionListener {

	MainFrame main;
	
	public RefundingSubmitAL(MainFrame main) {
		this.main = main;
	}

	public void actionPerformed(ActionEvent e) {
		Refunding refunding = ((Refunding)main.getFrame("반품업무"));
		String payment = refunding.getPayment();
		if (payment.equals("현금")) {
			refundAL(refunding);
		} else {
			if (refunding.getCardrefund()) {
				refundAL(refunding);
			} else {
				JOptionPane.showMessageDialog(refunding, "카드 정보를 입력해주세요.");
			}
		}
	}
	
	public void refundAL(Refunding refunding) {
		String phone = refunding.getPhone();
		JTable jT = refunding.getJTable();
		JTable receiptsjT = ((Receipts)main.getFrame("영수증")).getJTable();
		Tables refundTable = refunding.getTable();
		Tables receiptsTable = ((Receipts)main.getFrame("영수증")).getTable();
		int[] rows = jT.getSelectedRows();
		int totalPrice = 0;
		int rCnt = 0;
		int receiptsRow = receiptsjT.getSelectedRow();
		int price = Integer.parseInt(String.valueOf(receiptsjT.getValueAt(receiptsRow, 2))) ;
		if(rows.length >= 1) {			
			for (int i = 0; i < rows.length; ++i) {
				Refund.updateData(
						0,
						Integer.parseInt(String.valueOf(jT.getValueAt(rows[i] - rCnt, 4))),
						String.valueOf(jT.getValueAt(rows[i] - rCnt, 2)),
						false);
				totalPrice +=  Integer.parseInt(String.valueOf(jT.getValueAt(rows[i] - rCnt, 3)));
				Refund.deleteSalesRows(Integer.parseInt(String.valueOf(jT.getValueAt(rows[i] - rCnt, 0))), 3);
				refundTable.removeRow(rows[i] - rCnt++);
				receiptsjT.setValueAt(price - totalPrice, receiptsRow, 2);
				Refund.updateData(2, totalPrice, String.valueOf(receiptsjT.getValueAt(receiptsRow, 0)), true);
				if (price == totalPrice) {
					Refund.deleteSalesRows(
							Integer.parseInt(String.valueOf(receiptsjT.getValueAt(receiptsRow, 0))), 4);
					receiptsTable.removeRow(receiptsRow);
				}
			}
			if (!phone.equals("null")) {
				Refund.updateData(1, (int)(totalPrice * 0.01), phone, false);
			}			
			JOptionPane.showMessageDialog(refunding, "반품이 완료 되었습니다.");			
		} else {
			JOptionPane.showMessageDialog(refunding, "반품할 목록을 선택해 주세요.");			
		}
	}

}
