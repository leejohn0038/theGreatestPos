package project.actions.employees_actions;

import java.sql.Date;
import java.time.LocalDate;

public class AddData {
	int id;
	String name;
	Date hire_data;
	String tel;
	String job;
	
	public AddData(int id, String name, String tel, String job) {
		
		this.id = id;
		this.name = name;
		hire_data = Date.valueOf(LocalDate.now());;
		this.tel = tel;
		this.job = job;
	}
}
