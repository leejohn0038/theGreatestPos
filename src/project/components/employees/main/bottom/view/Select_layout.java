package project.components.employees.main.bottom.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project.components.employees.Actions.SelectBtn;

public class Select_layout extends JPanel{
	
	public Select_layout() {
		//�޺��ڽ�
		final String[] COL_NAME = {"id", "�̸�", "��ȭ��ȣ"};
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
		add(new SelectBtn());
	}

}
