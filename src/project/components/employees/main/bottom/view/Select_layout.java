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
		//콤보박스
		final String[] COL_NAME = {"id", "이름", "전화번호"};
		JComboBox<String> com = new JComboBox<>(COL_NAME);
		
		//텍스트 박스
		JTextField selectTxt = new JTextField("검색어 입력");
		
		//간단한 설명 라벨
		JLabel txtLab = new JLabel("원하시는 항목으로 조회하세요");
	
		//comboBox 설정
		com.setBounds(0,0, 500,30);
		
		//bottom layout 설정
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(0, 0, 1000, 30);
		setBorder(new LineBorder(Color.black));
		
		add(txtLab);
		add(com);
		add(selectTxt);
		
		//검색 버튼
		add(new SelectBtn());
	}

}
