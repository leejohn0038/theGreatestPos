package project.frames.receipts_frames;

import javax.swing.JFrame;
import javax.swing.JTextField;

import project.MainFrame;
import project.components.receipts_components.Label;
import project.components.receipts_components.SearchSubmitBtn;
import project.components.receipts_components.TextField;

public class ReceiptSearch extends JFrame {
	JTextField[] f = new JTextField[9];
	public ReceiptSearch(MainFrame main, Receipts r) {
		
		add(new Label("영수증ID", 50, 55, 100, 50));
		add(f[0] = new TextField(170, 60, 150, 30) {{setName("id1");}}); 
		add(new Label("~", 330, 60, 30, 30));
		add(f[1] = new TextField(170, 90, 150, 30) {{setName("id2");}});
		
		add(new Label("전화번호", 50, 125, 100, 50));
		add(f[2] = new TextField(170, 130, 150, 30) {{setName("phone1");}});
		add(new Label("~", 330, 130, 100, 50));
		add(f[3] = new TextField(170, 160, 150, 30) {{setName("phone2");}});
		
		add(new Label("가격", 50, 195, 100, 50));
		add(f[4] = new TextField(170, 200, 150, 30) {{setName("price1");}});
		add(new Label("~", 330, 200, 30, 30));
		add(f[5] = new TextField(170, 230, 150, 30) {{setName("price2");}});
		
		add(new Label("결제수단", 50, 265, 100, 50));
		add(f[6] = new TextField(170, 270, 150, 30) {{setName("payment");}});		

		add(new Label("구매시기", 50, 305, 100, 50));
		add(f[7] = new TextField(170, 310, 150, 30) {{setName("period1");}});
		add(new Label("~", 330, 310, 30, 30));
		add(f[8] = new TextField(170, 340, 150, 30) {{setName("period2");}});
		
		add(new SearchSubmitBtn(main, r, f, 200, 400, 100, 50));

		setVisible(false);
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(200, 200, 500, 550);
	}
}
