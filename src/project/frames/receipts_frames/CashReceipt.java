package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.components.receipts_components.CashReceiptPanel;
import project.components.receipts_components.Toppanel;

public class CashReceipt extends JFrame {

	public CashReceipt() {
		add(new Toppanel("현금 영수증"));
		add(new CashReceiptPanel());
		//add(new SubmitBtn(450, 500, 100, 50));
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	} 
}
