package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextArea;
import project.components.goods_components.SupplierTable;

public class SupplierPanel extends JPanel {
	String val;
	
	public SupplierPanel() {
		
		String[] combo = {"거래처명", "담당자"};
		JComboBox<String> cb = new JComboBox<>(combo);
		GetValues cv = new GetValues();
		cb.setBounds(325, 0, 75, 25);
		cb.setVisible(true);
		val = cv.getComboBoxValue(cb);
		cb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				val = cv.getComboBoxValue(cb);
			}
		});
		add(cb);
		
		add(new BasicTextArea() {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicSmallButton("검색") {
			{
				setLocation(600, 0);
			}
		});
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new SupplierTable());
		setVisible(true);
	}
	
}
