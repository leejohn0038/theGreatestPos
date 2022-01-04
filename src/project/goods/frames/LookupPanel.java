package project.goods.frames;

import javax.swing.JPanel;
import project.goods.components.BasicLnbButton;
import project.goods.components.BasicTextArea;
import project.goods.components.GoodsTable;

public class LookupPanel extends JPanel {
	
	public LookupPanel() {
		add(new BasicLnbButton("전체") {
			{
				setLocation(0, 0);
			}
		});
		
		add(new BasicLnbButton("카테고리") {
			{
				setLocation(100, 0);
			}
		});
		
		add(new BasicLnbButton("유통기한") {
			{
				setLocation(200, 0);
			}
		});
		
		add(new BasicLnbButton("거래처") {
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
