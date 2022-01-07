package project.components.customers_components;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//customer_id.setText("");
//customer_id.setFont(Font.getFont("돋움"));
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
		
		// 바운드가 일정간격으로 연속으로 들어가게 할 수 있어야한다...
		// 하지만 어떻게,,
		JPanel panel = new JPanel();
		CustomersButtonSet cbs = new CustomersButtonSet();
		
		JLabel idLabel = new JLabel("ID : ");
		JTextField idField = new JTextField(30);
		
		panel.add(idLabel);
		panel.add(idField);
		
		JLabel nameLabel = new JLabel("이름 : ");
		JTextField nameField = new JTextField(30);
		panel.add(nameLabel);
		panel.add(nameField);
		
		JLabel phoneLable = new JLabel("휴대폰 번호 : ");
		JTextField phoneField = new JTextField(30);
		panel.add(phoneLable);
		panel.add(phoneField);
		
		JLabel adressLabel = new JLabel("주소 : ");
		JTextField adressField = new JTextField(30);
		panel.add(adressLabel);
		panel.add(adressField);
		
		JLabel dateLabel = new JLabel("가입 일자 : ");
		JTextField dateField = new JTextField(30);
		panel.add(dateLabel);
		panel.add(dateField);
		
		JLabel pointLabel = new JLabel("멤버십 포인트 : ");
		JTextField pointField = new JTextField(30);
		panel.add(pointLabel);
		panel.add(pointField);
		
		
		add(panel);
		
		setTitle("회원 관리");
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	


	public static void main(String[] args) {
		
		new CustomersButton();
	}
}
