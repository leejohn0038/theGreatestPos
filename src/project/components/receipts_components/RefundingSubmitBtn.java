package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.RefundingSubmitAL;

public class RefundingSubmitBtn extends JButton { 
	
	public RefundingSubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		super("È¯ºÒ");
		addActionListener(new RefundingSubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}

}
