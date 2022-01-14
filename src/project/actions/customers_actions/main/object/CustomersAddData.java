package project.actions.customers_actions.main.object;

import java.sql.Date;
import java.time.LocalDate;
///////////////////// 내부 emp관련 DB 데이터를 ctm으로 고치기
public class CustomersAddData {
	private String phone;
	private String customers_name;
	private String customers_address;
	private Date subscription_date;
	private int membership_point;
	private Object[] dates = {phone, customers_name, customers_address, subscription_date, membership_point};
	
	
	public CustomersAddData() {}
	public CustomersAddData(Object[] objs) {
		
		this.dates = objs;
		
		//this.phone = Integer.parseString((String) objs[0]);
		//this.customers_address = Date.valueOf(((String)objs[2]).substring(0,10));
		this.phone = (String) objs[0];
		this.customers_name = (String)objs[1];
		this.customers_address = (String)objs[2];
		this.subscription_date = Date.valueOf(((String)objs[3]).substring(0,10));
		this.membership_point = Integer.parseInt((String) objs[4]);
	}
	
	public CustomersAddData(String[] objs) {
		
		dates[0] = Integer.parseInt((String) objs[0]);
		dates[1] = objs[1];
		
		if(customers_address == null) {
			dates[2] = Date.valueOf(LocalDate.now());
		}
		/*else {
			
			dates[2] = Date.valueOf(((String)objs[2]).substring(0,10));
		}*/
		dates[3] = (String)objs[3];
		dates[4] = (String)objs[4];
		
		//System.out.println(phone + " " + customers_name + " " + customers_address + " " + subscription_date + " " + membership_point + " ");
	}
	
	public CustomersAddData(String phone) {
		this.phone = phone;
		customers_name = null;
		customers_address = null;
		subscription_date = null;
		membership_point = 0;
	}
	
	
	
	public void setSelectValue(int titleIndex, String selectValue) {
		//System.out.println(titleIndex);
		if(titleIndex != 0) {
			dates[0] = null;
		}
		dates[titleIndex] = selectValue;
	}
	
	public Object[] getDates() {
		return dates;
	}
	
	public int getDatesSize() {
		return dates.length;
	}
	
	public String getID() {
		return phone;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %d", phone, customers_name, customers_address, subscription_date, membership_point);
	}
}
