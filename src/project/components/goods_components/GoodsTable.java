package project.components.goods_components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class GoodsTable extends JPanel {
	private static final String[] COLUMN_NAME = {"상품번호", "이름", "수량", "가격", "거래처", "담당자"};
	String[][] rowDate = {};
	JTable table;
	JScrollPane sp; 
	
	public GoodsTable() {
		setLayout(new BorderLayout());
		setBounds(0, 50, 650, 400);
		
		table = new JTable(rowDate, COLUMN_NAME);
		table.setRowHeight(50);
		sp = new JScrollPane(table); 
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp);
		
		setVisible(true);
	}
	
}
