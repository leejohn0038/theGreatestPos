package project.components.receipts_components;

import javax.swing.JCheckBox;

public class CheckBox extends JCheckBox {
	
	public CheckBox(String name, int xPos) {
		super(name);
		setBounds(xPos, 150, 100, 50);
	}
}
