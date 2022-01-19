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
		PointCollect collect = (PointCollect)main.getFrame("����Ʈ ����");
		boolean isEnough = true;
		if(jT.getRowCount() > 0) {
			for (int i = 0; i < jT.getRowCount(); ++i) {
				String gName = jT.getValueAt(i, 1).toString();
				int qty = Integer.parseInt(jT.getValueAt(i, 3).toString());
				if(qty > Buying.getGqty(gName)) {
					JOptionPane.showMessageDialog(main, "��ǰ������ ������ �����մϴ�.");
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
				if(values.payment.equals("ī��")) {
					String cardinfo = JOptionPane.showInputDialog(main, "ī���ȣ �Է�");
					if(cardinfo == null) {
						JOptionPane.showMessageDialog(main, "ī���ȣ�� �Էµ��� �ʾҽ��ϴ�.");
					} else {
						values.cardinfo = cardinfo;
						int point = JOptionPane.showConfirmDialog(
								main, "����Ʈ�� �����ϰڽ��ϱ�?", "confirm", JOptionPane.YES_NO_OPTION);
						if (point == JOptionPane.YES_OPTION) {
							collect.getPanel().setLabelText(values.price);
							collect.setVisible(true);
							collect.setRid(values.id);
						}
					}
				} else {
					System.out.println("����");
				}
				Buying.insertReceiptDatas(values);
			} 
		} else {
			System.out.println("���� ����");
		} 
	}
}