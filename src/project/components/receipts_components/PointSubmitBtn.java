package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.PointSubmitAL;

public class PointSubmitBtn extends JButton {
	
	PointSubmitAL pAL;
	
	public PointSubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		super("Àû¸³");
		addActionListener(pAL = new PointSubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
	
}
