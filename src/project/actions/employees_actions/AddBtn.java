package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.actions.employees_actions.main.SQLs;

public class AddBtn implements ActionListener {
	
	String[] title;
	JLabel lab;
	ArrayList<JTextField> txt = new ArrayList<>();
	HashMap<String,Object> txts = new HashMap<>();

	public AddBtn(HashMap<String,Object> txts, String[] labs) {
		this.title = labs;
		this.txts = txts;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i<title.length; i++) {
			if(i==0) {
				lab = (JLabel) txts.get(title[i]);
				System.out.println(lab.getText());
			}else {
				txt.add((JTextField)txts.get(title[i]));
				System.out.println(txt.get(i-1).getText());
				//if()
			}
		}
		//new SQLs("µî·Ï");
	}
}
