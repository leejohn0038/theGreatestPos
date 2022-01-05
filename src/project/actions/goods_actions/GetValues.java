package project.actions.goods_actions;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class GetValues {
	int val;
	
	public String getComboBoxValue(JComboBox cb) {
		return (String)cb.getSelectedItem();
	}
	
	public int getTextNumValue(JTextArea ta) {
		String temp = ta.getText();
		val = Integer.parseInt(temp);
		return val;
	}
}
