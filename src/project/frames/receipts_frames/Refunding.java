package project.frames.receipts_frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import project.MainFrame;
import project.components.receipts_components.FrameButton;
import project.components.receipts_components.RefundingPanel;
import project.components.receipts_components.RefundingSubmitBtn;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;

public class Refunding extends JFrame {
	private Tables table;
	private String payment;
	private String phone;
	private String cardinfo;
	private RefundingPanel refundPanel;
	private FrameButton cardinfoBtn;
	private boolean cardrefund;
	
	public Refunding(MainFrame main) {
		add(new Toppanel("반품업무"));
		add(table = new Tables(main,
				new String[] {"판매ID","영수증ID", "상품", "가격", "수량", "결제수단"}, 
				100, 100, 680, 200));
		add(refundPanel = new RefundingPanel(main));
		add(cardinfoBtn = new FrameButton(main, "카드정보입력", 650, 400, 130, 50));
		add(new RefundingSubmitBtn(main, 450, 550, 100, 50));
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
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
