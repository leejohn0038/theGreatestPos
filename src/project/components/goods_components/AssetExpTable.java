package project.components.goods_components;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class AssetExpTable extends JPanel {
	private DefaultTableModel model;
	int gid, gqty, expStandard;
	String gname;
	Date expiration;
	
	public AssetExpTable(Connection conn) {
		String[] column_name = {"번호", "이름", "수량", "유통기한"};
		model = new DefaultTableModel(column_name, 0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		try (
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM goods WHERE expiration - sysdate <= ?");		
		) {
			pstmt.setInt(1, 10);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				gid = rs.getInt("gid");
				gname = rs.getString("gname");
				gqty = rs.getInt("gqty");
				expiration = rs.getDate("expiration");
				
				
				Object[] rowData = {gid, gname, gqty, expiration};
				model.addRow(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.WHITE);	
		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setSize(720, 230);
		sp.getViewport().setBackground(Color.WHITE);
		add(sp);
	}
	
	public int editExp(int val) {
		expStandard = val;
		return expStandard;
	}
	
	public DefaultTableModel getTableModel() {
		return model;
	}
}












