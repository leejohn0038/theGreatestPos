package project.components.receipts_components;

import javax.swing.JLabel;

public class Label extends JLabel {
	
	public Label(String txt, int xPos, int yPos, int xSize, int ySize) {
		super(txt);
		setBounds(xPos, yPos, xSize, ySize);
	}
}
