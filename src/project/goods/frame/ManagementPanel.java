package project.goods.frame;

import javax.swing.JPanel;

import project.goods.components.BasicLnbButton;
import project.goods.components.BasicTextArea;
import project.goods.components.GoodsTable;

public class ManagementPanel extends JPanel {
	public ManagementPanel() {
		
		add(new BasicLnbButton("입고") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("출고") {
			{
				setLocation(100, 0);
			}
		});
		
		add(new BasicLnbButton("폐기") {
			{
				setLocation(200, 0);
			}
		});
		
		add(new BasicLnbButton("반품") {
			{
				setLocation(300, 0);
			}
		});
		
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
