package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import project.database.DBConnector;
import project.frames.receipts_frames.Receipts;

public class SearchSubmitButtonAL implements ActionListener {
	JTextField[] f;
	Receipts r;

	
	public SearchSubmitButtonAL(Receipts r, JTextField[] f) {
		this.r = r;
		this.f = f;
	}
	
	public void actionPerformed(ActionEvent e) {
		String a = f[0].getText().trim();
		String b = f[1].getText().trim();
		r.table.tableUpdate(DBConnector.getData(a, b));
	}

	public static void main(String[] args) {
		
	}
}
