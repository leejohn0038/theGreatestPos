package project;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	static {
	}
	
	public Login() {	
		
		for(int i = 0 ; i<2; i++) {
			add(tLab());
			add(txt());
			add(assBtn());
		}
	}
	
	//����� �Է� ���� ��
	JTextField txt() {
		
		JTextField txt = new JTextField();
		
		return txt;
		
	}
	
	//�α��� �̸�
	JLabel tLab() {
		
		JLabel tLab = new JLabel();	
		
		return tLab;
	}
	
	//��Ϲ�ư
	JButton assBtn() {
		
		JButton btn = new JButton();
		
		return btn;
	}
	
	boolean start() {
		boolean start = false;
		return start;
	}
}
