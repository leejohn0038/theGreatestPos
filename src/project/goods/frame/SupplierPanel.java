package project.goods.frame;

import javax.swing.JPanel;

import project.goods.components.SupplierTable;

public class SupplierPanel extends JPanel {
	public SupplierPanel() {
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new SupplierTable());
		setVisible(true);
	}
	
}
