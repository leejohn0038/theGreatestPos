package project.actions.goods_actions;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class GetValues {
	String stringVal;
	int numVal;
	
	public String getComboBoxValue(JComboBox cb) {
		return (String)cb.getSelectedItem();
	}
	
	public String getTextStringValue(JTextField tf) {
		stringVal = tf.getText();
		return stringVal;
	}
	
	public int getTextNumValue(JTextField tf) {
		String tempStr = tf.getText();
		numVal = Integer.parseInt(tempStr);
		return numVal;
	}
}
