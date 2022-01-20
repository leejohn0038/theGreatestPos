package project.actions.obj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import project.actions.employees_actions.main.object.Emp_addData;
import project.database.employee_customer.SQLs;

public class User_Data {
	
	private int id;
	private int amount;
	private String name;
	private String pass;
	private String startTime;

	public User_Data() {
		// TODO Auto-generated constructor stub
	}

	public void setUser(String amount, String name, String pass) {
		
		String temp = amount.replace(" ", "");
		temp = amount.replace(",", "");
		
		this.amount = Integer.parseInt(temp);
		this.name = name;
		this.pass = pass;
		startTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
	
	public boolean test() {

		String[] datas = {name, pass};
		SQLs sql = new SQLs("À¯Àú", datas);
		ArrayList<Emp_addData> user_data = sql.getEmpArr();
		Emp_addData emp;
		
		if(user_data.size() != 0) {
			for(int i = 0; i<user_data.size(); i++) {
				emp = user_data.get(i);
				id = emp.getID();
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean setUserData(String name, String pass) {
		this.name = name;
		this.pass = pass;
		
		return test();
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getName() {
		return name;
	}
	
	public int getUserId() {
		return id;
	}
	
}
