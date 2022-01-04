package project.goods.frame;

import javax.swing.JPanel;

import project.goods.components.BasicLnbButton;
import project.goods.components.BasicTextArea;
import project.goods.components.GoodsTable;

public class ManagementPanel extends JPanel {
	public ManagementPanel() {
		
		add(new BasicLnbButton("�԰�") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("���") {
			{
				setLocation(100, 0);
			}
		});
		
		add(new BasicLnbButton("���") {
			{
				setLocation(200, 0);
			}
		});
		
		add(new BasicLnbButton("��ǰ") {
			{
				setLocation(300, 0);
			}
		});
		
		add(new BasicTextArea() {
			{
				setLocation(400, 0);
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
