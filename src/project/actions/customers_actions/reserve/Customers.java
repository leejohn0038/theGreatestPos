package project.actions.customers_actions.reserve;

import javax.swing.JFrame;

import project.components.Tables;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/*
	�����... 
	1. ȸ�� ��ư�� ������ �� GUI�� �� ��ɵ�..
		
		��ư�ϰ� �� Ŭ�����ϰ� �ձ�
	2. 
*/
	
public class Customers {
	int customer_id;
	String customer_name;
	String customer_phone;
	String customer_adress;
	double membership_point;
	double point_ratio; // �����Ǵ� ����Ʈ ������ ����� ����
	String custmer_date; //��� ��¥
	

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
	// ǥ�� �̵���Ű�� ��ư�� �������� ������ �Ǿ�� �Ѵ�. 
	public static void main(String[] args) {
		Customers c = new Customers(1, "����ȣ", "010-1234-1235", "����", 5);
		System.out.println(c);

	}
}
