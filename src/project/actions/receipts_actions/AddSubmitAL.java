package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project.MainFrame;
import project.database.receipts_DB.Adding;
import project.frames.receipts_frames.AddCustomer;

public class AddSubmitAL implements ActionListener {
	
	MainFrame main;
	
	public AddSubmitAL(MainFrame main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		AddCustomer addCus = (AddCustomer)main.getFrame("고객등록");
		JTextField[] fields = addCus.getFields();
		String now = LocalDate.now().toString();
		if(FieldRegexLimit.isValid(Regex.getRegex()[1], fields[1].getText())) {
			boolean state = Adding.insertCustomer(fields, now);
			if (!state) {				
				JOptionPane.showMessageDialog(addCus, "이미 등록된 회원입니다. ");
			} else {				
				JOptionPane.showMessageDialog(addCus, "회원등록이 완료되었습니다.");
				addCus.setVisible(false);
			} 
		} else {
			JOptionPane.showMessageDialog(addCus, "입력형식이 잘못되었습니다.");
		}
		
	}

}
