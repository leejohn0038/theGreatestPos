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

public class StoreTable extends JPanel {
	String[] column_name = {"상품번호", "이름", "수량", "가격", "유통기한", "입고일"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane sp;
	
	int strdNum;
	String strdName;
	int strdQty;
	int strdPrice;
	Date strdExp;
	Date strdDate;
	
	public StoreTable() {
		model = new DefaultTableModel(column_name, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		try (
			Connection conn = PosDBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM gstore INNER JOIN goods USING (gname)");
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				strdNum = rs.getInt("gid");
				strdName = rs.getString("gname");
				strdPrice = rs.getInt("gprice");
				strdExp = rs.getDate("expiration");
				strdDate = rs.getDate("storedate");
				
				Object[] addVal = {strdNum, strdName, strdPrice, strdExp, strdDate};
				model.addRow(addVal);
			}
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
	
	public String[]	getColumnName() {
		return column_name;
	}
}
















