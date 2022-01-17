package project.frames.goods_frames;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JPanel;

import project.components.goods_components.AssetExpTable;
import project.components.goods_components.AssetShortageTable;
import project.components.goods_components.BasicLabel;
import project.components.goods_components.GoodsTable;
import project.components.goods_components.PosDBConnector;

public class AssetPanel extends JPanel {
	GoodsTable goods = new GoodsTable();
	AssetExpTable aet;
	AssetShortageTable ast;
	
	String totalAssets;
	
	public AssetPanel() {
		
		BasicLabel assetsLabel = new BasicLabel("자산");
		assetsLabel.setLocation(0, 10);
		BasicLabel totalAsset = new BasicLabel("자산");
		totalAsset.setLocation(425, 10);
		getAsset();
		totalAsset.setText(totalAssets);
		add(totalAsset);
		add(assetsLabel);
		
		try (
			Connection conn = PosDBConnector.getConnection();		
		) {
			aet = new AssetExpTable(conn);
			ast = new AssetShortageTable(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BasicLabel expLabel = new BasicLabel("유통기한임박");
		expLabel.setLocation(0, 50);
		aet.setLocation(0, 80);
		add(aet);
		add(expLabel);
		
		BasicLabel shortage = new BasicLabel("재고부족");
		shortage.setLocation(0, 260);
		ast.setLocation(0, 300);
		add(ast);
		add(shortage);
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}
	
	private void getAsset() {
		
		int tempAssets = 0;
		try (
			Connection conn = PosDBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT SUM(gqty * gprice) AS asset FROM goods");		
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			tempAssets += rs.getInt("asset");
			
			double total = tempAssets;
			Locale locale = new Locale("ko", "KR");
			NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
			totalAssets = formatter.format(total);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getExpiration() {
		
	}
	
}





























