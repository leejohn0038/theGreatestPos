
package project.components.receipts_components;

import javax.swing.JButton;

import project.actions.BackButtonAL;

public class BackButton extends JButton {
	
	public BackButton() {
		super("<");
		addActionListener(new BackButtonAL());
		setBounds(10, 20, 50, 40);
	}
}
