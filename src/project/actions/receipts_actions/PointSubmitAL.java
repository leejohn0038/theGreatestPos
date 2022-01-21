package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.components.receipts_components.PointCollectPanel;
import project.database.receipts_DB.PointCollecting;
import project.database.receipts_DB.Refund;
import project.frames.receipts_frames.PointCollect;
import project.frames.receipts_frames.PrintedRcp;
import project.frames.receipts_frames.Receipts;

public class PointSubmitAL implements ActionListener {
	MainFrame main;
	PointCollect pointcollect;
	JTable table;
	boolean state;
	
	public PointSubmitAL(MainFrame main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		pointSubmitAL();
	}
	
	public void pointSubmitAL() {
		pointcollect = (PointCollect)main.getFrame("����Ʈ ����");
		table = ((Receipts)main.getFrame("������")).getJTable();
		
		String text = pointcollect.getField().getText();
		String point = pointcollect.getLabel2().getText();
		int rid = pointcollect.getRid();
		if (FieldRegexLimit.isValid(Regex.getRegex()[1], text)) {
			if(PointCollecting.updateData(Integer.parseInt(point), rid, text)) {		
				JOptionPane.showMessageDialog(pointcollect, "����Ʈ ������ �Ϸ�Ǿ����ϴ�.");
				pointcollect.setVisible(false); 
				if (main.getFrame("������").isVisible()) {					
					table.setValueAt(text, table.getSelectedRow(), 1);
				} else if(main.isVisible()) {
					main.getTable().removeRows();
					JOptionPane.showMessageDialog(main, "������ �Ϸ�Ǿ����ϴ�.");
					if (main.getPrint()) {
						new PrintedRcp(Refund.getSalesData(main.getRid()));
					} 
				}
			} else {				
				int result = JOptionPane.showConfirmDialog(
					pointcollect, "�������� �ʴ� ȸ���Դϴ�.\nȸ������ �Ͻðڽ��ϱ�?","confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					main.getFrame("�����").setVisible(true);
				}
			}
		} else if(text.equals("")){
			JOptionPane.showMessageDialog(pointcollect, "��ȭ��ȣ�� �Է��ϼ���.");
		} else {
			JOptionPane.showMessageDialog(pointcollect, "�Է������� �߸��Ǿ����ϴ�.");
		}
	}

}
