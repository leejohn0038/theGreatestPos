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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StoreTable extends JPanel {
	String[] column_name = {"상품번호", "이름", "수량", "가격", "유통기한", "입고일"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane sp;
	TableRowSorter<TableModel> rowSorter;
	
	String strdName;
	int strdNum, strdQty, strdPrice;
	Date strdExp, strdDate;
	
	public StoreTable() {
		model = new DefaultTableModel(column_name, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		try (
			Connection conn = PosDBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement
					("SELECT g.gid, gs.gname, gs.gqty, g.gprice, gs.expiration, gs.storedate FROM gstore gs INNER JOIN goods g ON g.gname = gs.gname");
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				strdNum = rs.getInt("gid");
				strdName = rs.getString("gname");
				strdQty = rs.getInt("gqty");
				strdPrice = rs.getInt("gprice");
				strdExp = rs.getDate("expiration");
				strdDate = rs.getDate("storedate");
				
				Object[] addVal = {strdNum, strdName, strdQty, strdPrice, strdExp, strdDate};
				model.addRow(addVal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.WHITE);		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp);
		setBounds(0, 60, 750, 490);
//		sp.getViewport().setBackground(Color.YELLOW);
		sp.getViewport().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public DefaultTableModel getTableModel() {
		return model;
	}
	
	public String[]	getColumnName() {
		return column_name;
	}
	
	public TableRowSorter<TableModel> getRowsorter() {
		return rowSorter;
	}

	public JTable getTable() {
		return table;
	}
}
















