package project.frames.goods_frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.actions.SearchTf;
import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicBigButton;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.ButtonImage;
import project.components.goods_components.GoodsTable;
import project.components.goods_components.PosDBConnector;

public class LookupPanel extends JPanel {
	private GoodsTable goods;
	private BasicSmallButton searchClear, goodsConfirm, goodsCancel, deleteConfirm, deleteCancel;
	private BasicBigButton addGoodsBtn, deleteGoodsBtn;
	private BasicTextField searchTf;
	private JPanel addGoods, deleteGoods;
	private BasicTextField goodsNameTf, goodsPriceTf, goodsCategoryTf, goodsSupplierTf, goodsPicNameTf, goodsPicTelTf, deleteGoodsIdTf;
	private GetValues get = new GetValues();
	private String goodsName, goodsCategory, goodsSupplier, goodsPicName, goodsPicTel, categoryName;
	private int goodsPrice, deleteGoodsId;
	private ButtonImage img = new ButtonImage();
	
	public LookupPanel() {
		
		// �˻�â ����
		goods = new GoodsTable();
		searchTf = new BasicTextField("");
		searchTf.setLocation(0, 20);
		goods.getRowsorter().addRowSorterListener(null);
		new SearchTf(goods.getRowsorter(), searchTf);
		searchTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 10) {
					
				}
			}
		});
		add(searchTf);
		searchClear = new BasicSmallButton(img.searchCancel());
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
		
		// ��ǰ�߰�
		addGoodsBtn = new BasicBigButton(img.addBtn());
		addGoodsBtn.setLocation(590, 520);
		addGoodsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addGoods.setVisible(true);
			}
		});
		add(addGoodsBtn);
		
		addGoods = new JPanel();
		addGoods.setSize(570, 130);
		addGoods.setLocation(0, 510);
		addGoods.setBackground(Color.WHITE);
