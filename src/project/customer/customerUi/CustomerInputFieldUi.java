package project.customer.customerUi;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import project.components.Buttons1;
import project.components.Buttons2;
import project.components.Tables;


public class CustomerInputFieldUi extends JFrame {
	JTextField customer_id;
	JTextField customer_name;
	JTextField customer_phone;
	JTextField customer_adress;
	JTextField membership_point;
	JTextField custmer_date; // �����
	
	// CustomerInputButtonUi�� ���� ������µ� �ϴ��� �����
	JButton c_id;
	JButton c_name;
	JButton c_phone;
	JButton c_adress;
	JButton m_point;
	JButton c_date;

	
	public CustomerInputFieldUi() {
		// ���� ��ǰ ���̺� ��ġ�� �г��� �ϳ� ���� �����
		// �г� ���� �ø���
		// �ؽ�Ʈ �ʵ� ����
		
		//add(new Panel());
		
		customer_id = new JTextField();
		customer_name = new JTextField();
		customer_phone = new JTextField();
		customer_adress = new JTextField();
		custmer_date = new JTextField();
		membership_point = new JTextField();
		
		customer_id.setText("");
		customer_id.setFont(Font.getFont("����"));
		customer_id.setBounds(400, 100, 300, 30);
		add(customer_id);
		
		customer_name.setText("");
		customer_name.setFont(Font.getFont("����"));
		customer_name.setBounds(400, 150, 300, 30);
		add(customer_name);
		
		customer_phone.setText("");
		customer_phone.setFont(Font.getFont("����"));
		customer_phone.setBounds(400, 200, 300, 30);
		add(customer_phone);
		
		customer_adress.setText("");
		customer_adress.setFont(Font.getFont("����"));
		customer_adress.setBounds(400, 250, 300, 30);
		add(customer_adress);
		
		membership_point.setText("");
		membership_point.setFont(Font.getFont("����"));
		membership_point.setBounds(400, 300, 300, 30);
		add(custmer_date);
		
		custmer_date.setText("");
		custmer_date.setFont(Font.getFont("����"));
		custmer_date.setBounds(400, 350, 300, 30);
		add(membership_point);
		
		
		
		
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
		new CustomerInputFieldUi();
	}
	
}
