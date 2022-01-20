package project.components.receipts_components;

import javax.swing.JButton;

import project.MainFrame;
import project.actions.receipts_actions.CardInfoAL;

public class CardInfoSubmitBtn extends JButton {
	
	public CardInfoSubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		super("»Æ¿Œ");
		addActionListener(new CardInfoAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}

}
