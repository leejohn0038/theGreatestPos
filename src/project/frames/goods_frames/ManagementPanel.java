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

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.PosDBConnector;
import project.components.goods_components.StoreTable;

public class ManagementPanel extends JPanel {
	static Connection conn;
	static {
		try {
			conn = PosDBConnector.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	static String[] column_name = {"��ǰ��ȣ", "�̸�", "����", "����", "�������", "�԰���"};
//	static Object[][] rowData;
//	static DefaultTableModel tmodel = new DefaultTableModel(rowData, column_name);
//	static JTable table = new JTable(tmodel);
//	static JScrollPane sp = new JScrollPane(table);;
	
	String sql = "SELECT goods.gid, goods.gname, gstore.gqty, goods.gprice, gstore.expiration, gstore.storedate "
			+ "FROM goods, gstore WHERE goods.gname(+) = gstore.gname";
	String addSql;
	String updateToGoods;
	
	String storeName;
	int storeQty;
	
	int gid;
	String gname;
	int gqty;
	int gprice;
	Date expiration;
	Date storedate;
	int cnt;
	int preGoodsQty;
	
	String addName;
	int addQty;
	Date addStoredate;
	
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
						LocalDate now = LocalDate.now();
						
						try (
							PreparedStatement cntPs = conn.prepareStatement("SELECT COUNT(*) FROM gstore WHERE gname = ?");
							PreparedStatement addPs = conn.prepareStatement("SELECT * FROM gstore WHERE gname = ?");
							PreparedStatement updateToGoods = conn.prepareStatement("UPDATE goods SET gqty = ? WHERE gname = ?");	
							PreparedStatement preGoodsQtyPs = conn.prepareStatement("SELECT gqty FROM goods WHERE gname = ?");
						) {
							cntPs.setString(1, storeName);
							addPs.setString(1, storeName);
							preGoodsQtyPs.setString(1, storeName);
							
							try (
								ResultSet cntRs = cntPs.executeQuery();
								ResultSet addRs = addPs.executeQuery();
								ResultSet preGQRs = preGoodsQtyPs.executeQuery();
							) {
								cntRs.next();
								cnt = cntRs.getInt("COUNT(*)");
								
								preGQRs.next();
								preGoodsQty = preGQRs.getInt("gqty");
								
								updateToGoods.setInt(1, preGoodsQty + storeQty);
								updateToGoods.setString(2, storeName);
								updateToGoods.executeUpdate();

								
								if (cnt == 0) {
									addSql = "INSERT INTO gstore(gname, gqty) VALUES (?, ?)";
									try (
											PreparedStatement pstmt = conn.prepareStatement(addSql);		
											) {
										pstmt.setString(1, storeName);
										pstmt.setInt(2, storeQty);
										pstmt.executeUpdate();
										storePopup.setVisible(false);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									
								} else if (cnt > 0 && storedate.toLocalDate().equals(now)) {
									addSql = "UPDATE gstore SET gqty = ? WHERE gname = ?";
									try (
											PreparedStatement pstmt = conn.prepareStatement(addSql);		
											) {
										pstmt.setInt(1, storeQty + gqty);
										pstmt.setString(2, storeName);
										pstmt.executeUpdate();
										storePopup.setVisible(false);
										
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									
								} else if (cnt > 0 && !storedate.toLocalDate().equals(now)) {
									addSql = "INSERT INTO gstore(gname, gqty) VALUES (?, ?)";
									try (
											PreparedStatement pstmt = conn.prepareStatement(addSql);		
											) {
										pstmt.setString(1, storeName);
										pstmt.setInt(2, storeQty);
										pstmt.executeUpdate();
										storePopup.setVisible(false);
										
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
								}
//								conn.close();
							}
							
						} catch (SQLException e2) {
							e2.printStackTrace();
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
//		add(sp);
//		sp.setBounds(0, 50, 650, 400);
//		sp.setVisible(true);
		add(new StoreTable());
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}
	
//	void storeTable() {
//		try (
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//		) {
//			try (
//				ResultSet rs = pstmt.executeQuery();
//			) {
//				while (rs.next()) {
//					gid = rs.getInt("gid");
//					gname = rs.getString("gname");
//					gqty = rs.getInt("gqty");
//					gprice = rs.getInt("gprice");
//					expiration = rs.getDate("expiration");
//					storedate = rs.getDate("storedate");
//					
//					Object[] temp = {gid, gname, gqty, gprice, expiration, storedate};
//					tmodel.addRow(temp);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		table.setRowHeight(50);
//		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		
//	}
	
	
}





























