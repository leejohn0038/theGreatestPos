package project.goods.frames;

import java.awt.BorderLayout;
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
		
		add(new BasicLnbButton("��ü") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("ī�װ�") {
			{
				setLocation(70, 0);
			}
		});
		
		add(new BasicLnbButton("�������") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicLnbButton("�ŷ�ó") {
			{
				setLocation(210, 0);
			}
		});
		
		String[] combo = {"��ü", "ī�װ�", "�ŷ�ó"};
		JComboBox<String> cb = new JComboBox<>(combo);
		cb.setSelectedIndex(0);
		cb.setBounds(325, 0, 100, 25);
		GetComboValue cv = new GetComboValue();
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
		
		add(new BasicLnbButton("�˻�") {
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