//		addGoods.setBackground(Color.RED);
		addGoodsPanel(addGoods);
		goodsConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (
					Connection conn = PosDBConnector.getConnection();		
				) {
					addGoodsValues(conn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				goods.getTableModel().fireTableDataChanged();
				goodsNameTf.setText("�̸�");
				goodsPriceTf.setText("����");
				goodsCategoryTf.setText("ī�װ�");
				goodsSupplierTf.setText("����ó");
				goodsPicNameTf.setText("�����");
				goodsPicTelTf.setText("��ȭ��ȣ");
			}
		});
		goodsCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goods.getTableModel().fireTableDataChanged();
				goodsNameTf.setText("�̸�");
				goodsPriceTf.setText("����");
				goodsCategoryTf.setText("ī�װ�");
				goodsSupplierTf.setText("����ó");
				goodsPicNameTf.setText("�����");
				goodsPicTelTf.setText("��ȭ��ȣ");
			}
		});
		add(addGoods);
		
		// ��ǰ ����
		deleteGoodsBtn = new BasicBigButton(img.deleteBtn());
		deleteGoodsBtn.setLocation(590, 590);
		deleteGoodsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addGoods.setVisible(false);
				deleteGoods.setVisible(true);
			}
		});
		add(deleteGoodsBtn);
		
		deleteGoods = new JPanel();
		deleteGoods.setSize(570, 130);
		deleteGoods.setLocation(0, 510);
		deleteGoods.setBackground(Color.WHITE);
		deleteGoodsPanel(deleteGoods);
		deleteConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try (
					Connection conn = PosDBConnector.getConnection();		
				) {
					deleteGoodsValues(conn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				goods.getTableModel().fireTableDataChanged();
				goods.repaint();
				deleteGoodsIdTf.setText("��ǰ��ȣ");
			}
		});
		deleteCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteGoodsIdTf.setText("��ǰ��ȣ");
			}
		});
		add(deleteGoods);
		
		setBackground(Color.WHITE);
		add(goods);
		setLayout(null);
		setBounds(300, 100, 760, 500);
		setVisible(true);
		
	}

	void addGoodsPanel(JPanel panel) {
		panel.setLayout(null);
		panel.add(new JLabel("��ǰ�߰�") {
			{
				setBounds(0, 0, 100, 50);
				setFont(new Font("����", Font.BOLD, 20));
			}
		});
		
		// �Է�â
		goodsNameTf = new BasicTextField("�̸�");
		goodsNameTf.setLocation(0, 40);
		panel.add(goodsNameTf);
		
		goodsPriceTf = new BasicTextField("����");
		goodsPriceTf.setLocation(0, 70);
		panel.add(goodsPriceTf);
		
		goodsCategoryTf = new BasicTextField("ī�װ�");
		goodsCategoryTf.setLocation(0, 100);
		panel.add(goodsCategoryTf);
		
		goodsSupplierTf = new BasicTextField("����ó");
		goodsSupplierTf.setLocation(210, 40);
		panel.add(goodsSupplierTf);
		
		goodsPicNameTf = new BasicTextField("�����");
		goodsPicNameTf.setLocation(210, 70);
		panel.add(goodsPicNameTf);
		
		goodsPicTelTf = new BasicTextField("��ȭ��ȣ");
		goodsPicTelTf.setLocation(210, 100);
		panel.add(goodsPicTelTf);
		
		//��ư
		goodsConfirm = new BasicSmallButton(img.confirmBtn());
		goodsConfirm.setSize(35, 35);
		goodsConfirm.setLocation(450, 40);
		panel.add(goodsConfirm);
		
		goodsCancel = new BasicSmallButton(img.cancelBtn());
		goodsCancel.setSize(35, 35);
		goodsCancel.setLocation(450, 90);
		panel.add(goodsCancel);
		
		panel.setVisible(true);
	}
	
	void addGoodsValues(Connection conn) {
		goodsName = get.getTextStringValue(goodsNameTf);
		goodsPrice = get.getTextNumValue(goodsPriceTf);
		goodsCategory = get.getTextStringValue(goodsCategoryTf);
		goodsSupplier = get.getTextStringValue(goodsSupplierTf);
		goodsPicName = get.getTextStringValue(goodsPicNameTf);
		goodsPicTel = get.getTextStringValue(goodsPicTelTf);
		
		try ( 
			PreparedStatement pstmt = conn.prepareStatement(
				"INSERT INTO goods(gid, gname, gprice, gcategory, supplier, pic_name, pic_tel) "
				+ "VALUES(pos_gid_seq.nextval, ?, ?, ?, ?, ?, ?)"
						);
		) {
			pstmt.setString(1, goodsName);
			pstmt.setInt(2, goodsPrice);
			pstmt.setString(3, goodsCategory);
			pstmt.setString(4, goodsSupplier);
			pstmt.setString(5, goodsPicName);
			pstmt.setString(6, goodsPicTel);
			pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	void deleteGoodsPanel(JPanel panel) {
		panel.setLayout(null);
		panel.add(new JLabel("��ǰ����") {
			{
				setBounds(0, 0, 100, 50);
				setFont(new Font("����", Font.BOLD, 20));
			}
		});
		
		// �Է�â
		deleteGoodsIdTf = new BasicTextField("��ǰ��ȣ");
		deleteGoodsIdTf.setLocation(0, 60);
		panel.add(deleteGoodsIdTf);
		
		//��ư
		deleteConfirm = new BasicSmallButton(img.confirmBtn());
		deleteConfirm.setLocation(450, 40);
		deleteConfirm.setSize(35, 35);
		panel.add(deleteConfirm);
		
		deleteCancel = new BasicSmallButton(img.cancelBtn());
		deleteCancel.setLocation(450, 90);
		deleteCancel.setSize(35, 35);
		panel.add(deleteCancel);
		
		panel.setVisible(false);
	}
	
	void deleteGoodsValues(Connection conn) {
		deleteGoodsId = get.getTextNumValue(deleteGoodsIdTf);
		
		try (
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM goods WHERE gid = ?");		
		) {
			pstmt.setInt(1, deleteGoodsId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	ArrayList<String> categoryList = new ArrayList<>();
	JComboBox<String> categoryCombo;
	String[] categoryArr;
	
	void addCategory() {
		categoryName = get.getTextStringValue(deleteGoodsIdTf);
		categoryList.add(categoryName);
		categoryArr = new String[categoryList.size()];
		
		for (int i = 0; i < categoryList.size(); ++i) {
			categoryArr[i] = categoryList.get(i);
		}
		
		categoryCombo = new JComboBox<>(categoryArr);
		
	}
	
	public GoodsTable getLookupTable() {
		return goods;
	}

}




































































