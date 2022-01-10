package project.frames.goods_frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import project.actions.goods_actions.GetValues;
import project.components.goods_components.BasicPopupPanel;
import project.components.goods_components.BasicSmallButton;
import project.components.goods_components.BasicTextField;
import project.components.goods_components.GoodsTable;

public class ManagementPanel extends JPanel {
	int qty;
	String sql = "SELECT * FROM goods";
	
	public ManagementPanel() {
				
		BasicPopupPanel store = new BasicPopupPanel();
		// 테스트용 버튼을 만들어 렌덤물품이 추가되게 확인하기
		store.add(new JLabel("상품추가") {
			{
				setBounds(20, 10, 100, 50);
				setFont(new Font("돋움", Font.BOLD, 20));
			}
		});
		store.add(new BasicTextField("상품의 이름을 입력해주세요") {
			{
				setLocation(20, 75);
			}
		});
		BasicTextField qtyTxt = new BasicTextField("수량을 입력해주세요");
		qtyTxt.setLocation(20, 120);
		store.add(qtyTxt);
		store.add(new BasicSmallButton("추가") {
			{
				setLocation(140, 240);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						qty = new GetValues().getTextNumValue(qtyTxt);
					}
				});
			}
		});
		add(store);
		store.add(new BasicSmallButton("취소") {
			{
				setLocation(220, 240);
				addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						store.setVisible(false);
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
						store.setVisible(true);;
					}
				});
			}
		});
		
		add(new BasicSmallButton("출고") {
			{
				setLocation(70, 0);
			}
		});
		
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
		
		setLayout(null);
		setBounds(300, 100, 760, 500);
		add(new GoodsTable(sql));
		setVisible(true);
		
	}
}
