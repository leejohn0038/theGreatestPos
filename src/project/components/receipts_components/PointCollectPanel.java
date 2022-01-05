package project.components.receipts_components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PointCollectPanel extends JPanel {
	
	JLabel cashLabel;
	JTextField cashField;
	JLabel phoneLabel;
	JTextField phoneField;
	
	public PointCollectPanel() {
		cashLabel = new JLabel("금액:");
		cashField = new JTextField();
		phoneLabel = new JLabel("전화번호:");
		phoneField = new JTextField();
		
		setLayout(null);
		setBounds(0, 200, 1000, 300);
		cashLabel.setBounds(200,50, 50, 50);
		cashField.setBounds(300, 50, 200, 50);
		phoneLabel.setBounds(200,120, 100, 50);
		phoneField.setBounds(300, 120, 200, 50);
		
		add(cashField);
		add(cashLabel);
		add(phoneField);
		add(phoneLabel);
	}

}
