package project.frames.goods_frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.PosDBConnector;

public class ManagementPanel extends JPanel {
	static Connection conn;
	static {
		try {
			conn = PosDBConnector.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	JTable table;
	JScrollPane sp;
	
	String storeName;
	int storeQty;
	
	int gid;
	String gname;
	int gqty;
	int gprice;
	Date expiration;
	Date storedate;
	
	public ManagementPanel() {
		GetValues gv = new GetValues();
		
		BasicPopupPanel storePopup = new BasicPopupPanel();
		// �׽�Ʈ�� ��ư�� ����� ������ǰ�� �߰��ǰ� Ȯ���ϱ�
		storePopup.add(new JLabel("��ǰ�߰�") {
			{
				setBounds(20, 10, 100, 50);
				setFont(new Font("����", Font.BOLD, 20));
			}
		});
		
		BasicTextField nameTf = new BasicTextField("��ǰ�� �̸��� �Է����ּ���");
		nameTf.setLocation(20, 75);
		storePopup.add(nameTf);
		
		BasicTextField qtyTf = new BasicTextField("������ �Է����ּ���");
		qtyTf.setLocation(20, 120);
		storePopup.add(qtyTf);
		storePopup.add(new BasicSmallButton("�߰�") {
			{
				setLocation(140, 240);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						storeName = gv.getTextStringValue(nameTf);
						storeQty = gv.getTextNumValue(qtyTf);
						System.out.println(storeName);
						System.out.println("�߰�����: " + storeQty);
						System.out.println("���� ����: " + gqty);
						LocalDate now = LocalDate.now();
						if (gqty == 0 && storedate.toLocalDate().equals(now)) {
							String sql = "INSERT INTO gstore(gname, gqty) VALUES (?, ?)";
							try (
								PreparedStatement pstmt = conn.prepareStatement(sql);		
							) {
								pstmt.setString(1, storeName);
								pstmt.setInt(2, storeQty);
								pstmt.executeUpdate();
								conn.close();
								
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						} else {
							String sql = "UPDATE gstore SET gqty = ? WHERE gname = ?";
							try (
								PreparedStatement pstmt = conn.prepareStatement(sql);		
							) {
								pstmt.setInt(1, storeQty + gqty);
								pstmt.setString(2, storeName);
								pstmt.executeUpdate();
								conn.close();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
			}
		});
		add(storePopup);
		storePopup.add(new BasicSmallButton("���") {
			{
				setLocation(220, 240);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						storePopup.setVisible(false);
						
					}
				});
			}
		});
		
		add(new BasicSmallButton("�԰�") {
			{
				setLocation(0, 0);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						storePopup.setVisible(true);;
					}
				});
			}
		});
		
		add(new BasicSmallButton("���") {
			{
				setLocation(70, 0);
			}
		});
		
		add(new BasicSmallButton("���") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicSmallButton("��ǰ") {
			{
				setLocation(210, 0);
			}
		});
		
		add(new BasicTextField("�˻�� �Է����ּ���") {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicSmallButton("�˻�") {
			{
				setLocation(600, 0);
			}
		});
		storeTable();
		add(sp);
		sp.setBounds(0, 50, 650, 400);
		sp.setVisible(true);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
		
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	DefaultTableModel model;
	static String[] column_name = {"��ǰ��ȣ", "�̸�", "����", "����", "�������", "�԰���"};
	static Object[][] rowData;
	String sql = "SELECT goods.gid, goods.gname, gstore.gqty, goods.gprice, gstore.expiration, gstore.storedate "
			+ "FROM goods, gstore WHERE goods.gname = gstore.gname";
	
	void storeTable() {
		model = new DefaultTableModel(rowData, column_name);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		try (
//			Connection conn = PosDBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				while (rs.next()) {
					gid = rs.getInt("gid");
					gname = rs.getString("gname");
					gqty = rs.getInt("gqty");
					gprice = rs.getInt("gprice");
					expiration = rs.getDate("expiration");
					storedate = rs.getDate("storedate");
					
					Object[] temp = {gid, gname, gqty, gprice, expiration, storedate};
					model.addRow(temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		table.setRowHeight(50);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	}
	
	
}





























