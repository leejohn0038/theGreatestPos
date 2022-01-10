package project.actions.customers_actions.reserve;

import javax.swing.JFrame;

import project.components.Tables;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/*
	만들것... 
	1. 회원 버튼을 눌렀을 때 GUI와 그 기능들..
		
		버튼하고 내 클래스하고 잇기
	2. 
*/
	
public class Customers {
	int customer_id;
	String customer_name;
	String customer_phone;
	String customer_adress;
	double membership_point;
	double point_ratio; // 적립되는 포인트 비율에 사용할 예정
	String custmer_date; //등록 날짜
	

	public Customers() {

	}

	public Customers(int customer_id, String customer_name, String customer_phone, String customer_adress, double membership_point) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_adress = customer_adress;
		this.membership_point = membership_point;
	}
	// 표로 이동시키고 버튼을 눌렀을때 연동이 되어야 한다. 
	public static void main(String[] args) {
		Customers c = new Customers(1, "박찬호", "010-1234-1235", "퇴계원", 5);
		System.out.println(c);

	}
}
