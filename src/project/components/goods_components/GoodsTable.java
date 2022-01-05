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

public class GoodsTable extends JPanel {
	private static final String[] COLUMN_NAME = {"상품번호", "이름", "수량", "가격", "거래처", "담당자"};
	Object[][] rowData;
	JTable table;
	JScrollPane sp; 
	int gid;
	String gname;
	int gqty;
	int gprice;
	String supplier;
	int picid;
	
	public GoodsTable(String sql) {
		DefaultTableModel model = new DefaultTableModel(rowData, COLUMN_NAME);
		table = new JTable(model);
		sp = new JScrollPane(table); 
		
		try (
			Connection conn = PosDBConnector.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				gid = rs.getInt("gid");
				gname = rs.getString("gname");
				gqty = rs.getInt("gqty");
				gprice = rs.getInt("gprice");
				supplier = rs.getString("supplier");
				picid = rs.getInt("picid");
				
				Object[] temp = {gid, gname, gqty, gprice, supplier, picid};
				
				model.addRow(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		setBounds(0, 50, 650, 400);
		
		
		table.setRowHeight(50);
		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp);
		
		setVisible(true);
	}
	
}
