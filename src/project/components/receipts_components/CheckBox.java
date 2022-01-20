package project.components.receipts_components;

import javax.swing.JCheckBox;

public class CheckBox extends JCheckBox {
	
	public CheckBox(String name, boolean isCheck, int xPos, int yPos) {
		super(name, isCheck);
		addItemListener(itemListener);
		setBounds(xPos, yPos, 100, 50);
	}
}
