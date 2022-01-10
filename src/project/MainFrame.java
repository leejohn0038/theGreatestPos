package project;

import javax.swing.JFrame;

import project.components.receipts_components.MainButtons;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;
import project.frames.Frames;

public class MainFrame extends JFrame {
	
	private Frames frames;
	
	public MainFrame() {
		frames = new Frames(this);
		add(new Toppanel("�Ǹ�"));
		add(new Tables(new String[] {"��ǰid", "��ǰ�̸�", "����", "����"}));
		
		String[] btnNames1 = {"��ǰ", "������", "����", "ȸ��", "�������̵�"};
		String[] btnNames2 = {"����Ʈ ����", "���� ������", "������ �߱�"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new MainButtons(this, btnNames1[i]));
		}
		
		for(int i = 0; i < btnNames2.length; ++i) {
			add(new ReceiptButtons(this, btnNames2[i]));
		}
			
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false); 
	}
	
	public JFrame getFrame(String btn) {
		return frames.FRAMES.get(btn);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}

