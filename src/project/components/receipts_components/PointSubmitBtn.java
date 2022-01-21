package project.components.receipts_components;

import javax.swing.ImageIcon;

import project.MainFrame;
import project.actions.receipts_actions.PointSubmitAL;
import project.components.goods_components.BasicSmallButton;

public class PointSubmitBtn extends BasicSmallButton {
	
	PointSubmitAL pAL;
	
	public PointSubmitBtn(MainFrame main, ImageIcon img, int xPos, int yPos, int xSize, int ySize) {
		super(img);
		addActionListener(pAL = new PointSubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
	
}
