package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JTextField;

import project.MainFrame;
import project.database.receipts_DB.ReceiptSearching;
import project.frames.receipts_frames.Receipts;

public class SearchSubmitButtonAL implements ActionListener {
	private final static HashMap<String, String> DEFAULT_VALUES = new HashMap<>();
	
	static {
		DEFAULT_VALUES.put("id1", "1");
		DEFAULT_VALUES.put("id2", "9999");
		DEFAULT_VALUES.put("phone1", "'010-0000-0000'");
		DEFAULT_VALUES.put("phone2", "'019-9999-9999'");		
		DEFAULT_VALUES.put("price1", "0");		
		DEFAULT_VALUES.put("price2", "999999999");
		DEFAULT_VALUES.put("payment", "'카드', '현금'");
		DEFAULT_VALUES.put("period1", "'2000/01/01'");
		DEFAULT_VALUES.put("period2", "'2100/12/31'");
	}
	String[] sqls;
	JTextField[] f;
	Receipts r;
	MainFrame main;

	
	public SearchSubmitButtonAL(MainFrame main, Receipts r, JTextField[] f) {
		this.r = r;
		this.f = f;
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		sqls = new String[9];
		for (int i = 0; i < f.length; ++i) {
			if (f[i].getText().equals("")) {
				sqls[i] = DEFAULT_VALUES.get(f[i].getName());
			} else {
				if (i <= 5 && i != 2 && i != 3) {
					sqls[i] = f[i].getText();
				} else {
					sqls[i] = String.format("'%s'", f[i].getText());
				}
			}
		}
		r.table.tableUpdate(ReceiptSearching.getData(sqls));
	}	
}
