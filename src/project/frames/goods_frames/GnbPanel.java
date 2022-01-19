package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.actions.goods_actions.ButtonMouseOver;
import project.components.goods_components.BasicBigButton;


public class GnbPanel extends JPanel {
	BasicBigButton manageBtn, lookupBtn, assetBtn;
	
	public GnbPanel(ContentsPanel contents) {
		add(new JLabel("Team 2nd") {
			{
				setBounds(40, 0, 150, 50);
				setFont(new Font("Serif", Font.BOLD, 40));
			}
		});
		
		ImageIcon goods_img = new ImageIcon("./image/manage_goods.png");
		manageBtn = new BasicBigButton(goods_img);
		manageBtn.setBounds(30, 100, 150, 50);
		manageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Management");
			}
		});
		add(manageBtn);
		
		ImageIcon lookup_img = new ImageIcon("./image/manage_lookup.png");
		lookupBtn = new BasicBigButton(lookup_img);
		lookupBtn.setBounds(30, 200, 150, 50);
		lookupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Lookup");
			}
		});
		add(lookupBtn);
		ImageIcon asset_img = new ImageIcon("./image/manage_asset.png");
		assetBtn = new BasicBigButton(asset_img);
		assetBtn.setBounds(30, 300, 150, 50);
		assetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Asset");
			}
		});
		add(assetBtn);
		
//		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setBounds(10, 10, 200, 640);
		setLayout(null);
//		setLayout(new GridLayout(5, 1, 0, 40));
		setBackground(Color.WHITE);
		setVisible(true);
		
	}
}































