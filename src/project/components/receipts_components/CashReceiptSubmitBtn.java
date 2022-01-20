package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.CashReceiptSubmitAL;

public class CashReceiptSubmitBtn extends JButton {
	
	public CashReceiptSubmitBtn(MainFrame main) {
		super("½ÂÀÎ");
		addActionListener(new CashReceiptSubmitAL(main));
		setBounds(150, 150, 70, 30);
	}
	

}
