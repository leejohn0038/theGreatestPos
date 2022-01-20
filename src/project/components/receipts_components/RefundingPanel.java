package project.components.receipts_components;



import javax.swing.JLabel;
import javax.swing.JPanel;

import project.MainFrame;

public class RefundingPanel extends JPanel {
	
	JLabel[] labels = new JLabel[2];
	
	public RefundingPanel(MainFrame main) {
		setLayout(null);
		setBounds(0, 300, 700, 100);
		
//		add(new Label("금액:", 100, 20, 50, 30));
//		add(labels[0] = new  Label("", 150, 20, 150, 30));
//		add(new Label("포인트:", 100, 50, 50, 30));
//		add(labels[1] = new Label("", 150, 50, 150, 30));
	}
	
	public JLabel[] getLabels() {
		return labels;
	}
}
