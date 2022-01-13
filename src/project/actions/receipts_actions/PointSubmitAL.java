package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.components.receipts_components.PointCollectPanel;

public class PointSubmitAL implements ActionListener {
	PointCollectPanel pPanel;
	
	public PointSubmitAL(PointCollectPanel pPanel) {
		this.pPanel = pPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (FieldRegexLimit.isValid(Regex.getRegex()[1], pPanel.getField().getText())) {
			
		} else {
			System.out.println("hello");
		}
	}

}
