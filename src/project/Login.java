package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.actions.obj.User_Data;

public class Login extends JFrame{
	
	boolean start = false;
	ArrayList<JTextField> txts;
	
	User_Data user;
	int user_id;
	
	JFrame f;
	
	public Login(JFrame f) {
		this.f = f;
		txts = new ArrayList<>();
		
		user = new User_Data();
		
		String[] txtData = {"���۱ݾ�", "�����̸�", "��й�ȣ"};
		
		setLayout(null);
		setBounds(100,100,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		for(int i = 0 ; i<txtData.length; i++) {
			add(tLab(i, txtData[i]));
			add(txt(i, txtData[i]));	
		}
		
		add(assBtn());
	}
	
	//����� �Է� ���� ��
	JTextField txt(int num, String title) {
		
		JTextField txt = new JTextField();
		if(title.contains("����")) {
			txt.setText("200,000");
		}
		
		txt.setBounds(70+10,((num*70)+10),100,30);
		
		txts.add(txt);
		return txt;
		
	}
	
	//Ÿ��Ʋ
	JLabel tLab(int num, String title) {
		
		JLabel tLab = new JLabel(title + " : ");
		tLab.setBounds(10,((num*60)+10),70,50);
		
		return tLab;
	}
	
	//���۹�ư
	JButton assBtn() {
		
		// x, y
		int[] size = {100, 50};
		int[] loc = {
				//�����Ӻ� ��ġ
				//������ ũ�� - Ÿ��Ʋ�� - �ڱ�ũ��
				this.getSize().width - this.getPreferredSize().width - size[0],
				this.getSize().height - this.getPreferredSize().height - size[1]
				};
		
		JButton btn = new JButton("����");
		
		btn.setBounds(loc[0], loc[1], size[0], size[1]);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txts.get(2).getText().length() > 3 && txts.get(2).getText().length() < 5) {
					user.setUser(txts.get(0).getText(), txts.get(1).getText(), txts.get(2).getText());
					
					if(user.test()) {
						user_id = user.getUserId();
						System.out.println(user.getUserId());
						f.setVisible(true);
						dispose();
					}
				}	
			}
		});
		
		return btn;
	}
	
	User_Data getUserData() {
		return user;
	}
	
	int getUserID() {
		return user_id;
	}

}
