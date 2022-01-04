package project.goods.actions;

import javax.swing.JComboBox;

public class GetComboValue {

	public String getComboValue(JComboBox cb) {
		return (String) cb.getSelectedItem();
	}
}
