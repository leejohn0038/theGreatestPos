package project.frames.receipts_frames;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.MainFrame;
import project.components.receipts_components.Label;
import project.components.receipts_components.PointCollectPanel;
import project.components.receipts_components.PointSubmitBtn;
import project.components.receipts_components.TextField;

public class PointCollect extends JFrame {
	PointCollectPanel pPanel;
	JLabel pLabel1;
	JLabel pLabel2;
	JTextField pField;
	int rid;
	PointSubmitBtn pBtn;
	
	public PointCollect(MainFrame main) {
		add(new Label("포인트 적립", 50, 0, 150, 70) {{setFont(new Font("기본", Font.BOLD, 20));}});
		add(new Label("금액:", 50, 70, 70, 30));
		add(pLabel1 = new Label("", 120, 70, 150, 30));
		add(new Label("적립금액:", 50, 110, 70, 30));
		add(pLabel2 = new Label("", 120, 110, 150, 30));
		add(new Label("전화번호:", 50, 160, 70, 30));
		add(pField = new TextField(120, 160, 200, 30));
		add(pBtn = new PointSubmitBtn(main, 200, 300, 100, 50));
		
		setLayout(null);
		setBounds(300, 300, 500, 400);
		setVisible(false);
		setResizable(false);
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
	
	public void setRid(int rid) {
		this.rid = rid;
	} 

	public int getRid() {
		return rid;
	}
	
	public void setLabelText(int price) {
		pLabel1.setText(String.valueOf(price));
		pLabel2.setText(String.valueOf((int)(price * 0.01)));
	}
}
