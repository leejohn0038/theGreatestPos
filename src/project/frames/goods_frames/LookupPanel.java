package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import project.actions.SearchTf;
import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.CancelButton;
import project.components.goods_components.GoodsTable;

public class LookupPanel extends JPanel {
	private String comboVal;
	private String[] combo = {"전체", "카테고리", "거래처"};
	private JComboBox<String> searchCb = new JComboBox<>(combo);
	private JComboBox<String> categoryCb = new JComboBox<>(combo);
	private GoodsTable goods;
	
	public LookupPanel() {
		
		// 검색창 생성
		goods = new GoodsTable();
		GetValues gv = new GetValues();
		
		searchCb.setBounds(375, 0, 100, 25);
		comboVal = gv.getComboBoxValue(searchCb);
		searchCb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboVal = gv.getComboBoxValue(searchCb);
				System.out.println(comboVal);
			}
		});
		add(searchCb);
		searchCb.setVisible(true);
		
		BasicTextField searchTf = new BasicTextField("검색어를 입력해주세요");
		searchTf.setLocation(475, 0);
		goods.getRowsorter().addRowSorterListener(null);
		new SearchTf(goods.getRowsorter(), searchTf);
		add(searchTf);
		
		add(goods);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}

	public String getComboVal() {
		return comboVal;
	}
	
	public GoodsTable getLookupTable() {
		return goods;
	}
}





















































