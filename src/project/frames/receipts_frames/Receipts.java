
package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.Tables;
import project.components.Toppanel;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.SearchBoxButtons;

public class Receipts extends JFrame {
	
	
	public Receipts(MainFrame main) {
		add(new Toppanel("������"));
		add(new Tables(100, 250, 200));
		
		String[] btnNames3 = {"���ⱸ��", "���Žñ�", "��������", "�Ǹűݾ�", "��ǰ�ڵ�", "��������ȣ"};
		for (int i = 0; i < btnNames3.length; ++i) {			
			add(new SearchBoxButtons(btnNames3[i]));
		}
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
}
