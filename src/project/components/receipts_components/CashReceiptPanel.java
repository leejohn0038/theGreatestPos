package project.components.receipts_components;


import javax.swing.JPanel;

import project.components.Label;
import project.components.TextField;

public class CashReceiptPanel extends JPanel {

	public CashReceiptPanel() {
		setLayout(null);
		setBounds(0, 200, 1000, 200);
		
		add(new TextField(350, 50, 200, 50));
		add(new Label("��ȭ��ȣ:", 200,50, 100, 50));
		add(new CheckBox("����", 275));
		add(new CheckBox("�����", 400));
	}
}
