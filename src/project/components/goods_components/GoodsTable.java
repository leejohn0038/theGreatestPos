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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GoodsTable extends JPanel {
	private static final String[] COLUMN_NAME = {"상품번호", "이름", "수량", "가격", "분류", "유통기한", "거래처", "담당자"};
	String gname, supplier, gcategory, pic_name, pic_tel;
	int gid, gqty, gprice;
	Date expiration;
	
	DefaultTableModel model;
	TableRowSorter<TableModel> rowSorter;
	private JTable table;
	DefaultTableCellRenderer renderer;
	
	public GoodsTable() {
		model = new DefaultTableModel(COLUMN_NAME, 0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table); 
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		renderer = new DefaultTableCellRenderer();
		
		try (
			Connection conn = PosDBConnector.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM goods");
		) {
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
					
					Object[] temp = {gid, gname, gqty, gprice, gcategory, expiration, supplier, pic_name};
					model.addRow(temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table.setEnabled(false);
		setLayout(new BorderLayout());
		setBounds(0, 60, 720, 450);
		table.setRowHeight(50);
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.WHITE);	
		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(sp);
		
		setVisible(true);
	}
	
	public TableRowSorter<TableModel> getRowsorter() {
		return rowSorter;
	}
	
	public DefaultTableModel getTableModel() {
		return model;
	}
	
	public JTable getTable() {
		return table;
	}
}




















