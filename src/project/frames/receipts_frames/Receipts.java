
package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.receipts_components.Button;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;

public class Receipts extends JFrame {
	public Tables table;
	
	public Receipts(MainFrame main) {
		add(new Toppanel(main, "영수증"));
		add(table = new Tables(
				new String[] {"영수증ID", "구매시기", "가격", "결제수단"}, 
				100, 250, 200));

		add(new Button(main, "영수증 조회하기", 100, 150, 150, 50));
		String[] btnNames2 = {"포인트 적립", "현금 영수증", "영수증 발급", "반품업무"};
		for (int i = 0; i < btnNames2.length; ++i) {
			add(new ReceiptButtons(main, btnNames2[i], 200));
		}
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
}
