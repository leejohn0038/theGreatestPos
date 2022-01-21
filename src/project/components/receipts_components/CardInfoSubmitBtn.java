package project.components.receipts_components;

import javax.swing.ImageIcon;

import project.MainFrame;
import project.actions.receipts_actions.CardInfoAL;
import project.components.goods_components.BasicSmallButton;

public class CardInfoSubmitBtn extends BasicSmallButton {
	
	public CardInfoSubmitBtn(MainFrame main, ImageIcon img, int xPos, int yPos, int xSize, int ySize) {
		super(img);
		addActionListener(new CardInfoAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}

}
