package project.components.receipts_components;

import javax.swing.ImageIcon;

import project.MainFrame;
import project.actions.receipts_actions.RefundingSubmitAL;
import project.components.goods_components.BasicSmallButton;

public class RefundingSubmitBtn extends BasicSmallButton{ 
	
	public RefundingSubmitBtn(MainFrame main, ImageIcon img, int xPos, int yPos, int xSize, int ySize) {
		super(img);
		addActionListener(new RefundingSubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}

}
