package project.components.receipts_components;

import javax.swing.JButton;
import javax.swing.JTextField;

import project.actions.receipts_actions.SearchSubmitButtonAL;
import project.frames.receipts_frames.Receipts;

public class SearchSubmitBtn extends JButton {

	public SearchSubmitBtn(Receipts r, JTextField[] f, int xPos, int yPos, int xSize, int ySize) {
		super("�˻�");
		addActionListener(new SearchSubmitButtonAL(r, f));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
