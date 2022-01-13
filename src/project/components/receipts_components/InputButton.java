package project.components.receipts_components;

import javax.swing.JButton;

import project.actions.receipts_actions.InputButtonAL;

public class InputButton extends JButton {

	public InputButton(int xPos, int yPos, int xSize, int ySize) {
		super("ют╥б");
		addActionListener(new InputButtonAL());
		setBounds(xPos, yPos, xSize, ySize);
	}
}
