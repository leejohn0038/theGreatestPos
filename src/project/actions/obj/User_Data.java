package project.actions.obj;

import java.util.ArrayList;

import project.actions.employees_actions.main.object.Emp_addData;
import project.database.employee_customer.SQLs;

public class User_Data {
	
	private int amount;
	private String name;
	private String pass;
	
	
	public User_Data(String amount, String name, String pass) {
		String temp = amount.replace(" ", "");
		temp = amount.replace(",", "");
		
		this.amount = Integer.parseInt(temp);
		this.name = name;
		this.pass = pass;
	}
	
	public boolean test() {

		String[] datas = {name, pass};
		SQLs sql = new SQLs("À¯Àú", datas);

		System.out.println(sql.getEmpArr().size());
		if(sql.getEmpArr().size() != 0) {
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
	
}
