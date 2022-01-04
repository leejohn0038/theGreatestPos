package project.components.employees.main.top.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//�������� ��� ���̾ƿ� (logo / ��ȸ / ��� / ���� ��ư)
public class Top_layout extends JPanel{
	public Top_layout(int fw, int fh) {
		
		//top_layout
		int height = (int)(fh*0.2);

		//inner_left_layout
		int layL_width = (int)(fw*0.2);;
		/*
		// �ΰ� ����� ������ַ� ���� ����
		int layL_x = (layL_width-100) / 2;
		int layL_y = (height-100) / 2;
		*/
		JPanel left = new JPanel(); //������ �ΰ� ���̾ƿ�
		
		//inner_right_layout
		int layR_width = (int)(fw*0.8); // ���� ����
		
		//�ΰ� �߰�
		left.setBounds(0,0, layL_width, height);
		left.setBorder(new LineBorder(Color.black));
		left.add(new JLabel("logo"));
		
		//���� ���̾ƿ�
		add(left);
		//������ ���̾ƿ�
		add(new Nav_layout(layL_width, layR_width, height));
		
		setLayout(null);
		setBounds(0, 0, fw, height);	//��� ���̾ƿ��� 20%�� �԰�
		setBorder(new LineBorder(Color.black));
		setVisible(true);
		
	}
}