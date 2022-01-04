package project.goods.frames;

import javax.swing.JPanel;
import project.goods.components.BasicLnbButton;
import project.goods.components.BasicTextArea;
import project.goods.components.GoodsTable;

public class LookupPanel extends JPanel {
	
	public LookupPanel() {
		add(new BasicLnbButton("��ü") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("ī�װ�") {
			{
				setLocation(100, 0);
			}
		});
		
		add(new BasicLnbButton("�������") {
			{
				setLocation(200, 0);
			}
		});
		
		add(new BasicLnbButton("�ŷ�ó") {
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
