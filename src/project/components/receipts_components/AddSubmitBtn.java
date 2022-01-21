package project.components.receipts_components;

import javax.swing.ImageIcon;

import project.MainFrame;
import project.actions.receipts_actions.AddSubmitAL;
import project.components.goods_components.BasicSmallButton;

public class AddSubmitBtn extends BasicSmallButton{

	public AddSubmitBtn(MainFrame main,ImageIcon img, int xPos, int yPos, int xSize, int ySize) {
		super(img);
		addActionListener(new AddSubmitAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
	
}
