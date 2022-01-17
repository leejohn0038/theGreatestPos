package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import project.components.goods_components.BasicBigButton;



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
		
		setBounds(300, 0, 750, 200);
		setLayout(null);
		setVisible(true);
		
	}
}





























