package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import project.goods_components.BasicGnbButton;
import project.goods_components.BasicTextArea;

public class GnbPanel extends JPanel {
	BasicGnbButton manageBtn;
	BasicGnbButton lookupBtn;
	BasicGnbButton supplierBtn;
	BasicGnbButton assetBtn;
	
	public GnbPanel(ContentsPanel contents) {
		
		manageBtn = new BasicGnbButton("상품관리");
		manageBtn.setLocation(0, 20);
		manageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Management");
			}
		});
		add(manageBtn);
		
		lookupBtn = new BasicGnbButton("조회");
		lookupBtn.setLocation(150, 20);
		lookupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Lookup");
			}
		});
		add(lookupBtn);
		
		supplierBtn = new BasicGnbButton("거래처");
		supplierBtn.setLocation(300, 20);
		supplierBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Supplier");
			}
		});
		add(supplierBtn);
		
		assetBtn = new BasicGnbButton("자산관리");
		assetBtn.setLocation(450, 20);
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





























