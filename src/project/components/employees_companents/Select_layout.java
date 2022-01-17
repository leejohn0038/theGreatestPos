package project.components.employees_companents;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.SelectBtn;
import project.actions.employees_actions.main.Function_emp;
import project.database.employee_customer.SQLs;

public class Select_layout extends JPanel{
	
	private JTextField selectTxt;				//����ڿ��� �޴� text	
	private JComboBox<String> com;				//����ڰ� ������ �޺��ڽ�
	private final String[] COL_NAME = new Function_emp().getTitle(1);
	
	public Select_layout(Table_layout tl) {
		
		
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
		add(new SelectBtn(this, tl));
	}
	
	public JTextField getSelectTxt() {
		return selectTxt;
	}
	
	public JComboBox<String> getComboBox(){
		return com;
	}

}
