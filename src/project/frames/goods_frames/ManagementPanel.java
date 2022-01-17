package project.frames.goods_frames;

import java.awt.Font;
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
	
	private String changeName;
	private int changeQty, preGoodsQty, gid, gprice, cnt; 
	private Date importExp, addStoredate, preGoodsExp;
	LocalDate compareExp;
	private BasicSmallButton importConfirmBtn, importCancelBtn, importBtn, exportConfirmBtn, exportCancelBtn, exportBtn, searchClear;
	private BasicTextField importNameTf, importQtyTf, importExpTf, exportNameTf, exportQtyTf, searchTf;
	private BasicPopupPanel importPop, exportPop;
	private DefaultTableModel dtm;
	GetValues gv;

	public ManagementPanel() {
		
		StoreTable storeTable = new StoreTable();
		dtm = storeTable.getTableModel();
		
		// 입고 기능
		importPop = new BasicPopupPanel();
		importConfirmBtn = new BasicSmallButton("확인");
		importCancelBtn = new BasicSmallButton("취소");
		importPopupPanel(importPop);
		
		importConfirmBtn.setLocation(140, 240);
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
		
		importCancelBtn.setLocation(220, 240);
		importCancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importPop.setVisible(false);
			}
		});
		importPop.add(importCancelBtn);
		add(importPop);
		
		importBtn = new BasicSmallButton("입고");
		importBtn.setLocation(0, 0);
		importBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importNameTf.setText("상품명을 입력해주세요");
				importQtyTf.setText("수량을 입력해주세요");
				importExpTf.setText("YYYYDDMM");
				importPop.setVisible(true);
			}
		});
		add(importBtn);
		
		// 출고 기능
		exportPop = new BasicPopupPanel();
		exportConfirmBtn = new BasicSmallButton("확인");
		exportCancelBtn = new BasicSmallButton("취소");
		add(exportPopupPanel(exportPop));
		
		exportConfirmBtn.setLocation(140, 240);
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
		
		exportCancelBtn.setLocation(220, 240);
		exportCancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportPop.setVisible(false);
			}
		});
		exportPop.add(exportCancelBtn);
		
		exportBtn = new BasicSmallButton("출고");
		exportBtn.setLocation(70, 0);
		exportBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportNameTf.setText("상품명을 입력해주세요");
				exportQtyTf.setText("수량을 입력해주세요");
				exportPop.setVisible(true);
			}
		});
		add(exportBtn);
		
		// 검색 기능
		searchTf = new BasicTextField("");
		searchTf.setLocation(475, 0);
		storeTable.getRowsorter().addRowSorterListener(null);
		new SearchTf(storeTable.getRowsorter(), searchTf);
		searchTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 10) {
					
				}
			}
		});
		add(searchTf);
		searchClear = new BasicSmallButton("X");
		searchClear.setLocation(150, 0);
		searchClear.setSize(25, 25);
		searchClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTf.setText("");				
			}
		});
		searchTf.add(searchClear);
		searchTf.setLayout(null);
		
		add(storeTable);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}
	
	
	
	private JPanel importPopupPanel(BasicPopupPanel importPop) {
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
		
		return exportPop;
	}
	
	private void getImportValues() {
		gv = new GetValues();
		changeName = gv.getTextStringValue(importNameTf);
		changeQty = gv.getTextNumValue(importQtyTf);
		importExp = gv.getTextDateValue(importExpTf);
	}
	
	private void getExportValues() {
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
	
	private void getPreGoodsInfo(Connection conn) {
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
		LocalDate now = LocalDate.now();
		getPreGoodsInfo(conn);
		
		try (
			PreparedStatement updateToGoods = conn.prepareStatement("UPDATE goods SET gqty = ?, expiration = ? WHERE gname = ?");
		) {
			updateToGoods.setInt(1, preGoodsQty + changeQty);
			System.out.println("저장된 날짜: " + preGoodsExp);
			System.out.println("입력된 날짜: " + importExp);
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
				addStoredate = addInfoRs.getDate("storedate");
				if (addStoredate.toLocalDate().equals(now)){
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
				} else if (!addStoredate.toLocalDate().equals(now)) {
					addSql = "INSERT INTO gstore(gname, gqty, expiration) VALUES (?, ?, ?)";
					insertVal(conn, addSql);
					Object[] addTemp = 
						{gid, changeName, changeQty, gprice, importExp, now};
					dtm.addRow(addTemp);
					importPop.setVisible(false);
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
		) {
			deleteGstore.setInt(1, preGoodsQty - changeQty);
			deleteGstore.setString(2, changeName);
			deleteGstore.setDate(3, preGoodsExp);
			deleteGstore.executeUpdate();
			
			deleteGoods.setInt(1, preGoodsQty - changeQty);
			deleteGoods.setString(2, changeName);
			deleteGoods.executeUpdate();
			
			int rowNum;
			for (int i = 0; i < dtm.getRowCount(); ++i) {
				if (dtm.getValueAt(i, 1).equals(exportNameTf.getText())) {
					rowNum = i;
					dtm.setValueAt(preGoodsQty - changeQty, rowNum, 2);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}





























