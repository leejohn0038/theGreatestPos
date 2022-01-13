package project.components.receipts_components;

import javax.swing.JButton;

import project.actions.receipts_actions.PointSubmitAL;

public class PointSubmitBtn extends JButton {
	
	public PointSubmitBtn(PointCollectPanel pPanel, int xPos, int yPos, int xSize, int ySize) {
		super("Àû¸³");
		addActionListener(new PointSubmitAL(pPanel));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
