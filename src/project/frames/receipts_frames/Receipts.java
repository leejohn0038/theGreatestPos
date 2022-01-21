
package project.frames.receipts_frames;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTable;

import project.MainFrame;
import project.components.goods_components.ButtonImage;
import project.components.receipts_components.FrameButton;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.ReceiptsBtnImg;
import project.components.receipts_components.Tables;
import project.components.receipts_components.homeBtn;

public class Receipts extends JFrame {
	private Tables table;
	private ButtonImage img;
	
	public Receipts(MainFrame main) {
		img = new ButtonImage();
		add(new homeBtn(this, img.homeBtn()));
		add(table = new Tables(
				new String[] {"������ID", "��ȭ��ȣ", "����", "��������", "���Žñ�"}, 
				240, 70, 720, 450));

		add(new FrameButton(main, ReceiptsBtnImg.search(150, 40), "������ ��ȸ�ϱ�", 20, 600, 150, 40));
		String[] btnNames2 = {"����Ʈ ����", "���� ������", "������ �߱�", "��ǰ����"};
		for (int i = 0; i < btnNames2.length; ++i) {
			add(new ReceiptButtons(main, ReceiptsBtnImg.getIcon(btnNames2[i], 150, 40),btnNames2[i]));
		}
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
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
