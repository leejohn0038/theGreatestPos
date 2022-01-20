package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.SaleSubmitAL;

public class SaleSubmitBtn extends JButton {
	
	public SaleSubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		super("±¸¸Å");
		addActionListener(new SaleSubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
