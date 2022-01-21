package project.frames.goods_frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import project.MainFrame;
import project.components.goods_components.ButtonImage;
import project.components.goods_components.HomeBtn;
import project.components.goods_components.PosDBConnector;



public class GoodsFrame extends JFrame {
	private ContentsPanel contents = new ContentsPanel();
	private ManagementPanel mp = contents.getManagementPanel();
	private HomeBtn manageHomeBtn, lookupHomeBtn, assetHomeBtn;
	private ButtonImage img = new ButtonImage();
	
	public GoodsFrame(MainFrame main) {
		add(contents);
		add(new GnbPanel(contents));
		
		manageHomeBtn= new HomeBtn(this, img.homeBtn());
		contents.getManagementPanel().add(manageHomeBtn);
		
		lookupHomeBtn= new HomeBtn(this, img.homeBtn());
		contents.getLookupPanel().add(lookupHomeBtn);
		
		assetHomeBtn= new HomeBtn(this, img.homeBtn());
		contents.getAssetPanel().add(assetHomeBtn);
		
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
		setBounds(main.getLocation().x, main.getLocation().y, 1000, 700);
		
		// 프레임 백그라운드용 패널
		add(new JPanel() {
			{
				setBounds(0, 0, 1000, 700);
				setBorder(BorderFactory.createLineBorder(Color.black));
				setBackground(Color.WHITE);
//				setBackground(Color.CYAN);
			}
		});
		setUndecorated(true);
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




















