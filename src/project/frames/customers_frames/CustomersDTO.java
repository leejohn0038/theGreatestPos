package project.frames.customers_frames;

import javax.swing.JFrame;

import project.components.customers_components.CustomersInputButton;

import java.sql.Date;


public class CustomersDTO extends JFrame {
	
	
	private String phone;
	private String customers_name;
	private String customers_address;
	private Date subscription_date;
	private double membership_point;


	public String getPhone() {
	    return phone;
	}
	public void setPhone(String phone) {
	    this.phone = phone;
	}
	
	public String getName() {
	    return customers_name;
	}
	public void setName(String customers_name) {
	    this.customers_name = customers_name;
	}
	
	public String getAddress() {
	    return customers_address;
	}
	public void setAddress(String customers_address) {
	    this.customers_address = customers_address;
	}
	public Date getSubscriptionDate() {
	    return subscription_date;
	}
	public void setSubscriptionDate(Date subscription_date) {
	    this.subscription_date = subscription_date;
	}
	
	public double getMembershipPoint() {
	    return membership_point;
	}
	public void setMembershipPoint(double membership_point) {
	    this.membership_point = membership_point;
	}
	
	
	@Override
	public String toString() {
	    return "CustomersDTO [phone=" + phone + ", customers_name=" + customers_name + ", customers_address=" + customers_address + ", subscription_date=" + subscription_date 
	    		+ ", membership_point=" + membership_point + "]"; 
	}
	public CustomersDTO() {
		new CustomersInputButton();
		
	}
	public static void main(String[] args) {
		new CustomersDTO();
	}
	
	
}
