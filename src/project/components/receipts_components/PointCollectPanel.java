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
	
	public void setLabelText(int price) {
		pLabel1.setText(String.valueOf(price));
		pLabel2.setText(String.valueOf((int)(price * 0.01)));
	}
}
