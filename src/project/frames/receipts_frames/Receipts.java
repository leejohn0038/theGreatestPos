
package project.frames.receipts_frames;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import project.MainFrame;
import project.components.goods_components.ButtonImage;
import project.components.receipts_components.FrameButton;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.ReceiptsBtnImg;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;
import project.components.receipts_components.homeBtn;

public class Receipts extends JFrame {
	private Tables table;
	private ButtonImage img;
	
	public Receipts(MainFrame main) {
		img = new ButtonImage();
		add(new homeBtn(this, img.homeBtn()));
		add(new Toppanel("영수증"));
		add(new JLabel(new ImageIcon("./image/logo.png")) {{setBounds(0, 0, 200, 150);}});
		add(table = new Tables(
				new String[] {"영수증ID", "전화번호", "가격", "결제수단", "구매시기"}, 
				230, 70, 760, 440));

		add(new FrameButton(main, ReceiptsBtnImg.search(150, 40), "영수증 조회하기", 230, 530, 150, 40));
		String[] btnNames2 = {"포인트 적립", "현금 영수증", "영수증 발급", "반품업무"};
		for (int i = 0; i < btnNames2.length; ++i) {
			add(new ReceiptButtons(main, ReceiptsBtnImg.getIcon(btnNames2[i], 150, 40),btnNames2[i]));
		}
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(main.getLocation().x, main.getLocation().y, 1000, 700);
		setVisible(false);
		setUndecorated(true);
		setResizable(false);
	}
	
	public JTable getJTable() {
		return table.getTable();
	}
	
	public Tables getTable() {
		return table;
	}
	
}
