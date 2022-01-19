package project.frames.goods_frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import project.actions.SearchTf;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.GoodsTable;

public class LookupPanel extends JPanel {
	private GoodsTable goods;
	private BasicSmallButton searchClear;
	private BasicTextField searchTf;
	private JPanel addCategory;
	
	public LookupPanel() {
		
		// 검색창 생성
		goods = new GoodsTable();
		searchTf = new BasicTextField("");
		searchTf.setLocation(0, 20);
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
		searchClear.setLocation(175, 0);
		searchClear.setSize(25, 25);
		searchClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTf.setText("");				
			}
		});
		searchTf.add(searchClear);
		searchTf.setLayout(null);
		
		addCategory = new JPanel();
		addCategory.setSize(720, 130);
		addCategory.setLocation(0, 510);
		addCategory.setBackground(Color.WHITE);
		addCategoryPanel(addCategory);
		add(addCategory);
		
		setBackground(Color.WHITE);
		add(goods);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}

	public GoodsTable getLookupTable() {
		return goods;
	}
	
	void addCategoryPanel(JPanel panel) {
		panel.setLayout(null);
		panel.add(new JLabel("상품추가") {
			{
				setBounds(0, 0, 100, 50);
				setFont(new Font("돋움", Font.BOLD, 20));
			}
		});
		
		BasicTextField goodsNameTf = new BasicTextField();
		goodsNameTf.setLocation(0, 40);
		panel.add(goodsNameTf);
		
		BasicTextField goodsPriceTf = new BasicTextField();
		goodsPriceTf.setLocation(0, 70);
		panel.add(goodsPriceTf);
		
		BasicTextField goodsCategoryTf = new BasicTextField();
		goodsCategoryTf.setLocation(0, 100);
		panel.add(goodsCategoryTf);
		
		BasicTextField goodsSupplierTf = new BasicTextField();
		goodsSupplierTf.setLocation(200, 40);
		panel.add(goodsSupplierTf);
		
		BasicTextField goodsPicNameTf = new BasicTextField();
		goodsPicNameTf.setLocation(200, 70);
		panel.add(goodsPicNameTf);
		
		BasicTextField goodsPicTelTf = new BasicTextField();
		goodsPicTelTf.setLocation(200, 100);
		panel.add(goodsPicTelTf);
		
		
	}
}




































































