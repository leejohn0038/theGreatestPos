package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.database.receipts_DB.Buying;
import project.database.receipts_DB.Refund;
import project.frames.receipts_frames.PointCollect;
import project.frames.receipts_frames.PrintedRcp;

public class BuySubmitAL implements ActionListener{
	
	MainFrame main; 
	Values values = new Values();
	boolean collected;
	
	public BuySubmitAL(MainFrame main) {
		this.main = main;
	}

	public void actionPerformed(ActionEvent e) {
		JTable jT = main.getJTable();
		PointCollect collect = (PointCollect)main.getFrame("포인트 적립");
		boolean isEnough = true;
		HashMap<Integer, String[]> sales = new HashMap<>();
		if(jT.getRowCount() > 0) {
			for (int i = 0; i < jT.getRowCount(); ++i) {
				String gName = jT.getValueAt(i, 1).toString();
				String price = jT.getValueAt(i, 3).toString();
				int qty = Integer.parseInt(jT.getValueAt(i, 2).toString());
				if(qty > Buying.getGqty(gName)) {
					System.out.println(qty);
					JOptionPane.showMessageDialog(main, "물품수량이 수량이 부족합니다.");
					isEnough = false;
					break;
				} else {
					sales.put(i, new String[] {gName, String.valueOf(qty), price});
				}
			}
			if (isEnough) {
				values.date = LocalDate.now().toString();
				values.payment = main.getCombo();
				values.rid = Buying.getMaxId(0) > 0 ? Buying.getMaxId(0) + 1 : 1;
				values.price = main.getTotalPrice();
				values.eid = main.loginID();
				values.cardinfo = null;
				values.cashrcp = null;
				if(values.payment.equals("카드")) {
					String cardinfo = JOptionPane.showInputDialog(main, "카드번호 입력");
					if(cardinfo == null) {
						JOptionPane.showMessageDialog(main, "카드번호가 입력되지 않았습니다.");
					} else {
						values.cardinfo = cardinfo;
						printRcp();
						collecting(collect);
					}
				} else {
					printRcp(); 
					collecting(collect);
				}
				
				
				Buying.insertReceiptDatas(values);
				Buying.updateSaleDatas(sales, values);
			} 
		} else {
			JOptionPane.showMessageDialog(main, "구매할 물건이 없습니다.");
		} 
	}
	
	public void collecting(PointCollect collect) {
		int point = JOptionPane.showConfirmDialog(
				main, "포인트를 적립하겠습니까?", "point", JOptionPane.YES_NO_OPTION);
		if (point == JOptionPane.YES_OPTION) {
			collect.setLabelText(values.price);
			collect.setVisible(true);
			collect.setRid(values.rid);
		} else {
			JOptionPane.showMessageDialog(main, "결제가 완료되었습니다.");
			main.getTable().removeRows();
			if (main.getPrint() ) {
				new PrintedRcp(Refund.getSalesData(values.rid));
			}
		}
	}
	
	public void printRcp() {
		int rcp = JOptionPane.showConfirmDialog(
				main, "영수증을 출력하겠습니까?", "receipt", JOptionPane.YES_NO_OPTION);
		if (rcp == JOptionPane.YES_OPTION) {
			main.setPrint(true);
			main.setRid(values.rid);
		} else {
			main.setPrint(false);
		}
		
	}
}