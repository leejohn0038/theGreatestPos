package project.frames.receipts_frames;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import project.MainFrame;
import project.components.receipts_components.FrameButton;
import project.components.receipts_components.Label;
import project.components.receipts_components.RefundingPanel;
import project.components.receipts_components.RefundingSubmitBtn;
import project.components.receipts_components.Tables;

public class Refunding extends JFrame {
	private Tables table;
	private String payment;
	private String phone;
	private String cardinfo;
	private RefundingPanel refundPanel;
	private FrameButton cardinfoBtn;
	private boolean cardrefund;
	
	public Refunding(MainFrame main) {
		add(new Label("��ǰ", 50, 0, 150, 50) {{setFont(new Font("�⺻", Font.BOLD, 30));}});
		add(table = new Tables(
				new String[] {"�Ǹ�ID","������ID", "��ǰ", "����", "����", "��������"}, 
				5, 100, 680, 200));
//		add(refundPanel = new RefundingPanel(main));
		add(cardinfoBtn = new FrameButton(main, "ī�������Է�", 500, 350, 130, 50));
		add(new RefundingSubmitBtn(main, 300, 350, 100, 50));
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setVisible(false);
		setResizable(false);
	}
	
	public Tables getTable() {
		return table;
	}
	
	public JTable getJTable() {
		return table.getTable();
	}
	
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getPayment() {
		return payment;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public JLabel[] getLabels() {
		return refundPanel.getLabels();
	}
	
	public FrameButton getCardinfoBtn() {
		return cardinfoBtn;
	}
	
	public void setCardinfo(String cardinfo) {
		this.cardinfo = cardinfo;
	} 
	
	public String getCardinfo() {
		return cardinfo;
	}
	
	public void setCardrefund(boolean state) {
		cardrefund = state;
	}
	
	public boolean getCardrefund() {
		return cardrefund;
	}
}
