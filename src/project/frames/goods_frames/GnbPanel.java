package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.components.goods_components.BasicBigButton;
import project.components.goods_components.ButtonImage;


public class GnbPanel extends JPanel {
	private BasicBigButton manageBtn, lookupBtn, assetBtn;
	private ButtonImage img = new ButtonImage();
	
	public GnbPanel(ContentsPanel contents) {
		
		add(new JLabel() {{
			setBounds(0, 0, 200, 150);
			setIcon(new ImageIcon("./image/logo.png"));
		}});
		manageBtn = new BasicBigButton(img.gnbManage());
		manageBtn.setBounds(0, 170, 150, 40);
		manageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Management");
			}
		});
		
		add(manageBtn);
		
		lookupBtn = new BasicBigButton(img.gnbLookup());
		lookupBtn.setBounds(0, 230, 150, 40);
		lookupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Lookup");
			}
		});
		add(lookupBtn);
		assetBtn = new BasicBigButton(img.gnbAsset());
		assetBtn.setBounds(0, 290, 150, 40);
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































