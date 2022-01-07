package project.components;

import javax.swing.JButton;

public class Button extends JButton {
	
	public Button(String txt, int xPos, int yPos, int xSize, int ySize) {
		super(txt);
		setBounds(xPos, yPos, xSize, ySize);
	}
}
