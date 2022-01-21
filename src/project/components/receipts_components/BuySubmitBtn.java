package project.components.receipts_components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.BuySubmitAL;

public class BuySubmitBtn extends JButton {
	
	public BuySubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		setIcon(new ImageIcon("./image/main/quantify.png"));
		addActionListener(new BuySubmitAL(main));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setBounds(xPos, yPos, xSize, ySize);
	}
}
