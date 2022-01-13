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
import project.frames.receipts_frames.Receipts;

public class SearchSubmitButtonAL implements ActionListener {
	private final static HashMap<String, String[]> DEFAULT_VALUES = new HashMap<>();
	private final static HashMap<String, String> COMBO_VALUES = new HashMap<>();
	
	static {
		DEFAULT_VALUES.put("id1", new String[] {"1", Regex.getRegex()[0]});
		DEFAULT_VALUES.put("id2", new String[] {"9999", Regex.getRegex()[0]});
		DEFAULT_VALUES.put("phone1", new String[] {"'010-0000-0000'", Regex.getRegex()[1]});
		DEFAULT_VALUES.put("phone2", new String[] {"'019-9999-9999'", Regex.getRegex()[1]});		
		DEFAULT_VALUES.put("price1", new String[] {"0", Regex.getRegex()[2]});		
		DEFAULT_VALUES.put("price2", new String[] {"999999999", Regex.getRegex()[2]});
		DEFAULT_VALUES.put("period1", new String[] {"'2000/01/01'", Regex.getRegex()[3]});
		DEFAULT_VALUES.put("period2", new String[] {"'2100/12/31'", Regex.getRegex()[3]});
		COMBO_VALUES.put("전체", "'카드', '현금'");
		COMBO_VALUES.put("카드", "'카드'");
		COMBO_VALUES.put("현금", "'현금'");
	}
	String[] sqls;
	JTextField[] f;
	Receipts r;
	MainFrame main;
	JComboBox<String> com;
	
	public SearchSubmitButtonAL(MainFrame main, Receipts r, JTextField[] f, JComboBox<String> com) {
		this.r = r;
		this.f = f;
		this.main = main;
		this.com = com;
	}
	
	public void actionPerformed(ActionEvent e) {
		sqls = new String[9];
		boolean state = true;
		for (int i = 0; i < f.length; ++i) {
			if (f[i].getText().equals("")) {
				sqls[i] = DEFAULT_VALUES.get(f[i].getName())[0];
			} else {
				if (FieldRegexLimit.isValid(DEFAULT_VALUES.get(f[i].getName())[1], f[i].getText())) {					
					if (i <= 5 && i != 2 && i != 3) {
						sqls[i] = f[i].getText();
					} else {
						sqls[i] = String.format("'%s'", f[i].getText());
					}
				} else {
					state = false; 
				}
			}
		}
		sqls[8] = COMBO_VALUES.get(com.getSelectedItem().toString());
		if (state) {
			ArrayList<Object[]> datas = ReceiptSearching.getData(sqls);
			if (datas.size() == 0) {
				JOptionPane.showMessageDialog(main.getFrame("영수증 조회하기"), "조회된 영수증이 없습니다.");				
			} else {				
				r.getTable().updateRow(datas);	
				main.getFrame("영수증 조회하기").setVisible(false);
			}
		} else {
			JOptionPane.showMessageDialog(main.getFrame("영수증 조회하기"), "필드에 입력된 값이 잘못되었습니다.");
		}
	}	
}
