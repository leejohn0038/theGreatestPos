package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ContentsPanel extends JPanel {
	private ManagementPanel manage = new ManagementPanel();
	private LookupPanel lookup = new LookupPanel();
	
	public ContentsPanel() {
		setLayout(new CardLayout());
		add("Management", manage);
		add("Lookup", lookup);
		add("Supplier", new SupplierPanel());
		add("Asset", new AssetPanel());
		setBounds(300, 100, 760, 500);
		
		setVisible(true);
	}
	
	public ManagementPanel getManagementPanel() {
		return manage;
	}
	
	public LookupPanel getLookupPanel() {
		return lookup;
	}
}
