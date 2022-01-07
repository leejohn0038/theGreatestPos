package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddBtn implements ActionListener {
	
	JFrame f;
	String[] title;
	JLabel lab;
	ArrayList<JTextField> txt = new ArrayList<>();
	HashMap<String,Object> txts = new HashMap<>();

	public AddBtn(JFrame f, HashMap<String,Object> txts, String[] labs) {
		this.f = f;
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
				JTextField tempTxt = (JTextField)txts.get(title[i]);
				if(i == 2 && Pattern.matches("010\\-\\d{4}\\-\\d{4}", txt.get(i-1).getText())){
					txt.add(tempTxt);
				}else {	
					i = i <= 0 ? i : i--;
				}
				System.out.println();
				//if()
			}
		}
		//new SQLs("µî·Ï");
		
		
		f.dispose();
		
	}
}
