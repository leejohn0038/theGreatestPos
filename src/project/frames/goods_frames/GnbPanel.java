package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import project.components.goods_components.BasicBigButton;
import project.components.goods_components.GoodsColor;


public class GnbPanel extends JPanel {
	BasicBigButton manageBtn, lookupBtn, assetBtn;
	
	public GnbPanel(ContentsPanel contents) {
		
		manageBtn = new BasicBigButton("惑前包府");
		manageBtn.setLocation(0, 20);
		manageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Management");
			}
		});
		add(manageBtn);
		
		lookupBtn = new BasicBigButton("炼雀");
		lookupBtn.setLocation(150, 20);
		lookupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Lookup");
			}
		});
		add(lookupBtn);
		
		assetBtn = new BasicBigButton("磊魂包府");
		assetBtn.setLocation(300, 20);
		assetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Asset");
			}
		});
		add(assetBtn);
		
//		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setBounds(20, 20, 260, 620);
		setLayout(new GridLayout(5, 1, 0, 50));
		setBackground(Color.WHITE);
		setVisible(true);
		
	}
}





























