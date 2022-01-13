package project.frames.receipts_frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.components.receipts_components.PointCollectPanel;
import project.components.receipts_components.PointSubmitBtn;
import project.components.receipts_components.Toppanel;

public class PointCollect extends JFrame {
	PointCollectPanel pPanel;
	
	public PointCollect() {
		add(new Toppanel("포인트 적립"));
		add(pPanel = new PointCollectPanel());
		add(new PointSubmitBtn(pPanel, 450, 500, 100, 50));
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
	
	public JTextField getField() {
		return pPanel.getField();
	}
	
	public JLabel getLabel1() {
		return pPanel.getLabel1();
	}

	public JLabel getLabel2() {
		return pPanel.getLabel2();
	}
	
	public static void main(String[] args) {
		new PointCollect();
	}
}
