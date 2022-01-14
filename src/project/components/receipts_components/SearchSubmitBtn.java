package project.components.receipts_components;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import project.MainFrame;
import project.actions.receipts_actions.SearchSubmitButtonAL;
import project.frames.receipts_frames.Receipts;

public class SearchSubmitBtn extends JButton {

	public SearchSubmitBtn(MainFrame main, Receipts r, JTextField[] f, JComboBox com, int xPos, int yPos, int xSize, int ySize) {
		super("�˻�");
		addActionListener(new SearchSubmitButtonAL(main, r, f, com));
		setBounds(xPos, yPos, xSize, ySize);
	}
}
