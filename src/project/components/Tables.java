package project.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Tables extends JPanel {
	private static final String[] COLUMNNAME = {"상품ID", "구매시기", "상품이름", "수량", "개수"};

	JTable table;
	JScrollPane sp;
	String[][] rowData = {};
	
	public Tables() {
		setLayout(new BorderLayout());
		setBounds(300, 100, 680, 300);
		
		table = new JTable(rowData ,COLUMNNAME);
		sp = new JScrollPane(table);
		table.setRowHeight(50);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(sp);
	}
	// 오버로딩으로 테이브 위치 및 크기 조정 가능
	public Tables(int xPos, int yPos, int ySize) {
		setLayout(new BorderLayout());
		setBounds(xPos, yPos, 680, ySize);
		
		table = new JTable(rowData ,COLUMNNAME);
		sp = new JScrollPane(table);
		table.setRowHeight(50);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(sp);
	}
}
