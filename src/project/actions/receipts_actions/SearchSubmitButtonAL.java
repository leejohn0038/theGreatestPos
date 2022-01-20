package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project.MainFrame;
import project.database.receipts_DB.ReceiptSearching;
import project.frames.receipts_frames.ReceiptSearch;
import project.frames.receipts_frames.Receipts;

public class SearchSubmitButtonAL implements ActionListener {
	private final static HashMap<String, String[]> DEFAULT_VALUES = new HashMap<>();
	
	static {
		DEFAULT_VALUES.put("id1", new String[] {"1", Regex.getRegex()[0]});
		DEFAULT_VALUES.put("id2", new String[] {"9999", Regex.getRegex()[0]});
		DEFAULT_VALUES.put("phone1", new String[] {"010-0000-0000", Regex.getRegex()[1]});
		DEFAULT_VALUES.put("phone2", new String[] {"019-9999-9999", Regex.getRegex()[1]});		
		DEFAULT_VALUES.put("price1", new String[] {"0", Regex.getRegex()[2]});		
		DEFAULT_VALUES.put("price2", new String[] {"999999999", Regex.getRegex()[2]});
		DEFAULT_VALUES.put("period1", new String[] {"2000/01/01", Regex.getRegex()[3]});
		DEFAULT_VALUES.put("period2", new String[] {"2100/12/31", Regex.getRegex()[3]});
	}
	MainFrame main;
	JTextField[] fields;
	Receipts receipts;
	JComboBox<String> combo;
	String[] sqls;
	
	public SearchSubmitButtonAL(MainFrame main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		receipts = (Receipts)main.getFrame("영수증"); 
		fields = ((ReceiptSearch)main.getFrame("영수증 조회하기")).getField();
		combo = ((ReceiptSearch)main.getFrame("영수증 조회하기")).getCombo();
		sqls = new String[9];
		boolean state = true;
		boolean isEmpty = true;
		for (int i = 0; i < fields.length; ++i) {
			if (fields[i].getText().equals("")) {
				sqls[i] = DEFAULT_VALUES.get(fields[i].getName())[0];
			} else {
				if (FieldRegexLimit.isValid(DEFAULT_VALUES.get(fields[i].getName())[1], fields[i].getText())) {					
					if (fields[i].getName().contains("phone")) {
						isEmpty &= false;
					}
					sqls[i] = fields[i].getText();
				} else {
					state = false;
					break;
				}
			}
		}
		if (state) {
			sqls[8] = combo.getSelectedItem().toString();
			ArrayList<Object[]> datas = ReceiptSearching.getDatas(sqls, isEmpty);
			if (datas.size() == 0) {
				JOptionPane.showMessageDialog(main.getFrame("영수증 조회하기"), "조회된 영수증이 없습니다.");				
			} else {				
				receipts.getTable().updateRows(datas);	
				main.getFrame("영수증 조회하기").setVisible(false);
			}
		} else {
			JOptionPane.showMessageDialog(main.getFrame("영수증 조회하기"), "필드에 입력된 값이 잘못되었습니다.");
		}
	}	
}
