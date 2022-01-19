package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import project.components.goods_components.GoodsColor;

public class ContentsPanel extends JPanel {
	private ManagementPanel manage = new ManagementPanel();
	private LookupPanel lookup = new LookupPanel();
	private AssetPanel asset = new AssetPanel();
	
	public ContentsPanel() {
		setLayout(new CardLayout());
		add("Management", manage);
		add("Lookup", lookup);
		add("Asset", asset);
		setBounds(240, 10, 720, 640);
//		setBackground(Color.ORANGE);
		setBackground(Color.WHITE);
		setOpaque(false);
		setVisible(true);
	}
	
	public ManagementPanel getManagementPanel() {
		return manage;
	}
	
	public LookupPanel getLookupPanel() {
		return lookup;
	}
	
	public AssetPanel getAssetPanel() {
		return asset;
	}
}
