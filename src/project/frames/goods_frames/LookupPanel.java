package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextArea;
import project.components.goods_components.GoodsTable;
import project.components.goods_components.CancelButton;

public class LookupPanel extends JPanel {
	String comboVal;
	String[] combo = {"전체", "카테고리", "거래처"};
	JComboBox<String> searchCb = new JComboBox<>(combo);
	JComboBox<String> categoryCb = new JComboBox<>(combo);
	String sql = "SELECT * FROM goods";
	
	public LookupPanel() {
		
		// 카테고리 선택용 팝업창
		BasicPopupPanel category = new BasicPopupPanel();
		categoryCb.setSelectedIndex(0);
		categoryCb.setBounds(20, 20, 200, 50);
		GetValues cv = new GetValues();
		categoryCb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboVal = cv.getComboBoxValue(categoryCb);
				System.out.println(comboVal);
			}
		});
		category.add(categoryCb);
		category.add(new CancelButton(category, 200, 200));
		add(category);

		// 상단 버튼 생성
		add(new BasicSmallButton("전체") {
			{
				setLocation(0, 0);
				
			}
		});
		
		add(new BasicSmallButton("카테고리") {
			{
				setLocation(70, 0);
				addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						category.setVisible(true);
					}
				});
			}
		});
		
		add(new BasicSmallButton("유통기한") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicSmallButton("거래처") {
			{
				setLocation(210, 0);
			}
		});
		
		// 검색창 생성
		searchCb.setSelectedIndex(0);
		searchCb.setBounds(325, 0, 100, 25);
		comboVal = cv.getComboBoxValue(searchCb);
		searchCb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboVal = cv.getComboBoxValue(searchCb);
			}
		});
		add(searchCb);
		searchCb.setVisible(true);
		
		add(new BasicTextArea() {
			{
				setLocation(425, 0);
			}
		});
		
		add(new BasicSmallButton("검색") {
			{
				setLocation(600, 0);
			}
		});
		
		
		
		GoodsTable gt = new GoodsTable(sql);
		choiceCategory();
		
		add(gt);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}
	
	public String getComboVal() {
		return comboVal;
	}
	
	String choiceCategory() {
		switch (comboVal) {
		case "전체":
			sql = "SELECT * FROM goods";
			break;
		case "카테고리":
			
			break;
		case "거래처":
			break;
		}
		return sql;
	}
	
	
	public static void main(String[] args) {
		new GoodsFrame();
	}
}





















































