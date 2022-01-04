package project;

import javax.swing.JFrame;

import project.components.Buttons1;
import project.components.Buttons2;
import project.components.Tables;
import project.components.Toppanel;

public class MainFrame extends JFrame {
	
	
	public MainFrame() {
		add(new Toppanel());
	
		add(new Tables());
		
		String[] btnNames1 = {"�Ǹ�", "������", "����", "ȸ��", "�������̵�"};
		String[] btnNames2 = {"����Ʈ ����", "���� ������", "������ �߱�"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new Buttons1(btnNames1[i]));
		}
		
		for(int i = 0; i < btnNames2.length; ++i) {
			add(new Buttons2(btnNames2[i]));
		}
			
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
