package project.goods.frames;

import javax.swing.JPanel;

import project.goods.components.SupplierTable;

public class SupplierPanel extends JPanel {
	public static boolean visible = false;
	public SupplierPanel() {
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new SupplierTable());
		setVisible(visible);
	}
	
}
