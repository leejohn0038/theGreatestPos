package project.frames.goods_frames;

import javax.swing.JPanel;

import project.goods_components.BasicLnbButton;
import project.goods_components.BasicTextArea;
import project.goods_components.GoodsTable;

public class ManagementPanel extends JPanel {
	
	public ManagementPanel() {
		
		add(new BasicLnbButton("입고") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("출고") {
			{
				setLocation(70, 0);
			}
		});
		
		add(new BasicLnbButton("폐기") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicLnbButton("반품") {
			{
				setLocation(210, 0);
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
