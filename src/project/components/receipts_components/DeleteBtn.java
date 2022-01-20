package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.DeleteAL;

public class DeleteBtn extends JButton {
	
	public DeleteBtn(MainFrame main) {
		super("ªË¡¶");
		addActionListener(new DeleteAL(main));
		setBounds(910, 500, 70, 30);
	}
}
