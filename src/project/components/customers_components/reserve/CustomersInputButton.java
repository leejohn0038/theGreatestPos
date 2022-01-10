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
//	CustomerButtonMap.put("이름 : ", new Point(300, 150));
//	CustomerButtonMap.put("휴대폰 번호 : ", new Point(300, 200));
//	CustomerButtonMap.put("주소 : ", new Point(300, 250));
//	CustomerButtonMap.put("가입일자 : ", new Point(300, 300));
//	CustomerButtonMap.put("멤버십 포인트 : ", new Point(300, 350));
//	
//}
public class CustomersInputButton extends JFrame {
	
	
	
	JTextField customer_id;
	JTextField customer_name;
	JTextField customer_phone;
	JTextField customer_adress;
	JTextField custmer_date; // 등록일
	JTextField membership_point;
	
	JButton c_id;
	JButton c_name;
	JButton c_phone;
	JButton c_adress;
	JButton c_date;
	JButton m_point;
	
	public CustomersInputButton() {
		
		
		// 기존 상품 테이블 위치에 패널을 하나 새로 만들기
		// 패널 위에 올리기
		// 텍스트 필드 옆에
		
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
		customer_id.setFont(Font.getFont("돋움"));
		customer_id.setBounds(400, 100, 300, 30);
		add(customer_id);
		
		c_id.setText("ID : ");
		c_id.setFont(Font.getFont("돋움"));
		c_id.setBounds(300, 100, 100, 30);
		add(c_id);
		
		// 이름
		customer_name.setText("");
		customer_name.setFont(Font.getFont("돋움"));
		customer_name.setBounds(400, 150, 300, 30);
		add(customer_name);
		
		customer_name.setText("이름 : ");
		customer_name.setFont(Font.getFont("돋움"));
		customer_name.setBounds(300, 150, 100, 30);
		add(customer_name);
		
		// 휴대폰 번호
		customer_phone.setText("");
		customer_phone.setFont(Font.getFont("돋움"));
		customer_phone.setBounds(400, 200, 300, 30);
		add(customer_phone);
		
		c_phone.setText("휴대폰 번호 : ");
		c_phone.setFont(Font.getFont("돋움"));
		c_phone.setBounds(300, 200, 100, 30);
		add(c_phone);
		
		// 주소
		customer_adress.setText("");
		customer_adress.setFont(Font.getFont("돋움"));
		customer_adress.setBounds(400, 250, 300, 30);
		add(customer_adress);
		
		c_adress.setText("주소 : ");
		c_adress.setFont(Font.getFont("돋움"));
		c_adress.setBounds(300, 250, 100, 30);
		add(c_adress);
		
		// 가입일자
		custmer_date.setText("");
		custmer_date.setFont(Font.getFont("돋움"));
		custmer_date.setBounds(400, 350, 300, 30);
		add(custmer_date);
		
		c_date.setText("가입일자 : ");
		c_date.setFont(Font.getFont("돋움"));
		c_date.setBounds(300, 350, 100, 30);
		add(c_date);
		
		// 포인트
		membership_point.setText("");
		membership_point.setFont(Font.getFont("돋움"));
		membership_point.setBounds(400, 300, 300, 30);
		add(membership_point);
		
		m_point.setText("");
		m_point.setFont(Font.getFont("돋움"));
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
