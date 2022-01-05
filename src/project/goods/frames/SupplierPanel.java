package project.goods.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import project.goods.actions.GetComboBoxValue;
import project.goods.components.BasicLnbButton;
import project.goods.components.BasicTextArea;
import project.goods.components.SupplierTable;

public class SupplierPanel extends JPanel {
	String val;
	
	public SupplierPanel() {
		
		String[] combo = {"거래처명", "담당자"};
		JComboBox<String> cb = new JComboBox<>(combo);
		GetComboBoxValue cv = new GetComboBoxValue();
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
		add(new SupplierTable());
		setVisible(true);
	}
	
}
