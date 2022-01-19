package project.components.goods_components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class AssetShortageTable extends JPanel {
	DefaultTableModel model;
	
	public AssetShortageTable(Connection conn) {
		String[] column_name = {"번호", "이름", "수량", "담당자", "전화번호"};
		model = new DefaultTableModel(column_name, 0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		String gname, pic_name, pic_tel;
		int gid, gqty;
		
		try (
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM goods WHERE gqty <= 50");		
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				gid = rs.getInt("gid");
				gname = rs.getString("gname");
				gqty = rs.getInt("gqty");
				pic_name = rs.getString("pic_name");
				pic_tel = rs.getString("pic_tel");
				
				
				Object[] rowData = {gid, gname, gqty, pic_name, pic_tel};
				model.addRow(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout());
//		table.setBounds(0, 0, 500, 150);
		setSize(650, 230);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp);
	}
	
	public DefaultTableModel getTableModel() {
		return model;
	}
}
