package project.components.customers_components;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//customer_id.setText("");
//customer_id.setFont(Font.getFont("����"));
//customer_id.setBounds(400, 100, 300, 30);
//add(customer_id);


public class CustomersButton extends JFrame {
	public CustomersButton() {
		//new DefaultFrame_c();
		//setLayout(new GridLayout(6, 6, 10, 10));
//		for (int i = 1; i < 7; ++i) {
//		JLabel c_Lable = new JLabel("" + i);
//		c_Lable.setBounds(100, i*100, 100, 100);
//		add(c_Lable);
//	}
	
//	for (int i = 1; i < 7; ++i) {
//		add(new JTextField(i));
//		setBounds(100, i*100, 100, 100);
//	}
		
		// �ٿ�尡 ������������ �������� ���� �� �� �־���Ѵ�...
		// ������ ���,,
		JPanel panel = new JPanel();
		CustomersButtonSet cbs = new CustomersButtonSet();
		
		JLabel idLabel = new JLabel("ID : ");
		JTextField idField = new JTextField(30);
		
		panel.add(idLabel);
		panel.add(idField);
		
		JLabel nameLabel = new JLabel("�̸� : ");
		JTextField nameField = new JTextField(30);
		panel.add(nameLabel);
		panel.add(nameField);
		
		JLabel phoneLable = new JLabel("�޴��� ��ȣ : ");
		JTextField phoneField = new JTextField(30);
		panel.add(phoneLable);
		panel.add(phoneField);
		
		JLabel adressLabel = new JLabel("�ּ� : ");
		JTextField adressField = new JTextField(30);
		panel.add(adressLabel);
		panel.add(adressField);
		
		JLabel dateLabel = new JLabel("���� ���� : ");
		JTextField dateField = new JTextField(30);
		panel.add(dateLabel);
		panel.add(dateField);
		
		JLabel pointLabel = new JLabel("����� ����Ʈ : ");
		JTextField pointField = new JTextField(30);
		panel.add(pointLabel);
		panel.add(pointField);
		
		
		add(panel);
		
		setTitle("ȸ�� ����");
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	


	public static void main(String[] args) {
		
		new CustomersButton();
	}
}
