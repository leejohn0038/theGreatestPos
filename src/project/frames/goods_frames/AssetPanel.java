package project.frames.goods_frames;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JPanel;

import project.components.goods_components.BasicLabel;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.GoodsTable;
import project.components.goods_components.PosDBConnector;

public class AssetPanel extends JPanel {
	String totalAssets;
	
	public AssetPanel() {
		
		BasicLabel assetsLabel = new BasicLabel("자산");
		assetsLabel.setLocation(10, 10);
		BasicLabel totalAsset = new BasicLabel("자산");
		totalAsset.setLocation(300, 10);
		getAsset();
		System.out.println(totalAssets);
		totalAsset.setText(totalAssets);
		add(totalAsset);
		add(assetsLabel);
		
		BasicLabel expLabel = new BasicLabel("유통기한 임박상품");
		expLabel.setLocation(10, 50);
		add(expLabel);
		
		BasicLabel shortage = new BasicLabel("재고부족상품");
		shortage.setLocation(10, 100);
		add(shortage);
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
	}
	
	private void getAsset() {
		GoodsTable goods = new GoodsTable();
		int rowCnt = goods.getTableModel().getRowCount();
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
	
}





























