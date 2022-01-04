package project.goods.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import project.goods.components.GoodsTable;
import project.goods.components.ManegementLnbButtons;

public class ManagementPanel extends JPanel {
	public ManagementPanel() {
		String[] lnbButtons = {"입고", "출고", "폐기", "반품"};
		for (int i = 0; i < lnbButtons.length; ++i) {
			add(new ManegementLnbButtons(lnbButtons[i]));
		}
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new GoodsTable());
		setVisible(true);
	}
}
