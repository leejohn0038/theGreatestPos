package project.actions.employees_actions.main.object;

import java.sql.Date;
import java.time.LocalDate;

public class Emp_addData {
	private int id;
	private String name;
	private Date hire_data;
	private String tel;
	private String job;
	private Object[] dates = {id, name, hire_data, tel, job};
	
	
	public Emp_addData() {}
	public Emp_addData(Object[] objs) {
		
		this.dates = objs;
		
		this.id = Integer.parseInt((String) objs[0]);
		this.name = (String)objs[1];
		this.hire_data = Date.valueOf(((String)objs[2]).substring(0,10));
		this.tel = (String)objs[3];
		this.job = (String)objs[4];
	}
	
	public Emp_addData(String[] objs) {
		
		dates[0] = Integer.parseInt((String) objs[0]);
		dates[1] = objs[1];
		
		if(objs[2] == null) {
			dates[2] = Date.valueOf(LocalDate.now());
		}else {
			dates[2] = Date.valueOf(((String)objs[2]).substring(0,10));
		}
		dates[3] = (String)objs[3];
		dates[4] = (String)objs[4];
	}
	
	public Emp_addData(int id) {
		this.id = id;
		name = null;
		hire_data = null;
		tel = null;
		job = null;
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
		Object[] upDates = {id, name, hire_data, tel, job};
		return upDates;
	}
	
	public int getDatesSize() {
		return dates.length;
	}
	
	public int getID() {
		return id;
	}
}
