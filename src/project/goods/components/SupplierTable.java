package project.goods.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class SupplierTable extends JPanel {
	public final static String[] COLUMN_NAME = {"거래처ID", "분류", "이름", "주소", "담당자", "담당자전화번호"}; 
	String[][] rowData = {};
	JTable table;
	JScrollPane sp;
	
	public SupplierTable() {
		setLayout(new BorderLayout());
		setBounds(0, 50, 650, 400);
		
		table = new JTable(rowData, COLUMN_NAME);
		table.setRowHeight(50);
		sp = new JScrollPane(table);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp);
		
		setVisible(true);
		
	}
}
