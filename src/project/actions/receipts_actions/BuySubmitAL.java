package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.database.receipts_DB.Buying;
import project.frames.receipts_frames.PointCollect;

public class BuySubmitAL implements ActionListener{
	
	MainFrame main; 
	
	public BuySubmitAL(MainFrame main) {
		this.main = main;
	}

	public void actionPerformed(ActionEvent e) {
		JTable jT = main.getJTable();
		Values values = new Values();
		PointCollect collect = (PointCollect)main.getFrame("포인트 적립");
		boolean isEnough = true;
		if(jT.getRowCount() > 0) {
			for (int i = 0; i < jT.getRowCount(); ++i) {
				String gName = jT.getValueAt(i, 1).toString();
				int qty = Integer.parseInt(jT.getValueAt(i, 3).toString());
				if(qty > Buying.getGqty(gName)) {
					JOptionPane.showMessageDialog(main, "물품수량이 수량이 부족합니다.");
					isEnough = false;
					break;
				}
			}
			if (isEnough) {
				values.date = LocalDate.now().toString();
				values.payment = main.getCombo();
				values.id = Buying.getMaxId() > 0 ? Buying.getMaxId() + 1 : 1;
				values.price = main.getTotalPrice();
				values.cardinfo = null;
				if(values.payment.equals("카드")) {
					String cardinfo = JOptionPane.showInputDialog(main, "카드번호 입력");
					if(cardinfo == null) {
						JOptionPane.showMessageDialog(main, "카드번호가 입력되지 않았습니다.");
					} else {
						values.cardinfo = cardinfo;
						int point = JOptionPane.showConfirmDialog(
								main, "포인트를 적립하겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
						if (point == JOptionPane.YES_OPTION) {
							collect.getPanel().setLabelText(values.price);
							collect.setVisible(true);
							collect.setRid(values.id);
						}
					}
				} else {
					System.out.println("현금");
				}
				Buying.insertReceiptDatas(values);
			} 
		} else {
			System.out.println("물건 없음");
		} 
	}
}