package project.components.receipts_components;

import javax.swing.ImageIcon;

import project.MainFrame;
import project.actions.receipts_actions.CashReceiptSubmitAL;
import project.components.goods_components.BasicSmallButton;

public class CashReceiptSubmitBtn extends BasicSmallButton {
	
	public CashReceiptSubmitBtn(MainFrame main, ImageIcon img) {
		super(img);
		addActionListener(new CashReceiptSubmitAL(main));
		setBounds(150, 150, 75, 20);
	}
	

}
