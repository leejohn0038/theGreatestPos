package project.frames.goods_frames;


import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

import project.components.goods_components.AssetExpTable;
import project.components.goods_components.AssetShortageTable;
import project.components.goods_components.BasicLabel;
import project.components.goods_components.PosDBConnector;

public class AssetPanel extends JPanel {
	private AssetExpTable aet;
	private AssetShortageTable ast;
	
	String totalAssets;
	
	public AssetPanel() {
		
		add(new JLabel("자산관리") {
			{
				setBounds(0, 0, 150, 50);
				setFont(new Font("기본", Font.BOLD, 30));
			}
		});
		
		BasicLabel assetsLabel = new BasicLabel("자산");
		assetsLabel.setLocation(0, 60);
		BasicLabel totalAsset = new BasicLabel("자산");
		totalAsset.setLocation(250, 60);
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
		expLabel.setLocation(0, 110);
		aet.setLocation(0, 150);
		add(aet);
		add(expLabel);
		
//		BasicTextField editExpTf = new BasicTextField("기준일 변경");
//		BasicSmallButton editExpBtn = new BasicSmallButton("O");
//		editExpBtn.setBounds(150, 0, 25, 25);
//		editExpTf.add(editExpBtn);
//		editExpTf.setLayout(null);
//		editExpTf.setLocation(325, 50);
//		add(editExpTf);
		
		// 모델을 다시 불러와
		
		BasicLabel shortage = new BasicLabel("재고부족");
		shortage.setLocation(0, 410);
		ast.setLocation(0, 450);
		add(ast);
		add(shortage);
		
		setBackground(Color.WHITE);
//		setBackground(Color.RED);
		setLayout(null);
		setBounds(240, 20, 750, 680);
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
	
	public AssetExpTable getAssetExpTable() {
		return aet;
	}
	
	public AssetShortageTable getAssetShortageTable() {
		return ast;
	}
}
