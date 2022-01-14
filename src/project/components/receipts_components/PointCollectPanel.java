package project.components.receipts_components;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.frames.receipts_frames.ReceiptSearch;

public class PointCollectPanel extends JPanel {
	private JTextField pField;
	private JLabel pLabel1;
	private JLabel pLabel2;
	
	public PointCollectPanel() {
		
		setLayout(null);
		setBounds(0, 200, 1000, 300);
		add(new Label("금액:", 200, 50, 70, 30));
		add(pLabel1 = new Label("", 300, 50, 150, 30));
		add(new Label("적립금액:", 200, 80, 70, 30));
		add(pLabel2 = new Label("", 300, 80, 150, 30));
		add(new Label("전화번호:", 200, 120, 100, 30));
		add(pField = new TextField(300, 120, 200, 30));
	}
	
	public JTextField getField() {
		return pField;
	}
	
	public JLabel getLabel1() {
		return pLabel1;
	}
	
	public JLabel getLabel2() {
		return pLabel2;
	}
}
