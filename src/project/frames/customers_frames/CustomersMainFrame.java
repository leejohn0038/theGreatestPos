package project.frames.customers_frames;

import javax.swing.JFrame;

import project.components.customers_components.CustomersInputButton;



public class CustomersMainFrame extends JFrame {
	
	public CustomersMainFrame() {
		new CustomersInputButton();
		
		

	}
	public static void main(String[] args) {
		new CustomersMainFrame();
	}
}
