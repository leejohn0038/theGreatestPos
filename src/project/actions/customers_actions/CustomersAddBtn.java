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
	
	// 버튼누르면 데이터값 받아와서 저장하고 TABAL 전달
	public CustomersAddBtn() {
		//sql문으로
		sql = "INSERT INTO customers VALUES (?, '?', '?', '?', '?')";
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
