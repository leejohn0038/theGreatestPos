package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.MainFrame;
import project.components.receipts_components.PointCollectPanel;
import project.database.receipts_DB.PointCollecting;
import project.frames.receipts_frames.PointCollect;
import project.frames.receipts_frames.Receipts;

public class PointSubmitAL implements ActionListener {
	MainFrame main;
	PointCollect pointcollect;
	PointCollectPanel pPanel;
	JTable table;
	boolean state;
	
	public PointSubmitAL(MainFrame main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		pointSubmitAL();
	}
	
	public void pointSubmitAL() {
		pointcollect = (PointCollect)main.getFrame("포인트 적립");
		pPanel = pointcollect.getPanel();
		table = ((Receipts)main.getFrame("영수증")).getJTable();
		
		String text = pPanel.getField().getText();
		String point = pPanel.getLabel2().getText();
		int rid = pointcollect.getRid();
		if (FieldRegexLimit.isValid(Regex.getRegex()[1], text)) {
			if(PointCollecting.updateData(Integer.parseInt(point), rid, text)) {		
				if (main.getFrame("영수증").isVisible()) {					
					table.setValueAt(text, table.getSelectedRow(), 1);
				} 
				JOptionPane.showMessageDialog(pointcollect, "포인트 적립이 완료되었습니다.");
				pointcollect.setVisible(false); 
			} else {				
				int result = JOptionPane.showConfirmDialog(
					pointcollect, "존재하지 않는 회원입니다.\n회원가입 하시겠습니까?","confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					main.getFrame("고객등록").setVisible(true);
				}
			}
		} else if(text.equals("")){
			JOptionPane.showMessageDialog(main.getFrame("영수증"), "전화번호를 입력하세요.");
		} else {
			JOptionPane.showMessageDialog(pointcollect, "입력형식이 잘못되었습니다.");
		}
	}

}
