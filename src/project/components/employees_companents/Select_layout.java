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
	private final String[] COL_NAME;
	
	public Select_layout(Table_layout tl, int locX, int locY, int type) {
		
		int padding = 10;
		int[] selectSize = {tl.getSize().width-150, 50};
		
		//�г� setting
		setLayout(null);
		setBounds(locX, locY-selectSize[1],selectSize[0], selectSize[1]);
		
		//������ ���� ��
		JLabel txtLab = new JLabel("���Ͻô� �׸����� ��ȸ�ϼ���");
		txtLab.setBounds(padding,0,200,50);
		
		//�޺��ڽ�
		int[] comSize = {80, 30};
		COL_NAME = new Function_emp().getTitle(type);
		com = new JComboBox<>(COL_NAME);
		com.setBounds(txtLab.getSize().width + txtLab.getLocation().x, (selectSize[1] - comSize[1])/2, comSize[0],comSize[1]); //comboBox ����
		
		//�˻� ������
		int[] btnSize = {70, 30};
		
		//�ؽ�Ʈ �ڽ�
		int[] txtSize = {250 - btnSize[0], 30};
		selectTxt = new JTextField("�˻��� �Է�");
		selectTxt.setBounds(com.getSize().width + com.getLocation().x, (selectSize[1] - txtSize[1])/2, txtSize[0], txtSize[1]);;
		
		selectTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectTxt.setText("");
			}
		});
		

		add(txtLab);
		add(com);
		add(selectTxt);
		
		//�˻� ��ư
		int[] loc = {selectTxt.getSize().width + selectTxt.getLocation().x, 
				(selectSize[1] - btnSize[1])/2};
		add(new SelectBtn(this, tl, btnSize, loc, type));
	}
	
	public JTextField getSelectTxt() {
		return selectTxt;
	}
	
	public JComboBox<String> getComboBox(){
		return com;
	}

}
