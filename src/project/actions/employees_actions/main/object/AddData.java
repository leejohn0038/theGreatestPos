package project.actions.employees_actions.main.object;

import java.sql.Date;
import java.time.LocalDate;

public class AddData {
	private int id;
	private String name;
	private Date hire_data;
	private String tel;
	private String job;
	
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
	
	public Object[] getDates() {
		
		Object[] dates = {id, name, hire_data, tel, job};
		
		return dates;
	}
}
