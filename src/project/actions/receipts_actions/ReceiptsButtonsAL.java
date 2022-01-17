package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTable;

import project.MainFrame;
import project.frames.receipts_frames.PointCollect;
import project.frames.receipts_frames.Receipts;

public class ReceiptsButtonsAL implements ActionListener {
	MainFrame main;
	String btn;
	
	public ReceiptsButtonsAL(MainFrame main, String btn) {
		this.main = main;
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PointCollect collect = (PointCollect)main.getFrame("����Ʈ ����");		
		if (btn == "����Ʈ ����" && 
				collect.getLabel1().getText().equals("")) {
			pointAL(collect);
		} else {			
			main.getFrame(btn).setVisible(true);
		}
	}
	
	public void pointAL(PointCollect collect) {
		JLabel pLabel1 = collect.getLabel1();
		JLabel pLabel2 = collect.getLabel2();
		JTable jT = ((Receipts)main.getFrame("������")).getJTable();
		int index = jT.getSelectedRow();
		
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
				System.out.println("���� ���� ����(�̹� ������ �������Դϴ� )");
			}
		} else {
			System.out.println("���� ���� ����(�������� �������ּ���)");
		}
	} 
}
