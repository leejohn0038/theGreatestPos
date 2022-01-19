package project.frames.receipts_frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.MainFrame;
import project.components.receipts_components.PointCollectPanel;
import project.components.receipts_components.PointSubmitBtn;
import project.components.receipts_components.Toppanel;

public class PointCollect extends JFrame {
	PointCollectPanel pPanel;
	int rid;
	PointSubmitBtn pBtn;
	
	public PointCollect(MainFrame main) {
		add(new Toppanel("����Ʈ ����"));
		add(pPanel = new PointCollectPanel());
		add(pBtn = new PointSubmitBtn(main, 450, 500, 100, 50));
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
	
	public PointCollectPanel getPanel() {
		return pPanel;
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
	
	public void setRid(int rid) {
		this.rid = rid;
	} 

	public int getRid() {
		return rid;
	}
}
