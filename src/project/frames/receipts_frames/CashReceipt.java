package project.frames.receipts_frames;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

import project.MainFrame;
import project.components.receipts_components.CashReceiptSubmitBtn;
import project.components.receipts_components.Label;
import project.components.receipts_components.TextField;

public class CashReceipt extends JFrame {

	JTextField field;
	
	public CashReceipt(MainFrame main) {
		add(new Label("현금영수증", 50, 0, 150, 70) {{setFont(new Font("기본", Font.BOLD, 20));}});
		add(new Label("전화번호:", 50, 70, 70, 30));
		add(field = new TextField(130, 70, 150, 30));
		add(new CashReceiptSubmitBtn(main));
		
		setLayout(null);
		setBounds(300, 300, 400, 250);
		setVisible(false);
		setResizable(false);
	} 
	
	public JTextField getField() {
		return field;
	}
}
