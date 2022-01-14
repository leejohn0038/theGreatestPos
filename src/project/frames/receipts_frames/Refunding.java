package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.receipts_components.RefundingPanel;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;

public class Refunding extends JFrame {

	public Refunding(MainFrame main) {
		add(new Toppanel("반품업무"));
		add(new Tables(
				new String[] {"영수증ID", "구매시기", "가격", "결제수단"}, 
				100, 100, 680, 200));
		add(new RefundingPanel(main));
		//add(new SubmitBtn(450, 500, 100, 50));
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
}
