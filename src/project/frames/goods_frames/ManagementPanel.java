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
		// �׽�Ʈ�� ��ư�� ����� ������ǰ�� �߰��ǰ� Ȯ���ϱ�
		store.add(new JLabel("��ǰ�߰�") {
			{
				setBounds(20, 10, 100, 50);
				setFont(new Font("����", Font.BOLD, 20));
			}
		});
		store.add(new BasicTextField("��ǰ�� �̸��� �Է����ּ���") {
			{
				setLocation(20, 75);
			}
		});
		BasicTextField qtyTxt = new BasicTextField("������ �Է����ּ���");
		qtyTxt.setLocation(20, 120);
		store.add(qtyTxt);
		store.add(new BasicSmallButton("�߰�") {
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
		store.add(new BasicSmallButton("���") {
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
		
		add(new BasicSmallButton("�԰�") {
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
		
		add(new BasicSmallButton("���") {
			{
				setLocation(70, 0);
			}
		});
		
		add(new BasicSmallButton("���") {
			{
				setLocation(140, 0);
			}
		});
		
		add(new BasicSmallButton("��ǰ") {
			{
				setLocation(210, 0);
			}
		});
		
		add(new BasicTextField("�˻�� �Է����ּ���") {
			{
				setLocation(400, 0);
			}
		});
		
		add(new BasicSmallButton("�˻�") {
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
