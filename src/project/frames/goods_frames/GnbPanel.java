package project.frames.goods_frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

<<<<<<< HEAD
import project.components.goods_components.BasicBigButton;
import project.components.goods_components.BasicTextArea;
=======
import project.components.goods_components.BasicGnbButton;
>>>>>>> refs/heads/jo

public class GnbPanel extends JPanel {
	BasicBigButton manageBtn;
	BasicBigButton lookupBtn;
	BasicBigButton supplierBtn;
	BasicBigButton assetBtn;
	
	public GnbPanel(ContentsPanel contents) {
		
		manageBtn = new BasicBigButton("상품관리");
		manageBtn.setLocation(0, 20);
		manageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Management");
			}
		});
		add(manageBtn);
		
		lookupBtn = new BasicBigButton("조회");
		lookupBtn.setLocation(150, 20);
		lookupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Lookup");
			}
		});
		add(lookupBtn);
		
		supplierBtn = new BasicBigButton("거래처");
		supplierBtn.setLocation(300, 20);
		supplierBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)contents.getLayout();
				layout.show(contents, "Supplier");
			}
		});
		add(supplierBtn);
		
		assetBtn = new BasicBigButton("자산관리");
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





























