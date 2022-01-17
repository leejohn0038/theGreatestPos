package project.components.customers_components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project.actions.customers_actions.CustomersSelectBtn;
import project.actions.customers_actions.main.Function_ctm;
import project.components.customers_components.CustomersTableLayout;

public class CustomersSelectLayout extends JPanel{
	
	private JTextField selectTxt;				//����ڿ��� �޴� text	
	private JComboBox<String> com;				//����ڰ� ������ �޺��ڽ�
	private final String[] COL_NAME = new Function_ctm().getTitle();
	
	public CustomersSelectLayout(CustomersTableLayout tl) {
		
		
		//������ ���� ��
		JLabel txtLab = new JLabel("���Ͻô� �׸����� ��ȸ�ϼ���");
		
		//�޺��ڽ�
		com = new JComboBox<>(COL_NAME);
		com.setBounds(0,0, 500,30); //comboBox ����
		
		//�ؽ�Ʈ �ڽ�
		selectTxt = new JTextField("�˻��� �Է�");
		selectTxt.setSize(1000,20);
		//Txt
		selectTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectTxt.setText("");
			}
		});

		//bottom layout ����
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(0, 0, 1000, 30);
		setBorder(new LineBorder(Color.black));
		
		
		add(txtLab);
		add(com);
		add(selectTxt);
		
		//�˻� ��ư
		add(new CustomersSelectBtn(this, tl));
	}
	
	public JTextField getSelectTxt() {
		return selectTxt;
	}
	
	public JComboBox<String> getComboBox(){
		return com;
	}

}