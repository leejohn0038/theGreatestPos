package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.MainFrame;


public class RefundingSubmitAL implements ActionListener {

	MainFrame main;
	
	public RefundingSubmitAL(MainFrame main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		System.out.println("Hello");
	}

}
