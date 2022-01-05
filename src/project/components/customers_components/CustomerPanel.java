package project.components.customers_components;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class CustomerPanel extends JFrame {
	
	public CustomerPanel() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		JPanel panel1_1 = new JPanel();
		panel1_1.setLayout(new BorderLayout());
		
//		panel1.add(new JLabel("border layout"), "South");
//		panel1.add(panel1_1, "Center");
//		
//		panel1_1.add(new JButton("South"), "South");
//		panel1_1.add(new JButton("North"), "North");
//		panel1_1.add(new JButton("Center"), "Center");
//		panel1_1.add(new JButton("East"), "East");
//		panel1_1.add(new JButton("West"), "West");
		
		add(panel1);
//		add(new JButton("000"));
//		add(new JButton("123"));
//		add(new JButton("123"));
		
		setLayout(null);
		setTitle("JPanel");
		setBounds(100, 100, 1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new CustomerPanel();
	}
}
