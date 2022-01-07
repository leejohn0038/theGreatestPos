package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextArea;
import project.components.goods_components.CancelButton;
import project.components.goods_components.GoodsTable;

public class LookupPanel extends JPanel {
	String comboVal;
	String[] combo = {"�̸�", "ī�װ�", "�ŷ�ó"};
	JComboBox<String> searchCb = new JComboBox<>(combo);
	JComboBox<String> categoryCb = new JComboBox<>(combo);
	String sql = "SELECT * FROM goods";
	
	public LookupPanel() {
		
		// ī�װ� ���ÿ� �˾�â
		BasicPopupPanel category = new BasicPopupPanel();
		categoryCb.setSelectedIndex(0);
		categoryCb.setBounds(20, 20, 200, 50);
		GetValues cv = new GetValues();
		categoryCb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboVal = cv.getComboBoxValue(categoryCb);
			}
		});
		category.add(categoryCb);
		category.add(new CancelButton(category, 200, 200));
		add(category);

		// ��� ��ư ����
		add(new BasicSmallButton("�̸�") {
			{
				setLocation(0, 0);
				
			}
		});
		
		add(new BasicSmallButton("ī�װ�") {
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
		
		add(new BasicSmallButton("�������") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicSmallButton("�ŷ�ó") {
			{
				setLocation(210, 0);
			}
		});
		
		// �˻�â ����
		GoodsTable gt = new GoodsTable(sql);
//		searchCb.setSelectedIndex(0);
		searchCb.setBounds(325, 0, 100, 25);
		comboVal = cv.getComboBoxValue(searchCb);
		searchCb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboVal = cv.getComboBoxValue(searchCb);
				System.out.println(comboVal);
				System.out.println(choiceCategory(comboVal));
				
			}
		});
		add(searchCb);
		searchCb.setVisible(true);
		
		add(new BasicTextArea() {
			{
				setLocation(425, 0);
			}
		});
		
		add(new BasicSmallButton("�˻�") {
			{
				setLocation(600, 0);
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
	
	String choiceCategory(String comboVal) {
		switch (comboVal) {
		case "�̸�":
			sql = "SELECT * FROM goods WHERE pic_name LIKE \'%��%\'";
			break;
		case "ī�װ�":
			sql = "SELECT * FROM goods WHERE gcategory LIKE \'%����%\'";
			break;
		case "�ŷ�ó":
			break;
		}
		return sql;
	}
	
	
	public static void main(String[] args) {
		new GoodsFrame();
	}
}





















































