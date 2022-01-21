package project.components.receipts_components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.SaleSubmitAL;

public class SaleSubmitBtn extends JButton {
	
	public SaleSubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		setIcon(new ImageIcon("./image/main/add_goods240.png"));
		addActionListener(new SaleSubmitAL(main));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setBounds(xPos, yPos, xSize, ySize);
	}
}
