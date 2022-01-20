package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.components.receipts_components.PointCollectPanel;
import project.database.receipts_DB.ReceiptSearching;
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
		JTable jT = ((Receipts)main.getFrame("영수증")).getJTable();
		int index = jT.getSelectedRow();
		if(main.getFrame(btn).isVisible()) {
			JOptionPane.showMessageDialog(main.getFrame("영수증"), "해당 페이지는 이미 열려있습니다.");
		} else if (btn.equals("포인트 적립")) {
			pointAL(jT, index);
		} else if (btn.equals("반품업무")) {
			refundAL(jT, index);
		} else {						
			main.getFrame(btn).setVisible(true);
		}
	}
	
	public void pointAL(JTable jT, int index) {
		PointCollect collect = (PointCollect)main.getFrame("포인트 적립");	
		PointCollectPanel pPanel = collect.getPanel();
		
		if (index > -1) {
			int rid = Integer.parseInt(String.valueOf(jT.getValueAt(index, 0)));
			int cash = Integer.parseInt(String.valueOf(jT.getValueAt(index, 2)));
			String phone = String.valueOf(jT.getValueAt(index, 1));
			if (phone.equals("null")) {		
				collect.setRid(rid);
				pPanel.setLabelText(cash);
				main.getFrame(btn).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(main.getFrame("영수증"), "이미 적립된 영수증 입니다.");
			}
		} else {
			JOptionPane.showMessageDialog(main.getFrame("영수증"), "영수증을 선택해 주세요.");
		}
	} 
	
	public void refundAL(JTable jT, int index) {
		Refunding refunding = (Refunding)main.getFrame("반품업무");
		
		if (index > -1) {
			int rid = Integer.parseInt(String.valueOf(jT.getValueAt(index, 0)));
			String payment = String.valueOf(jT.getValueAt(index, 3));
			String phone = String.valueOf(jT.getValueAt(index, 1));
			String info = ReceiptSearching.getData(0, rid);
			System.out.println(info);
			refunding.setPayment(payment);
			refunding.setPhone(phone);
			refunding.getTable().updateRows(Refund.getData(rid));
			if (payment.equals("현금")) {
				refunding.getCardinfoBtn().setVisible(false);
			} else {
				refunding.setCardinfo(info);
				refunding.getCardinfoBtn().setVisible(true);
			}
			main.getFrame(btn).setVisible(true);			
		} else {
			JOptionPane.showMessageDialog(main.getFrame("영수증"), "영수증을 선택해 주세요.");
		}
	}
}
