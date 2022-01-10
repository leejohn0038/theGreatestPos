package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.components.receipts_components.RefundingPanel;
import project.components.receipts_components.SubmitBtn;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;

public class Refunding extends JFrame {

	public Refunding() {
		add(new Toppanel("��ǰ����"));
		add(new Tables(
				new String[] {"������ID", "���Žñ�", "����", "��������"}, 
				100, 100, 200));
		add(new RefundingPanel());
		add(new SubmitBtn());
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
}
