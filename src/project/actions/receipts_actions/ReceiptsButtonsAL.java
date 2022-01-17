package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.database.receipts_DB.Refund;
import project.frames.receipts_frames.PointCollect;
import project.frames.receipts_frames.Receipts;
import project.frames.receipts_frames.Refunding;

public class ReceiptsButtonsAL implements ActionListener {
	MainFrame main;
	String btn;
	
	public ReceiptsButtonsAL(MainFrame main, String btn) {
		this.main = main;
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTable jT = ((Receipts)main.getFrame("������")).getJTable();
		int index = jT.getSelectedRow();
		if(main.getFrame(btn).isVisible()) {
			JOptionPane.showMessageDialog(main.getFrame("������"), "�ش� �������� �̹� �����ֽ��ϴ�.");
		} else if (btn.equals("����Ʈ ����")) {
			pointAL(jT, index);
		} else if (btn.equals("��ǰ����")) {
			refundAL(jT, index);
		} else {						
			main.getFrame(btn).setVisible(true);
		}
	}
	
	public void pointAL(JTable jT, int index) {
		PointCollect collect = (PointCollect)main.getFrame("����Ʈ ����");		
		JLabel pLabel1 = collect.getLabel1();
		JLabel pLabel2 = collect.getLabel2();
		
		if (index > -1) {
			int rid = Integer.parseInt(String.valueOf(jT.getValueAt(index, 0)));
			int cash = Integer.parseInt(String.valueOf(jT.getValueAt(index, 2)));
			String phone = String.valueOf(jT.getValueAt(index, 1));
			if (phone.equals("null")) {		
				collect.setRid(rid);
				pLabel1.setText(String.format("%d", cash));
				pLabel2.setText(String.format("%.0f", cash * 0.01));
				main.getFrame(btn).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(main.getFrame("������"), "�̹� ������ ������ �Դϴ�.");
			}
		} else {
			JOptionPane.showMessageDialog(main.getFrame("������"), "�������� ������ �ּ���.");
		}
	} 
	
	public void refundAL(JTable jT, int index) {
		Refunding refunding = (Refunding)main.getFrame("��ǰ����");
		
		if (index > -1) {
			int rid = Integer.parseInt(String.valueOf(jT.getValueAt(index, 0)));
			String payment = String.valueOf(jT.getValueAt(index, 3));
			refunding.setPayment(payment);
			refunding.getTable().updateRow(Refund.getData(rid));
			main.getFrame(btn).setVisible(true);			
		} else {
			JOptionPane.showMessageDialog(main.getFrame("������"), "�������� ������ �ּ���.");
		}
	}
}
