package project.frames.receipts_frames;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

import project.MainFrame;
import project.components.receipts_components.CardInfoSubmitBtn;
import project.components.receipts_components.Label;
import project.components.receipts_components.ReceiptsBtnImg;
import project.components.receipts_components.TextField;

public class CardInfo extends JFrame {	
	private JTextField field;
	
	public CardInfo(MainFrame main) {
		add(new Label("카드번호:", 20, 50, 70, 30));
		add(field = new TextField(90, 50, 150, 30));
		add(new CardInfoSubmitBtn(main,ReceiptsBtnImg.getIcon("승인", 75, 20),  110, 100, 75, 20));
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(false);
		setBounds(600, 200, 300, 200);
	}
	
	public JTextField getField() {
		return field;
	}
}
