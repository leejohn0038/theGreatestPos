package project.customer;

import javax.swing.JFrame;

import project.components.Buttons1;
import project.components.Buttons2;
import project.components.Tables;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/*
	�����... 
	1. ȸ�� ��ư�� ������ �� GUI�� �� ��ɵ�..
		
		��ư�ϰ� �� Ŭ�����ϰ� �ձ�
	2. 
*/
	
public class Customer {
	int customer_id;
	String customer_name;
	String customer_phone;
	String customer_adress;
	double membership_point;
	double point_ratio; // �����Ǵ� ����Ʈ ������ ����� ����
	String custmer_date; //��� ��¥
	
	// ��� ������ �ϳ��� ���� ���ؼ� ���̳� ����Ʈ�� ����ؾ� �� �� ����
	public Customer() {

	}

	public Customer(int customer_id, String customer_name, String customer_phone, String customer_adress, double membership_point) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_adress = customer_adress;
		this.membership_point = membership_point;
	}
	// ǥ�� �̵���Ű�� ��ư�� �������� ������ �Ǿ�� �Ѵ�. 
	public static void main(String[] args) {
		Customer c = new Customer(1, "����ȣ", "010-1234-1234", "����", 5);
		System.out.println(c);

	}
}
