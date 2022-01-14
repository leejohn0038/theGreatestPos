package project.actions.employees_actions.main.object;

public class Employee {
	public Object[] obj;
	
	public Employee(Object[] obj) {
		this.obj = obj;
		
	}
	
	public Object[] getDate() {
		return obj;
	}
	
	public int getObjSize() {
		return obj.length;
	}
}
