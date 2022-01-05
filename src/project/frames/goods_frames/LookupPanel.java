package project.frames.goods_frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import project.actions.goods_actions.GetComboBoxValue;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextArea;
import project.components.goods_components.GoodsTable;

public class LookupPanel extends JPanel {
	String val;
	public LookupPanel() {
		setLayout(null);
		add(new BasicSmallButton("전체") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicSmallButton("카테고리") {
			{
				setLocation(70, 0);
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
		
		String[] combo = {"전체", "카테고리", "거래처"};
		JComboBox<String> cb = new JComboBox<>(combo);
		cb.setSelectedIndex(0);
		cb.setBounds(325, 0, 100, 25);
		GetComboBoxValue cv = new GetComboBoxValue();
		val = cv.getComboValue(cb);
		cb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				val = cv.getComboValue(cb);
			}
		});
		add(cb);
		cb.setVisible(true);
		
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
		
		
		setBounds(300, 100, 760, 500);
		add(new GoodsTable());
		setVisible(true);
	}
}
