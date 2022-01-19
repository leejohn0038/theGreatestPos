package project.frames.employees_frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.components.employees_companents.MainContants;
import project.components.employees_companents.NavBar;
import project.database.employee_customer.SQLs;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		SQLs sql = new SQLs("����", 1);
		
		MainContants jp = new MainContants(main, this, sql, 1);
		add(jp);
		pack();
		
		setTitle("����");
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
	}
}




