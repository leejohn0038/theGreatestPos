package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import project.actions.SearchTf;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.GoodsTable;

public class LookupPanel extends JPanel {
	private GoodsTable goods;
	private BasicSmallButton searchClear;
	private BasicTextField searchTf;
	
	public LookupPanel() {
		
		// 검색창 생성
		goods = new GoodsTable();
		searchTf = new BasicTextField("");
		searchTf.setLocation(475, 0);
		goods.getRowsorter().addRowSorterListener(null);
		new SearchTf(goods.getRowsorter(), searchTf);
		searchTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 10) {
					
				}
			}
		});
		add(searchTf);
		searchClear = new BasicSmallButton("X");
		searchClear.setLocation(150, 0);
		searchClear.setSize(25, 25);
		searchClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTf.setText("");				
			}
		});
		searchTf.add(searchClear);
		searchTf.setLayout(null);
		
		add(goods);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}

	public GoodsTable getLookupTable() {
		return goods;
	}
}





















































