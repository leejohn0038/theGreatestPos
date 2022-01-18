package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.BuySubmitAL;

public class BuySubmitBtn extends JButton {
	
	public BuySubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		super("°è»ê");
		addActionListener(new BuySubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
