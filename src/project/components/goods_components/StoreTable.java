package project.components.goods_components;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class StoreTable extends JPanel {
	String[] column_name = {"상품번호", "이름", "수량", "가격", "유통기한", "입고일"};
	Object[][] rowData;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane sp;
	
	String name;
	
	public StoreTable() {
		
		try (
			Connection conn = PosDBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM gstore INNER JOIN goods USING (gname)");
			ResultSet rs = pstmt.executeQuery();
		) {
			int i = 0;
			while (rs.next()) {
				
				name = rs.getString("gname");
				rowData[0][i] = name;
				i++;
			}
			
			
			model = new DefaultTableModel(rowData, column_name);
			table = new JTable(model);
			sp = new JScrollPane(table);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp);
		setBounds(0, 50, 650, 400);
		setVisible(true);
	}
	
	public DefaultTableModel getTableModel() {
		return model;
	}
}
















