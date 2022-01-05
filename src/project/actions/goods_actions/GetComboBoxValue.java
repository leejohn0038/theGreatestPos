package project.actions.goods_actions;

import javax.swing.JComboBox;

public class GetComboBoxValue {

	public String getComboValue(JComboBox cb) {
		return (String) cb.getSelectedItem();
	}
}
