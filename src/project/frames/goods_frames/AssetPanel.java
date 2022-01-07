package project.frames.goods_frames;

import javax.swing.JPanel;

import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextArea;
import project.components.goods_components.GoodsTable;

public class AssetPanel extends JPanel {
	public AssetPanel() {
		
		add(new BasicTextArea() {
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
		//add(new GoodsTable());
		setVisible(true);
	}
}
