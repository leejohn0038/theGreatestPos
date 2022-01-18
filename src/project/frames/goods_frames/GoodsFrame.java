package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import project.MainFrame;
import project.components.goods_components.PosDBConnector;
import project.components.receipts_components.MainButtons;



public class GoodsFrame extends JFrame {
	private ContentsPanel contents = new ContentsPanel();
	private ManagementPanel mp = contents.getManagementPanel();; 
	
	public GoodsFrame(MainFrame main) {
		add(contents);
		add(new GnbPanel(contents));
		
		String[] snbButtons = {"상품", "영수증", "직원", "회원", "업무가이드"};
		for (int i = 0; i < snbButtons.length; ++i) {
			add(new MainButtons(main, snbButtons[i]));
		}
		
		contents.getManagementPanel().getExportConfirm().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (
					Connection conn = PosDBConnector.getConnection();
				) {
					editLookupPanelLose(conn);
					editAssetPanelLose(conn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		contents.getManagementPanel().getImportConfirm().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try (
					Connection conn = PosDBConnector.getConnection();		
				) {
					editLookupPanelAdd(conn);
					editAssetPanelAdd(conn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
	
	private void editLookupPanelAdd(Connection conn) {
		ManagementPanel mp = contents.getManagementPanel();
		LookupPanel lp = contents.getLookupPanel();
		DefaultTableModel lookupDtm = lp.getLookupTable().getTableModel();
		mp.getPreGoodsInfo(conn);
		mp.getImportValues();
		
		Object num;
		for (int i = 0; i < lp.getLookupTable().getTableModel().getRowCount(); ++i) {
			if (lookupDtm.getValueAt(i, 1).equals(mp.getChangeName())) {
				num = (int)lookupDtm.getValueAt(i, 2) + mp.getChangeQty();
				lookupDtm.setValueAt(num, i, 2);
			}
		}
	}
	
	private void editLookupPanelLose(Connection conn) {
		LookupPanel lp = contents.getLookupPanel();
		DefaultTableModel lookupDtm = lp.getLookupTable().getTableModel();
		mp.getPreGoodsInfo(conn);
		mp.getExportValues();
		
		Object num;
		for (int i = 0; i < lp.getLookupTable().getTableModel().getRowCount(); ++i) {
			if (lookupDtm.getValueAt(i, 1).equals(mp.getChangeName())) {
				num = (int)lookupDtm.getValueAt(i, 2) - mp.getChangeQty();
				lookupDtm.setValueAt(num, i, 2);
			}
		}
	}
	
	private void editAssetPanelAdd(Connection conn) {
		AssetPanel ap = contents.getAssetPanel();
		DefaultTableModel assetExpModel = ap.getAssetExpTable().getTableModel();
		DefaultTableModel assetShortageModel = ap.getAssetShortageTable().getTableModel();
		mp.getPreGoodsInfo(conn);
		mp.getImportValues();
		
		Object num;
		for (int i = 0; i < assetExpModel.getRowCount(); ++i) {
			if (assetExpModel.getValueAt(i, 1).equals(mp.getChangeName())) {
				num = (int)assetExpModel.getValueAt(i, 2) - mp.getChangeQty();
				assetExpModel.setValueAt(num, i, 2);
			}
		}
		
		for (int i = 0; i < assetShortageModel.getRowCount(); ++i) {
			if (assetShortageModel.getValueAt(i, 1).equals(mp.getChangeName())) {
				num = (int)assetShortageModel.getValueAt(i, 2) - mp.getChangeQty();
				assetShortageModel.setValueAt(num, i, 2);
			}
		}
	}
	
	private void editAssetPanelLose(Connection conn) {
		AssetPanel ap = contents.getAssetPanel();
		DefaultTableModel assetExpModel = ap.getAssetExpTable().getTableModel();
		DefaultTableModel assetShortageModel = ap.getAssetShortageTable().getTableModel();
		mp.getPreGoodsInfo(conn);
		mp.getExportValues();
		
		Object num;
		for (int i = 0; i < assetExpModel.getRowCount(); ++i) {
			if (assetExpModel.getValueAt(i, 1).equals(mp.getChangeName())) {
				num = (int)assetExpModel.getValueAt(i, 2) - mp.getChangeQty();
				assetExpModel.setValueAt(num, i, 2);
			}
		}
		
		for (int i = 0; i < assetShortageModel.getRowCount(); ++i) {
			if (assetShortageModel.getValueAt(i, 1).equals(mp.getChangeName())) {
				num = (int)assetShortageModel.getValueAt(i, 2) - mp.getChangeQty();
				assetShortageModel.setValueAt(num, i, 2);
			}
		}
	}
}




















