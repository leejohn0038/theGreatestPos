package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.database.receipts_DB.Buying;
import project.frames.receipts_frames.PointCollect;

public class BuySubmitAL implements ActionListener{
	
	MainFrame main; 
	Values values = new Values();
	
	public BuySubmitAL(MainFrame main) {
		this.main = main;
	}

	public void actionPerformed(ActionEvent e) {
		JTable jT = main.getJTable();
		PointCollect collect = (PointCollect)main.getFrame("����Ʈ ����");
		boolean isEnough = true;
		HashMap<Integer, String[]> sales = new HashMap<>();
		if(jT.getRowCount() > 0) {
			for (int i = 0; i < jT.getRowCount(); ++i) {
				String gName = jT.getValueAt(i, 1).toString();
				String price = jT.getValueAt(i, 3).toString();
				int qty = Integer.parseInt(jT.getValueAt(i, 2).toString());
				if(qty > Buying.getGqty(gName)) {
					System.out.println(qty);
					JOptionPane.showMessageDialog(main, "��ǰ������ ������ �����մϴ�.");
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
				if(values.payment.equals("ī��")) {
					String cardinfo = JOptionPane.showInputDialog(main, "ī���ȣ �Է�");
					if(cardinfo == null) {
						JOptionPane.showMessageDialog(main, "ī���ȣ�� �Էµ��� �ʾҽ��ϴ�.");
					} else {
						values.cardinfo = cardinfo;
						collecting(collect);
					}
				} else {
					System.out.println("����");
					collecting(collect);
				}
				Buying.insertReceiptDatas(values);
				Buying.updateSaleDatas(sales, values);
				// oracle���� ������ ���� ������ ����
//				Buying.updateGqty(sales);
				
			} 
		} else {
			JOptionPane.showMessageDialog(main, "������ ������ �����ϴ�.");
		} 
	}
	
	public void collecting(PointCollect collect) {
		int point = JOptionPane.showConfirmDialog(
				main, "����Ʈ�� �����ϰڽ��ϱ�?", "confirm", JOptionPane.YES_NO_OPTION);
		if (point == JOptionPane.YES_OPTION) {
			collect.getPanel().setLabelText(values.price);
			collect.setVisible(true);
			collect.setRid(values.rid);
		}
	}
}