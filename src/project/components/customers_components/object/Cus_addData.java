package project.components.customers_components.object;

import java.sql.Date;
import java.time.LocalDate;

public class Cus_addData {
	private String phone;
	private String name;
	private String addrees;
	private Date reg_data;
	private int point;
	private Object[] dates = {phone, name, addrees, reg_data, point};
	
	public Cus_addData() {}
	
	public Cus_addData(Object[] objs) {
		
		this.dates = objs;
		
		this.phone = (String) objs[0];
		this.name = (String)objs[1];
		this.addrees = (String) objs[2];
		this.reg_data = Date.valueOf(((String)objs[3]).substring(0,10));
		this.point = Integer.parseInt((String)objs[4]);
	}
	
	public Cus_addData(String[] objs) {
		dates[0] = objs[0];
		dates[1] = objs[1];
		dates[2] = objs[2];
		if(objs[3] == null) {
			dates[3] = Date.valueOf(LocalDate.now());
		}else {
			dates[3] = Date.valueOf(((String)objs[3]).substring(0,10));
		}
		dates[4] = 0;
	}
	
	public Cus_addData(String phone) {
		this.phone = phone;
		name = null;
		addrees = null;
		reg_data = null;
		point = 0;
	}
	
	public void setSelectValue(int titleIndex, String selectValue) {
		
		if(titleIndex != 0) {
			dates[0] = null;
		}
		dates[titleIndex] = selectValue;
	}
	
	public Object[] getDates() {
		return dates;
	}
	
	public Object[] getUpDates() {
		Object[] upDates = {phone, name, addrees, reg_data, point};
		return upDates;
	}
	
	public int getDatesSize() {
		return dates.length;
	}
	
	public String getID() {
		return phone;
	}
}
