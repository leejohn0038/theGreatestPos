package project.frames.receipts_frames;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

import project.MainFrame;
import project.components.receipts_components.AddSubmitBtn;
import project.components.receipts_components.Label;
import project.components.receipts_components.ReceiptsBtnImg;
import project.components.receipts_components.TextField;

public class AddCustomer extends JFrame{
	
	JTextField[] fields = new JTextField[3];
	
	public AddCustomer(MainFrame main) {
		add(new Label("이름:", 20, 20, 70, 30));
		add(fields[0] = new TextField(90, 20, 150, 30));
		add(new Label("전화번호:", 20, 60, 70, 30));
		add(fields[1] = new TextField(90, 60, 150, 30));
		add(new Label("주소:", 20, 100, 70, 30));
		add(fields[2] = new TextField(90, 100, 200, 30));
		add(new AddSubmitBtn(main, ReceiptsBtnImg.getIcon("승인", 75, 20), 162, 150, 75, 20));
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(false);
		setBounds(600, 200, 399, 230);
		setResizable(false);
	}
	
	public JTextField[] getFields() {
		return fields;
	}
}
