package project.employees.components.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AddBtn implements ActionListener {
	
	//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	ArrayList<Object> arrs = new ArrayList<>();
	String sql = "";
	
	// ��ư������ �����Ͱ� �޾ƿͼ� �����ϰ� TABAL ����
	public AddBtn() {
		//sql������
		sql = "INSERT INTO mart_employees VALUES (?, '?', '?', '?', '?')";
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
