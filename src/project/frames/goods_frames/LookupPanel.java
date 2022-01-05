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
	String[] combo = {"전체", "카테고리", "거래처"};
	JComboBox<String> searchCb = new JComboBox<>(combo);
	JComboBox<String> categoryCb = new JComboBox<>(combo);
	String comboVal;
	String sql = "SELECT * FROM goods";
	
	public LookupPanel() {
		
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
		
		searchCb.setSelectedIndex(0);
		searchCb.setBounds(325, 0, 100, 25);
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
		add(new GoodsTable(sql));
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GoodsFrame();
	}
}





















































