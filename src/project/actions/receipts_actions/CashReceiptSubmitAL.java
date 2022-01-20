package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.MainFrame;
import project.database.receipts_DB.Cashrcp;
import project.frames.receipts_frames.CashReceipt;

public class CashReceiptSubmitAL implements ActionListener {

	MainFrame main;
	String text;
	
	public CashReceiptSubmitAL(MainFrame main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		CashReceipt cashrcp = (CashReceipt)main.getFrame("현금 영수증");
		text = cashrcp.getField().getText();
		if (FieldRegexLimit.isValid(Regex.getRegex()[1], text)) {
			JOptionPane.showMessageDialog(cashrcp, "현금영수증이 발급되었습니다.");
			Cashrcp.updateCashrcp();
			cashrcp.setVisible(false);
		}
		
	}
	
	public String getText() {
		return text;
	}

}
