package project.goods.frame;

import javax.swing.JPanel;

import project.goods.components.GoodsTable;

public class AssetPanel extends JPanel {
	public AssetPanel() {
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new GoodsTable());
		setVisible(true);
	}
}
