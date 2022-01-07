package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.components.Toppanel;
import project.components.receipts_components.CashReceiptPanel;
import project.components.receipts_components.SubmitBtn;

public class CashReceipt extends JFrame {

	public CashReceipt() {
		add(new Toppanel("현금 영수증"));
		add(new CashReceiptPanel());
		add(new SubmitBtn());
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new CashReceipt();
	}
}
