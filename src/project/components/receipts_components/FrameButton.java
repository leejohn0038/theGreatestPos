package project.components.receipts_components;

import javax.swing.ImageIcon;

import project.MainFrame;
import project.actions.receipts_actions.ReceiptsButtonsAL;
import project.components.goods_components.BasicSmallButton;


public class FrameButton extends BasicSmallButton{
	
	public FrameButton(MainFrame main, ImageIcon img, String txt, int xPos, int yPos, int xSize, int ySize) {
		super(img);
		addActionListener(new ReceiptsButtonsAL(main, txt));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
