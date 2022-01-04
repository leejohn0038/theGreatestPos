package project.goods.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import project.goods.actions.GetComboValue;
import project.goods.components.BasicLnbButton;
import project.goods.components.BasicTextArea;
import project.goods.components.GoodsTable;

public class LookupPanel extends JPanel {
	String val;
	public LookupPanel() {
		
		add(new BasicLnbButton("전체") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("카테고리") {
			{
				setLocation(70, 0);
			}
		});
		
		add(new BasicLnbButton("유통기한") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicLnbButton("거래처") {
			{
				setLocation(210, 0);
			}
		});
		
		String[] combo = {"전체", "카테고리", "거래처"};
		JComboBox<String> cb = new JComboBox<>(combo);
		GetComboValue cv = new GetComboValue();
		cb.setBounds(325, 0, 75, 25);
		cb.setVisible(true);
		val = cv.getComboValue(cb);
		cb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				val = cv.getComboValue(cb);
			}
		});
		add(cb);
		
		add(new BasicTextArea() {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicLnbButton("검색") {
			{
				setLocation(600, 0);
			}
		});
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new GoodsTable());
		setVisible(true);
	}
}
