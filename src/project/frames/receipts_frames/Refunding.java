package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.receipts_components.RefundingPanel;
import project.components.receipts_components.RefundingSubmitBtn;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;

public class Refunding extends JFrame {
	private Tables table;
	private String payment;
	
	public Refunding(MainFrame main) {
		add(new Toppanel("��ǰ����"));
		add(table = new Tables(
				new String[] {"�Ǹ�ID","������ID", "��ǰ", "����", "����", "��������"}, 
				100, 100, 680, 200));
		add(new RefundingPanel(main));
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
	
	public void setPayment(String payment) {
		this.payment = payment;
	}
}
