package project.goods.frame;

import javax.swing.JPanel;

import project.goods.components.BasicLnbButton;
import project.goods.components.BasicTextArea;
import project.goods.components.SupplierTable;

public class SupplierPanel extends JPanel {
	public SupplierPanel() {
		
		add(new BasicTextArea() {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicLnbButton("°Ë»ö") {
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
