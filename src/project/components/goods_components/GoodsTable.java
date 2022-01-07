package project.components.goods_components;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class GoodsTable extends JPanel {
	private static final String[] COLUMN_NAME = {"상품번호", "이름", "수량", "가격", "분류", "거래처", "담당자"};
	Object[][] rowData;
	JTable table;
	JScrollPane sp; 
	int gid;
	String gname;
	int gqty;
	int gprice;
	String supplier;
	String gcategory;
	Date expiration;
	String pic_name;
	String pic_tel;
	
	String sql = "SELECT * FROM goods WHERE ? = ?";
	
	public GoodsTable() {
		DefaultTableModel model = new DefaultTableModel(rowData, COLUMN_NAME);
		table = new JTable(model);
		sp = new JScrollPane(table); 
		
		try (
			Connection conn = PosDBConnector.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			String word = "'''gid'''";
			int num = 1;
			
			pstmt.setString(1, word);
			pstmt.setInt(2, num);
			try (
				ResultSet rs = pstmt.executeQuery();		
			) {
				while (rs.next()) {
					gid = rs.getInt("gid");
					gname = rs.getString("gname");
					gqty = rs.getInt("gqty");
					gprice = rs.getInt("gprice");
					supplier = rs.getString("supplier");
					gcategory = rs.getString("gcategory");
					expiration = rs.getDate("expiration");
					pic_name = rs.getString("pic_name");
					pic_tel = rs.getString("pic_tel");
					
					Object[] temp = {gid, gname, gqty, gprice, gcategory, supplier, pic_name};
					
					model.addRow(temp);
				}
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
