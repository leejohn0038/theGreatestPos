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
	JTextField custmer_date; // 등록일
	
	// CustomerInputButtonUi에 새로 만들었는데 일단은 예비용
	JButton c_id;
	JButton c_name;
	JButton c_phone;
	JButton c_adress;
	JButton m_point;
	JButton c_date;

	
	public CustomerInputFieldUi() {
		// 기존 상품 테이블 위치에 패널을 하나 새로 만들기
		// 패널 위에 올리기
		// 텍스트 필드 옆에
		
		//add(new Panel());
		
		customer_id = new JTextField();
		customer_name = new JTextField();
		customer_phone = new JTextField();
		customer_adress = new JTextField();
		custmer_date = new JTextField();
		membership_point = new JTextField();
		
		customer_id.setText("");
		customer_id.setFont(Font.getFont("돋음"));
		customer_id.setBounds(400, 100, 300, 30);
		add(customer_id);
		
		customer_name.setText("");
		customer_name.setFont(Font.getFont("돋음"));
		customer_name.setBounds(400, 150, 300, 30);
		add(customer_name);
		
		customer_phone.setText("");
		customer_phone.setFont(Font.getFont("돋음"));
		customer_phone.setBounds(400, 200, 300, 30);
		add(customer_phone);
		
		customer_adress.setText("");
		customer_adress.setFont(Font.getFont("돋음"));
		customer_adress.setBounds(400, 250, 300, 30);
		add(customer_adress);
		
		membership_point.setText("");
		membership_point.setFont(Font.getFont("돋음"));
		membership_point.setBounds(400, 300, 300, 30);
		add(custmer_date);
		
		custmer_date.setText("");
		custmer_date.setFont(Font.getFont("돋음"));
		custmer_date.setBounds(400, 350, 300, 30);
		add(membership_point);
		
		
		
		
		String[] btnNames1 = {"판매", "영수증", "직원", "회원", "업무가이드"};
		String[] btnNames2 = {"포인트 적립", "현금 영수증", "영수증 발급"};
		
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
