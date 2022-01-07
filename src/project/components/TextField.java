package project.components;

import javax.swing.JTextField;

public class TextField extends JTextField {
	
	public TextField(int xPos, int yPos, int xSize, int ySize) {
		setBounds(xPos, yPos, xSize, ySize);
	}
}
