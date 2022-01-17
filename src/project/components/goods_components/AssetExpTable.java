package project.components.goods_components;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AssetExpTable extends JPanel {
	
	public AssetExpTable(Connection conn) {
		String[] column_name = {"��ȣ", "�̸�", "����", "�������"};
		DefaultTableModel model = new DefaultTableModel(column_name, 0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		String gname;
		int gid, gqty;
		Date expiration;
		
		try (
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM goods WHERE expiration - sysdate <= 10");		
			ResultSet rs = pstmt.executeQuery();
		) {
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
		setSize(650, 200);
		add(sp);
	}
}












