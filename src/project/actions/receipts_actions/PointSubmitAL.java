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
	
	public PointSubmitAL(MainFrame main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		pointcollect = (PointCollect)main.getFrame("포인트 적립");
		pPanel = pointcollect.getPanel();
		table = ((Receipts)main.getFrame("영수증")).getJTable();
		
		String text = pPanel.getField().getText();
		String point = pPanel.getLabel2().getText();
		int rid = pointcollect.getRid();
		if (FieldRegexLimit.isValid(Regex.getRegex()[1], text)) {
			PointCollecting.getData(Integer.parseInt(point), rid, text);
			table.setValueAt(pPanel.getField().getText(), table.getSelectedRow(), 1);
		    JOptionPane.showMessageDialog(pointcollect, "포인트 적립이 완료되었습니다.");
			pointcollect.setVisible(false); 
		} else {
			System.out.println("아직 구현안함(전화번호를 입력하세요 / 입력 형식 잘못됨)");
		}
	}

}
