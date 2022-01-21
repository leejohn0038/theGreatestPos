package project.components.receipts_components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.SearchSubmitButtonAL;
import project.components.goods_components.BasicSmallButton;

public class SearchSubmitBtn extends BasicSmallButton {

	public SearchSubmitBtn(MainFrame main, ImageIcon img, int xPos, int yPos, int xSize, int ySize) {
		super(img);
		addActionListener(new SearchSubmitButtonAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
