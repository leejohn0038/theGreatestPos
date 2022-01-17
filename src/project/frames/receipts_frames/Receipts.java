
package project.frames.receipts_frames;

import javax.swing.JFrame;
import javax.swing.JTable;

import project.MainFrame;
import project.components.receipts_components.FrameButton;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;

public class Receipts extends JFrame {
	private Tables table;
	
	public Receipts(MainFrame main) {
		add(new Toppanel(main, "������"));
		add(table = new Tables(
				new String[] {"������ID", "��ȭ��ȣ", "����", "��������", "���Žñ�"}, 
				100, 250, 680, 200));

		add(new FrameButton(main, "������ ��ȸ�ϱ�", 100, 150, 150, 50));
		String[] btnNames2 = {"����Ʈ ����", "���� ������", "������ �߱�", "��ǰ����"};
		for (int i = 0; i < btnNames2.length; ++i) {
			add(new ReceiptButtons(main, btnNames2[i], 200));
		}
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
	
	public JTable getJTable() {
		return table.getTable();
	}
	
	public Tables getTable() {
		return table;
	}
}
