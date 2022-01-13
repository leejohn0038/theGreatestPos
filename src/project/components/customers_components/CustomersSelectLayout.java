package project.components.customers_components;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project.actions.customers_actions.CustomersSelectBtn;

public class CustomersSelectLayout extends JPanel{
	
	public CustomersSelectLayout() {
		//�޺��ڽ�
		final String[] COL_NAME = {"�޴��� ��ȣ", "�̸�", "������"};
		JComboBox<String> com = new JComboBox<>(COL_NAME);
		
		//�ؽ�Ʈ �ڽ�
		JTextField selectTxt = new JTextField("�˻��� �Է�");
		
		//������ ���� ��
		JLabel txtLab = new JLabel("���Ͻô� �׸����� ��ȸ�ϼ���");
	
		//comboBox ����
		com.setBounds(0,0, 500,30);
		
		//bottom layout ����
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(0, 0, 1000, 30);
		setBorder(new LineBorder(Color.black));
		
		add(txtLab);
		add(com);
		add(selectTxt);
		
		//�˻� ��ư
		add(new CustomersSelectBtn());
	}

}
