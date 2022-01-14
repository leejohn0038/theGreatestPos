package project.actions.employees_actions.main.object;

import java.sql.Date;
import java.time.LocalDate;

public class AddData {
	private int id;
	private String name;
	private Date hire_data;
	private String tel;
	private String job;
	private Object[] dates = {id, name, hire_data, tel, job};
	
	
	public AddData() {}
	
	public AddData(int id) {
		this.id = id;
		name = null;
		hire_data = null;
		tel = null;
		job = null;
	}
	
	public AddData(int id, String name, LocalDate hire_data, String tel, String job) {
		
		this.id = id;
		this.name = name;
		if(hire_data == null) {
			this.hire_data = Date.valueOf(LocalDate.now());
		}else {
			this.hire_data = Date.valueOf(hire_data);
		}
		this.tel = tel;
		this.job = job;
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
	
	public int getID() {
		return id;
	}
}
