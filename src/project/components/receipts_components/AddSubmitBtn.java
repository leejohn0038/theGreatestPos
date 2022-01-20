package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.AddSubmitAL;

public class AddSubmitBtn extends JButton {

	public AddSubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		super("µî·Ï");
		addActionListener(new AddSubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
	
}
