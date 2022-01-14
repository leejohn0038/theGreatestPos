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
import javax.swing.table.DefaultTableModel;

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.PosDBConnector;
import project.components.goods_components.StoreTable;

public class ManagementPanel extends JPanel {
	
	DefaultTableModel dtm;
	String updateToGoods, importName, exportName, gname, addName;
	int importQty, exportQty, preGoodsQty, addQty, gid, gqty, gprice, cnt; 
	Date importExp, expiration, storedate, addStoredate;
	BasicSmallButton confirmBtn, cancleBtn, importBtn, exportBtn;
	BasicTextField importNameTf, importQtyTf, importExpTf, exportNameTf, exportQtyTf;
	
	public ManagementPanel() {
		
		StoreTable storeTable = new StoreTable();
		GetValues gv = new GetValues();
		LookupPanel lp = new LookupPanel();
		dtm = storeTable.getTableModel();
		
		try {
			Connection conn = PosDBConnector.getConnection();		
			BasicPopupPanel importPop = new BasicPopupPanel();
			importPopupPanel(importPop);
			
			importPop.add(new BasicSmallButton("입고") {
				{
					setLocation(140, 240);
					addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							importName = gv.getTextStringValue(importNameTf);
							importQty = gv.getTextNumValue(importQtyTf);
							importExp = gv.getTextDateValue(importExpTf);
							
							LocalDate now = LocalDate.now();
							
							try (
								PreparedStatement cntPs = conn.prepareStatement("SELECT COUNT(*) FROM gstore WHERE gname = ?");
								PreparedStatement updateToGoods = conn.prepareStatement("UPDATE goods SET gqty = ? WHERE gname = ?");	
								PreparedStatement preGoodsQtyPs = conn.prepareStatement("SELECT gqty FROM goods WHERE gname = ?");
								PreparedStatement paintManagePs = conn.prepareStatement("SELECT * FROM goods WHERE gname = ?");
							) {
								cntPs.setString(1, importName);
								preGoodsQtyPs.setString(1, importName);
								paintManagePs.setString(1, importName);
								try (
									ResultSet cntRs = cntPs.executeQuery();
									ResultSet preGQRs = preGoodsQtyPs.executeQuery();
									ResultSet paintRs = paintManagePs.executeQuery();
								) {
									cntRs.next();
									cnt = cntRs.getInt("COUNT(*)");
									
									preGQRs.next();
									preGoodsQty = preGQRs.getInt("gqty");
									
									updateToGoods.setInt(1, preGoodsQty + importQty);
									updateToGoods.setString(2, importName);
									updateToGoods.executeUpdate();
									
									lp.getLookupTable().getTableModel().fireTableDataChanged();

									// DB에 삽입
									String addSql;
									if (cnt == 0) {
										addSql = "INSERT INTO gstore(gname, gqty, expiration) VALUES (?, ?, ?)";
										insertVal(conn, addSql);
										paintRs.next();
										Object[] addTemp = 
											{paintRs.getInt("gid"), importName, importQty, paintRs.getInt("gprice"), importExp, now};
										dtm.addRow(addTemp);
										importPop.setVisible(false);
										
									} else {
										PreparedStatement addInfoPs = conn.prepareStatement("SELECT * FROM gstore WHERE gname = ?");
										addInfoPs.setString(1, importName);
										ResultSet addInfoRs = addInfoPs.executeQuery();
										
										addInfoRs.next();
										addStoredate = addInfoRs.getDate("storedate");
										
										if (addStoredate.toLocalDate().equals(now)) {
											addSql = "UPDATE gstore SET gqty = ? WHERE gname = ?";
											try (
													PreparedStatement addPs = conn.prepareStatement(addSql);		
													) {
												Object addQty = preGoodsQty + importQty;
												addPs.setObject(1, addQty);
												addPs.setString(2, importName);
												addPs.executeUpdate();
												
												paintRs.next();
												int rowNum;
												for (int i = 0; i < dtm.getRowCount(); ++i) {
													if (dtm.getValueAt(i, 1).equals(importNameTf.getText())) {
														rowNum = i;
														dtm.setValueAt(addQty, rowNum, 2);
													}
												}
												importPop.setVisible(false);
												
											} catch (SQLException e1) {
												e1.printStackTrace();
											}
											
										} else if (!addStoredate.toLocalDate().equals(now)) {
											addSql = "INSERT INTO gstore(gname, gqty, expiration) VALUES (?, ?, ?)";
											insertVal(conn, addSql);
											paintRs.next();
											Object[] addTemp = 
												{paintRs.getInt("gid"), importName, importQty, paintRs.getInt("gprice"), importExp, now};
											dtm.addRow(addTemp);
											
											importPop.setVisible(false);
										}
									}
								}
								
							} catch (SQLException e2) {
								e2.printStackTrace();
							}
							
						}
					});
				}
			});
			add(importPop);
			
			importPop.add(new BasicSmallButton("취소") {
				{
					setLocation(220, 240);
					addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							importPop.setVisible(false);
							
						}
					});
				}
			});
			
			add(new BasicSmallButton("입고") {
				{
					setLocation(0, 0);
					addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							importNameTf.setText("상품명을 입력해주세요");
							importQtyTf.setText("수량을 입력해주세요");
							importExpTf.setText("YYYYDDMM");
							importPop.setVisible(true);
						}
					});
				}
			});
			
			
			BasicPopupPanel exportPop = new BasicPopupPanel();
			add(exportPopupPanel(exportPop));
			
			add(new BasicSmallButton("출고") {
				{
					setLocation(70, 0);
					addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							exportPop.setVisible(true);
							 
						}
					});
				}
			});
			
			exportPop.add(new BasicSmallButton("출고") {
				{
					setLocation(140, 240);
					addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							exportName = gv.getTextStringValue(exportNameTf);
							exportQty = gv.getTextNumValue(exportQtyTf);
							
							try (
								PreparedStatement deleteGstore = conn.prepareStatement("UPDATE gstore SET gqty = ? WHERE gname = ?");		
								PreparedStatement preGoodsQtyPs = conn.prepareStatement("SELECT gqty FROM goods WHERE gname = ?");
								PreparedStatement deleteGoods = conn.prepareStatement("UPDATE goods SET gqty = ? WHERE gname = ?");
								ResultSet preGQRs = preGoodsQtyPs.executeQuery();		
							) {
								preGQRs.next();
								int preGoodsQty = preGQRs.getInt("gqty");
								
								deleteGstore.setInt(1, preGoodsQty - exportQty);
								deleteGstore.setString(2, exportName);
								deleteGstore.executeUpdate();
								
								deleteGoods.setInt(1, preGoodsQty - exportQty);
								deleteGoods.setString(2, exportName);
								deleteGoods.executeUpdate();
								
								preGoodsQtyPs.setString(1, exportName);
								
								int rowNum;
								for (int i = 0; i < dtm.getRowCount(); ++i) {
									if (dtm.getValueAt(i, 1).equals(exportNameTf.getText())) {
										rowNum = i;
										dtm.setValueAt(preGoodsQty - exportQty, rowNum, 2);
									}
								}
								
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					});
				}
			});
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		
		
		
		add(new BasicSmallButton("폐기") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicSmallButton("반품") {
			{
				setLocation(210, 0);
			}
		});
		
		add(new BasicTextField("검색어를 입력해주세요") {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicSmallButton("검색") {
			{
				setLocation(600, 0);
			}
		});
		
		add(storeTable);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}
	
	
	
	JPanel importPopupPanel(BasicPopupPanel importPop) {
		importPop.add(new JLabel("입고") {
			{
				setBounds(20, 10, 100, 50);
				setFont(new Font("돋움", Font.BOLD, 20));
			}
		});
		
		importNameTf = new BasicTextField("상품의 이름을 입력해주세요");
		importNameTf.setLocation(20, 75);
		importPop.add(importNameTf);
		
		importQtyTf = new BasicTextField("수량을 입력해주세요");
		importQtyTf.setLocation(20, 120);
		importPop.add(importQtyTf);
		
		importExpTf = new BasicTextField("YYYYMMDD");
		importExpTf.setLocation(20, 165);
		importPop.add(importExpTf);
		
		importPop.add(new BasicSmallButton("취소") {
			{
				setLocation(220, 240);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						importPop.setVisible(false);
						
					}
				});
			}
		});
		
		return importPop;
	}
	
	void insertVal(Connection conn, String addSql) {
		try (
			PreparedStatement addPs = conn.prepareStatement(addSql);		
		) {
			addPs.setString(1, importName);
			addPs.setInt(2, importQty);
			addPs.setDate(3, importExp);
			addPs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	JPanel exportPopupPanel(BasicPopupPanel exportPop) {
		
		exportPop.add(new JLabel("출고") {
			{
				setBounds(20, 10, 100, 50);
				setFont(new Font("돋움", Font.BOLD, 20));
			}
		});
		
		exportNameTf = new BasicTextField("상품의 이름을 입력해주세요");
		exportNameTf.setLocation(20, 75);
		exportPop.add(exportNameTf);
		
		exportQtyTf = new BasicTextField("수량을 입력해주세요");
		exportQtyTf.setLocation(20, 120);
		exportPop.add(exportQtyTf);
		
		exportPop.add(new BasicSmallButton("취소") {
			{
				setLocation(220, 240);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						exportPop.setVisible(false);
						
					}
				});
			}
		});
		
		return exportPop;
	}
	
	void deleteVal(Connection conn, String deleteSql) {
		try (
			PreparedStatement delSqlPs = conn.prepareStatement(deleteSql);		
		) {
			delSqlPs.setInt(1, exportQty);
			delSqlPs.setString(2, exportName);
			delSqlPs.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}





























