package project.components.customers_components.reserve;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import project.components.Tables;
//
//static {
//	CustomerButtonMap.put("ID : ", new Point(300, 100));
//	CustomerButtonMap.put("�̸� : ", new Point(300, 150));
//	CustomerButtonMap.put("�޴��� ��ȣ : ", new Point(300, 200));
//	CustomerButtonMap.put("�ּ� : ", new Point(300, 250));
//	CustomerButtonMap.put("�������� : ", new Point(300, 300));
//	CustomerButtonMap.put("����� ����Ʈ : ", new Point(300, 350));
//	
//}
public class CustomersInputButton extends JFrame {
	
	
	
	JTextField customer_id;
	JTextField customer_name;
	JTextField customer_phone;
	JTextField customer_adress;
	JTextField custmer_date; // �����
	JTextField membership_point;
	
	JButton c_id;
	JButton c_name;
	JButton c_phone;
	JButton c_adress;
	JButton c_date;
	JButton m_point;
	
	public CustomersInputButton() {
		
		
		// ���� ��ǰ ���̺� ��ġ�� �г��� �ϳ� ���� �����
		// �г� ���� �ø���
		// �ؽ�Ʈ �ʵ� ����
		
		//add(new Panel());
		JFrame c_frame = new JFrame("");
		
		
		customer_id = new JTextField();
		customer_name = new JTextField();
		customer_phone = new JTextField();
		customer_adress = new JTextField();
		custmer_date = new JTextField();
		membership_point = new JTextField();
		
		c_id = new JButton();
		c_name = new JButton();
		c_phone = new JButton();
		c_adress = new JButton();
		c_date = new JButton();
		m_point = new JButton();
		
		// ID
		customer_id.setText("");
		customer_id.setFont(Font.getFont("����"));
		customer_id.setBounds(400, 100, 300, 30);
		add(customer_id);
		
		c_id.setText("ID : ");
		c_id.setFont(Font.getFont("����"));
		c_id.setBounds(300, 100, 100, 30);
		add(c_id);
		
		// �̸�
		customer_name.setText("");
		customer_name.setFont(Font.getFont("����"));
		customer_name.setBounds(400, 150, 300, 30);
		add(customer_name);
		
		customer_name.setText("�̸� : ");
		customer_name.setFont(Font.getFont("����"));
		customer_name.setBounds(300, 150, 100, 30);
		add(customer_name);
		
		// �޴��� ��ȣ
		customer_phone.setText("");
		customer_phone.setFont(Font.getFont("����"));
		customer_phone.setBounds(400, 200, 300, 30);
		add(customer_phone);
		
		c_phone.setText("�޴��� ��ȣ : ");
		c_phone.setFont(Font.getFont("����"));
		c_phone.setBounds(300, 200, 100, 30);
		add(c_phone);
		
		// �ּ�
		customer_adress.setText("");
		customer_adress.setFont(Font.getFont("����"));
		customer_adress.setBounds(400, 250, 300, 30);
		add(customer_adress);
		
		c_adress.setText("�ּ� : ");
		c_adress.setFont(Font.getFont("����"));
		c_adress.setBounds(300, 250, 100, 30);
		add(c_adress);
		
		// ��������
		custmer_date.setText("");
		custmer_date.setFont(Font.getFont("����"));
		custmer_date.setBounds(400, 350, 300, 30);
		add(custmer_date);
		
		c_date.setText("�������� : ");
		c_date.setFont(Font.getFont("����"));
		c_date.setBounds(300, 350, 100, 30);
		add(c_date);
		
		// ����Ʈ
		membership_point.setText("");
		membership_point.setFont(Font.getFont("����"));
		membership_point.setBounds(400, 300, 300, 30);
		add(membership_point);
		
		m_point.setText("");
		m_point.setFont(Font.getFont("����"));
		m_point.setBounds(300, 300, 100, 30);
		add(m_point);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		setTitle("JPanel");
		setBounds(100, 100, 1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CustomersInputButton();
	}
	
}
