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
		JLabel pLabel1 = ((PointCollect)main.getFrame("포인트 적립")).getLabel1();
		JLabel pLabel2 = ((PointCollect)main.getFrame("포인트 적립")).getLabel2();
		JTable jT = ((Receipts)main.getFrame("영수증")).getJTable();
		int index = jT.getSelectedRow();
		
		if (btn == "포인트 적립" && 
				pLabel1.getText().equals("")) {
			if (index > -1) {
				int cash = Integer.parseInt(String.valueOf(jT.getValueAt(index, 2)));
				System.out.println(cash);
				pLabel1.setText(String.format("%d", cash));
				pLabel2.setText(String.format("%.0f", cash * 0.01));
				
				main.getFrame(btn).setVisible(true);
 			} else {
 				System.out.println("아직 구현 안함");
 			}
		} else {			
			main.getFrame(btn).setVisible(true);
		}
	}
}
