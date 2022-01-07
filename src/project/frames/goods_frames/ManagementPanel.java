package project.frames.goods_frames;

import javax.swing.JPanel;

import project.components.goods_components.BasicLnbButton;
import project.components.goods_components.BasicTextArea;
import project.components.goods_components.GoodsTable;

public class ManagementPanel extends JPanel {
	
	public ManagementPanel() {
		
		add(new BasicLnbButton("�԰�") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("���") {
			{
				setLocation(70, 0);
			}
		});
		
		add(new BasicLnbButton("���") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicLnbButton("��ǰ") {
			{
				setLocation(210, 0);
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
