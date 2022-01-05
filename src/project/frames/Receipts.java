
package project.frames;

import javax.swing.JFrame;

import project.components.Tables;
import project.components.Toppanel;
import project.components.receipt.Buttons2;
import project.components.receipt.Buttons3;

public class Receipts extends JFrame {
	
	
	public Receipts() {
		add(new Toppanel("������"));
		add(new Tables(100, 250, 200));
		
		String[] btnNames3 = {"���ⱸ��", "���Žñ�", "��������", "�Ǹűݾ�", "��ǰ�ڵ�", "��������ȣ"};
		for (int i = 0; i < btnNames3.length; ++i) {			
			add(new Buttons3(btnNames3[i]));
		}
				String[] btnNames2 = {"����Ʈ ����", "���� ������", "������ �߱�", "��ǰ����"};
		for (int i = 0; i < btnNames2.length; ++i) {
			add(new Buttons2(btnNames2[i], 200));
		}
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false);
	}
}
