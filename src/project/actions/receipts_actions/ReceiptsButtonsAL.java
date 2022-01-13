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
		JLabel pLabel1 = ((PointCollect)main.getFrame("����Ʈ ����")).getLabel1();
		JLabel pLabel2 = ((PointCollect)main.getFrame("����Ʈ ����")).getLabel2();
		JTable jT = ((Receipts)main.getFrame("������")).getJTable();
		int index = jT.getSelectedRow();
		
		if (btn == "����Ʈ ����" && 
				pLabel1.getText().equals("")) {
			if (index > -1) {
				int cash = Integer.parseInt(String.valueOf(jT.getValueAt(index, 2)));
				System.out.println(cash);
				pLabel1.setText(String.format("%d", cash));
				pLabel2.setText(String.format("%.0f", cash * 0.01));
				
				main.getFrame(btn).setVisible(true);
 			} else {
 				System.out.println("���� ���� ����");
 			}
		} else {			
			main.getFrame(btn).setVisible(true);
		}
	}
}
