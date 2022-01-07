package project.actions.goods_actions;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class GetValues {
	int val;
	
	public String getComboBoxValue(JComboBox cb) {
		return (String)cb.getSelectedItem();
	}
	
	public int getTextNumValue(JTextArea ta) {
		String tempStr = ta.getText();
		Object temp = Integer.parseInt(tempStr);
		return val;
	}
}
