package project.frames.goods_frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import project.actions.SearchTf;
import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.PosDBConnector;
import project.components.goods_components.StoreTable;

public class ManagementPanel extends JPanel {
	
	private String changeName, nullExp;
	private int changeQty, preGoodsQty, gid, gprice, cnt; 
	private Date importExp, addExp, preGoodsExp;
	private LocalDate compareExp;
	private BasicSmallButton importConfirmBtn, importCancelBtn, importBtn, exportConfirmBtn, exportCancelBtn, exportBtn, searchClear;
	private BasicTextField importNameTf, importQtyTf, importExpTf, exportNameTf, exportQtyTf, searchTf;
	private BasicPopupPanel importPop, exportPop;
	private DefaultTableModel dtm;
	private JPanel bottomContents;
	LocalDate now;
	GetValues gv;

	public ManagementPanel() {
		
//		setLayout(new BorderLayout());
		setLayout(null);
		setBackground(Color.WHITE);
		setOpaque(true);
		
		// 하단 컨텐츠 영역
		bottomContents = new JPanel();
		StoreTable storeTable = new StoreTable();
		dtm = storeTable.getTableModel();
		add(storeTable);
		
		// 입고 기능
		importPop = new BasicPopupPanel();
		importConfirmBtn = new BasicSmallButton("확인");
		importCancelBtn = new BasicSmallButton("취소");
//		importPop.setVisible(true);
		bottomContents.add(importPopupPanel(importPop));
		
		importConfirmBtn.setLocation(350, 50);
		importConfirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (
					Connection conn = PosDBConnector.getConnection();		
				) {
					getImportValues();
					existGoods(conn);
					addGoods(conn, cnt);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				importPop.setVisible(false);
			}
		});
		importPop.add(importConfirmBtn);
		importPop.setLayout(null);
		
		importCancelBtn.setLocation(350, 100);
		importCancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importPop.setVisible(false);
			}
		});
		importPop.add(importCancelBtn);
		
		importBtn = new BasicSmallButton("입고");
		importBtn.setBounds(520, 100, 90, 50);
		importBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importNameTf.setText("상품명을 입력해주세요");
				importQtyTf.setText("수량을 입력해주세요");
				importExpTf.setText("YYYYMMDD");
				importPop.setVisible(true);
			}
		});
		bottomContents.add(importBtn);
		
		// 출고 기능
		exportPop = new BasicPopupPanel();
		exportConfirmBtn = new BasicSmallButton("확인");
		exportCancelBtn = new BasicSmallButton("취소");
		bottomContents.add(exportPopupPanel(exportPop));
		
		exportConfirmBtn.setLocation(350, 50);
		exportConfirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (
						Connection conn = PosDBConnector.getConnection();
				) {
					loseGoods(conn);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				exportPop.setVisible(false);
				
			}
		});
		exportPop.add(exportConfirmBtn);
		
		exportCancelBtn.setLocation(350, 100);
		exportCancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportPop.setVisible(false);
			}
		});
		exportPop.add(exportCancelBtn);
		
		exportBtn = new BasicSmallButton("출고");
		exportBtn.setBounds(630, 100, 90, 50);
		exportBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportNameTf.setText("상품명을 입력해주세요");
				exportQtyTf.setText("수량을 입력해주세요");
				exportPop.setVisible(true);
			}
		});
		bottomContents.add(exportBtn);
		
		// 검색 기능
		searchTf = new BasicTextField("");
		searchTf.setLocation(520, 20);
		storeTable.getRowsorter().addRowSorterListener(null);
		new SearchTf(storeTable.getRowsorter(), searchTf);
		searchTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 10) {
					
				}
			}
		});
		bottomContents.add(searchTf);
		searchClear = new BasicSmallButton("X");
		searchClear.setLocation(175, 0);
		searchClear.setSize(25, 25);
		searchClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTf.setText("");				
			}
		});
		searchTf.add(searchClear);
		searchTf.setLayout(null);
		
		bottomContents.setSize(720, 170);
		bottomContents.setLocation(0, 450);
		bottomContents.setBackground(Color.WHITE);
		add(bottomContents);
		bottomContents.setLayout(null);
		
		setBounds(240, 20, 720, 620);
		setVisible(true);
	}
	
	private BasicPopupPanel importPopupPanel(BasicPopupPanel importPop) {
		importPop.add(new JLabel("입고") {
			{
				setBounds(20, 10, 100, 50);
				setFont(new Font("돋움", Font.BOLD, 20));
			}
		});
		
		importNameTf = new BasicTextField("상품의 이름을 입력해주세요");
		importNameTf.setLocation(100, 25);
		importPop.add(importNameTf);
		
		importQtyTf = new BasicTextField("수량을 입력해주세요");
		importQtyTf.setLocation(100, 75);
		importPop.add(importQtyTf);
		
		importExpTf = new BasicTextField("YYYYMMDD");
		importExpTf.setLocation(100, 125);
		importPop.add(importExpTf);
		
		importPop.setSize(440, 170);
		importPop.setLocation(0, 0);
		return importPop;
	}
	
	private void insertVal(Connection conn, String addSql) {
		try (
			PreparedStatement addPs = conn.prepareStatement(addSql);		
		) {
			addPs.setString(1, changeName);
			addPs.setInt(2, changeQty);
			addPs.setDate(3, importExp);
			addPs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private JPanel exportPopupPanel(BasicPopupPanel exportPop) {
		
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
		
		exportPop.setSize(440, 170);
		exportPop.setLocation(0, 0);
		return exportPop;
	}
	
	public void getImportValues() {
		gv = new GetValues();
		changeName = gv.getTextStringValue(importNameTf);
		changeQty = gv.getTextNumValue(importQtyTf);
		importExp = gv.getTextDateValue(importExpTf);
	}
	
	public void getExportValues() {
		GetValues gv = new GetValues();
		changeName = gv.getTextStringValue(exportNameTf);
		changeQty = gv.getTextNumValue(exportQtyTf);
	}
	
	private void existGoods(Connection conn) {
		try (
			PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM gstore WHERE gname = ?");		
		) {
			pstmt.setString(1, changeName);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			cnt = rs.getInt("COUNT(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getPreGoodsInfo(Connection conn) {
		try (
			PreparedStatement preGoodsPs = conn.prepareStatement("SELECT * FROM goods WHERE gname = ?");
		) {
			preGoodsPs.setString(1, changeName);
			ResultSet preGoodsRs = preGoodsPs.executeQuery();
			preGoodsRs.next();
			preGoodsQty = preGoodsRs.getInt("gqty");
			gid = preGoodsRs.getInt("gid");
			gprice = preGoodsRs.getInt("gprice");
			preGoodsExp = preGoodsRs.getDate("expiration");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addGoods(Connection conn, int cnt) {
		now = LocalDate.now();
		existGoods(conn);
		getPreGoodsInfo(conn);
		System.out.println(cnt);
		try (
			PreparedStatement updateToGoods = conn.prepareStatement("UPDATE goods SET gqty = ?, expiration = ? WHERE gname = ?");
		) {
			updateToGoods.setInt(1, preGoodsQty + changeQty);
			if (preGoodsExp == null) {
				updateToGoods.setDate(2, importExp);
			} else if (preGoodsExp.equals(importExp)) {
				updateToGoods.setDate(2, importExp);
			} else if (preGoodsExp.after(importExp)) {
				updateToGoods.setDate(2, importExp);
			} else if (preGoodsExp.before(importExp)) {
				updateToGoods.setDate(2, preGoodsExp);
			}
			updateToGoods.setString(3, changeName);
			updateToGoods.executeUpdate();
			
			String addSql;
			if (cnt == 0) {
				addSql = "INSERT INTO gstore(gname, gqty, expiration) VALUES (?, ?, ?)";
				insertVal(conn, addSql);
				Object[] addTemp = 
					{gid, changeName, changeQty, gprice, importExp, now};
				dtm.addRow(addTemp);
				importPop.setVisible(false);
				
			} else if (cnt > 0) {
				PreparedStatement addInfoPs = conn.prepareStatement("SELECT * FROM gstore WHERE gname = ?");
				addInfoPs.setString(1, changeName);
				ResultSet addInfoRs = addInfoPs.executeQuery();
				addInfoRs.next();
				addExp = addInfoRs.getDate("expiration");
				if (addExp == null) {
					addSql = "UPDATE gstore SET gqty = ? WHERE gname = ?";
					try (
							PreparedStatement addPs = conn.prepareStatement(addSql);	
							) {
						Object addQty = preGoodsQty + changeQty;
						addPs.setObject(1, addQty);
						addPs.setString(2, changeName);
						addPs.executeUpdate();
						
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
					
				} else {
					if (addExp.toLocalDate().equals(importExp)){
						addSql = "UPDATE gstore SET gqty = ? WHERE gname = ?";
						try (
								PreparedStatement addPs = conn.prepareStatement(addSql);	
								) {
							Object addQty = preGoodsQty + changeQty;
							addPs.setObject(1, addQty);
							addPs.setString(2, changeName);
							addPs.executeUpdate();
							
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
					} else if (!addExp.toLocalDate().equals(importExp)) {
						addSql = "INSERT INTO gstore(gname, gqty, expiration) VALUES (?, ?, ?)";
						insertVal(conn, addSql);
						Object[] addTemp = 
							{gid, changeName, changeQty, gprice, importExp, now};
						dtm.addRow(addTemp);
						importPop.setVisible(false);
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private void loseGoods(Connection conn) {
		getExportValues();
		getPreGoodsInfo(conn);
		
		try (
			PreparedStatement deleteGstore = conn.prepareStatement("UPDATE gstore SET gqty = ? WHERE gname = ? AND expiration = ?");	
			PreparedStatement deleteGoods = conn.prepareStatement("UPDATE goods SET gqty = ? WHERE gname = ?");
			PreparedStatement deleteExpPs = conn.prepareStatement("SELECT MIN(expiration) AS minexp FROM gstore WHERE gname = ?");
			PreparedStatement deleteQtyPs = conn.prepareStatement("SELECT * FROM gstore WHERE gname = ? AND expiration = ?");
		) {
			deleteExpPs.setString(1, changeName);
			ResultSet rs = deleteExpPs.executeQuery();
			rs.next();
			Date deleteExp = rs.getDate("minexp");
			
			deleteQtyPs.setString(1, changeName);
			deleteQtyPs.setDate(2, deleteExp);
			ResultSet deleteQtyRs = deleteQtyPs.executeQuery();
			deleteQtyRs.next();
			int deletedNum = deleteQtyRs.getInt("gqty");
			
			deleteGstore.setInt(1, deletedNum - changeQty);
			deleteGstore.setString(2, changeName);
			deleteGstore.setDate(3, preGoodsExp);
			deleteGstore.executeUpdate();
			
			deleteGoods.setInt(1, preGoodsQty - changeQty);
			deleteGoods.setString(2, changeName);
			deleteGoods.executeUpdate();
			
			int rowNum;
			for (int i = 0; i < dtm.getRowCount(); ++i) {
				if (dtm.getValueAt(i, 1).equals(exportNameTf.getText()) && dtm.getValueAt(i, 4).equals(deleteExp)) {
					rowNum = i;
					dtm.setValueAt(deletedNum - changeQty, rowNum, 2);
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		deleteData(conn);
	}
	
	void deleteData(Connection conn) {
		try (
			PreparedStatement deleteData = conn.prepareStatement("DELETE FROM gstore WHERE gqty <= 0");
		) {
			deleteData.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		editGoodsDate(conn);
	}
	
	void editGoodsDate(Connection conn) {
		try (
			PreparedStatement editGoodsDate = conn.prepareStatement("UPDATE goods SET expiration = ?");
			PreparedStatement getGstoreExp = conn.prepareStatement("SELECT * FROM gstore WHERE gname = ?");
		) {
			getGstoreExp.setString(1, changeName);
			ResultSet getGstoreExpRs = getGstoreExp.executeQuery();
			getGstoreExpRs.next();
			Date changeDate = getGstoreExpRs.getDate("expiration");
			editGoodsDate.setDate(1, changeDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public BasicSmallButton getExportConfirm() {
		return exportConfirmBtn;
	}
	
	public BasicSmallButton getImportConfirm() {
		return importConfirmBtn;
	}
	
	public String getChangeName() {
		return changeName;
	}
	
	public int getChangeQty() {
		return changeQty;
	}
}





























