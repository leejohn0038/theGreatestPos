package project.components.receipts_components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.DeleteAL;

public class DeleteBtn extends JButton {
	
	public DeleteBtn(MainFrame main) {
		setIcon(new ImageIcon("./image/main/delete_goods.png"));
		addActionListener(new DeleteAL(main));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setBounds(230, 590, 100, 100);
	}
}
