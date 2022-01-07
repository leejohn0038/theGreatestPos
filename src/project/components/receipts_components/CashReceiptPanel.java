package project.components.receipts_components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CashReceiptPanel extends JPanel {
	JTextField field;
	JLabel label;
	
	public CashReceiptPanel() {
		label = new JLabel("전화번호:");
		field = new JTextField();
		
		setLayout(null);
		setBounds(0, 200, 1000, 200);
		label.setBounds(200,50, 100, 50);
		field.setBounds(350, 50, 200, 50);
		
		add(field);
		add(label);
		add(new CheckBox("개인", 275));
		add(new CheckBox("사업자", 400));
	}
}
