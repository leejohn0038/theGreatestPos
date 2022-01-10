package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.CancelButton;
import project.components.goods_components.GoodsTable;

public class LookupPanel extends JPanel {
	String comboVal;
	String[] combo = {"전체", "카테고리", "거래처"};
	JComboBox<String> searchCb = new JComboBox<>(combo);
	JComboBox<String> categoryCb = new JComboBox<>(combo);
	StringBuffer input = new StringBuffer("SELECT * FROM goods WHERE ");
	String sql = "SELECT * FROM goods";
	public LookupPanel() {
		
		// 검색창 생성
		GoodsTable gt = new GoodsTable(sql);
		
		GetValues cv = new GetValues();
		searchCb.setBounds(375, 0, 100, 25);
		comboVal = cv.getComboBoxValue(searchCb);
		searchCb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboVal = cv.getComboBoxValue(searchCb);
				System.out.println(comboVal);
			}
		});
		add(searchCb);
		searchCb.setVisible(true);
		
		gt.getRowsorter().addRowSorterListener(null);
		add(new BasicTextField() {
			{
				setLocation(475, 0);
				
				getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent e) {
						String keyword = getText();
						
						if (keyword.trim().length() == 0) {
							gt.getRowsorter().setRowFilter(null);
						} else {
							gt.getRowsorter().setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
						}
					}
					
					@Override
					public void insertUpdate(DocumentEvent e) {
						String keyword = getText();
						
						if (keyword.trim().length() == 0) {
							gt.getRowsorter().setRowFilter(null);
						} else {
							gt.getRowsorter().setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
						}
					}
					
					@Override
					public void changedUpdate(DocumentEvent e) {
						throw new UnsupportedOperationException("Not supported yet.");
					}
				});
			}
		});
		
		add(gt);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}

	public String getComboVal() {
		return comboVal;
	}
	
}





















































