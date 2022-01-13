package project.actions.goods_actions;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class GetValues {
	String stringVal;
	int numVal;
	Date dateVal;
	
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
	
	public Date getTextDateValue(JTextField tf) {
		String tempStr = tf.getText();
		
		if (tempStr.equals("YYYYMMDD")) {
			
			dateVal = null;
		} else if (tempStr.equals("YYYYMMDD")) {
			
			SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
			SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
			
			java.util.Date tempDate = null;
			try {
				tempDate = beforeFormat.parse(tempStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String transDate = afterFormat.format(tempDate);
			dateVal = Date.valueOf(transDate);
		}
		
		return dateVal;
	}
}












