package project.goods.frames;

import javax.swing.JPanel;

import project.goods.components.LookupLnbButtons;
import project.goods.components.GoodsTable;

public class LookupPanel extends JPanel {
	public static boolean visible = false;
	public LookupPanel() {
		String[] lnbButtons = {"��ü", "ī�װ�", "�������", "�ŷ�ó"};
		for (int i = 0; i < lnbButtons.length; ++i) {
			add(new LookupLnbButtons(lnbButtons[i]));
		}
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new GoodsTable());
		setVisible(visible);
	}
}
