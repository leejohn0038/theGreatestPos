package project.frames.goods_frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextArea;
import project.components.goods_components.GoodsTable;

public class ManagementPanel extends JPanel {
	
	public ManagementPanel() {
		BasicPopupPanel store = new BasicPopupPanel();
		store.add(new BasicTextArea() {
			{
				setLocation(100, 20);
			}
		});
		add(store);
		
		add(new BasicSmallButton("입고") {
			{
				setLocation(0, 0);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						store.setVisible(true);;
					}
				});
			}
		});
		
		add(new BasicSmallButton("출고") {
			{
				setLocation(70, 0);
			}
		});
		
		add(new BasicSmallButton("폐기") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicSmallButton("반품") {
			{
				setLocation(210, 0);
			}
		});
		
		add(new BasicTextArea() {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicSmallButton("검색") {
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
