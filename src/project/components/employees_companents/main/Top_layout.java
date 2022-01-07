package project.components.employees_companents.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//프레임의 상단 레이아웃 (logo / 조회 / 등록 / 편집 버튼)
public class Top_layout extends JPanel{
	public Top_layout(JFrame emp) {
		int fw = emp.getSize().width, fh = emp.getSize().height;
		
		//top_layout
		int height = (int)(fh*0.2);

		//inner_left_layout
		int layL_width = (int)(fw*0.2);;
		/*
		// 로고 가운데로 출력해주려 계산식 보류
		int layL_x = (layL_width-100) / 2;
		int layL_y = (height-100) / 2;
		*/
		JPanel left = new JPanel(); //왼쪽은 로고 레이아웃
		
		//inner_right_layout
		int layR_width = (int)(fw*0.8); // 가로 길이
		
		//로고 추가
		left.setBounds(0,0, layL_width, height);
		left.setBorder(new LineBorder(Color.black));
		left.add(new JLabel("logo"));
		
		//왼쪽 레이아웃
		add(left);
		//오른쪽 레이아웃
		add(new Nav_layout(layL_width, layR_width, height));
		
		setLayout(null);
		setBounds(0, 0, fw, height);	//상단 레이아웃은 20%만 먹게
		setBorder(new LineBorder(Color.black));
		setVisible(true);
		
	}
}
