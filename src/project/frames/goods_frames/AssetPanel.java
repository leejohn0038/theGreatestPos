package project.frames.goods_frames;

import javax.swing.JPanel;

import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.GoodsTable;

public class AssetPanel extends JPanel {
	String sql = "SELECT * FROM goods";
	
	public AssetPanel() {
		
		add(new BasicTextField() {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicSmallButton("°Ë»ö") {
			{
				setLocation(600, 0);
			}
		});
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new GoodsTable(sql));
		setVisible(true);
	}
}
