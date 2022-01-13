package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.ReceiptsButtonsAL;

public class Button extends JButton {
	
	public Button(MainFrame main, String txt, int xPos, int yPos, int xSize, int ySize) {
		super(txt);
		addActionListener(new ReceiptsButtonsAL(main, txt));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
