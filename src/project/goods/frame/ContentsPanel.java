package project.goods.frame;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ContentsPanel extends JPanel {

	public ContentsPanel() {
		add("Management", new ManagementPanel());
		add("Lookup", new LookupPanel());
		add("Supplier", new SupplierPanel());
		add("Asset", new AssetPanel());
		setLayout(new CardLayout());
		setBounds(300, 100, 760, 500);
		
		setVisible(true);
	}
}
