package project.actions.customers_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CustomersAddBtn implements ActionListener {
	
	//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	ArrayList<Object> arrs = new ArrayList<>();
	String sql = "";
	
	// ��ư������ �����Ͱ� �޾ƿͼ� �����ϰ� TABAL ����
	public CustomersAddBtn() {
		//sql������
		sql = "INSERT INTO customers VALUES (?, '?', '?', '?', '?')";
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
