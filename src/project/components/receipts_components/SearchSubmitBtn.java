package project.components.receipts_components;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import project.MainFrame;
import project.actions.receipts_actions.SearchSubmitButtonAL;
import project.frames.receipts_frames.Receipts;

public class SearchSubmitBtn extends JButton {

	public SearchSubmitBtn(MainFrame main, int xPos, int yPos, int xSize, int ySize) {
		super("°Ë»ö");
		addActionListener(new SearchSubmitButtonAL(main));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
