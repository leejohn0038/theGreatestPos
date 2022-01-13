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
		//콤보박스
		final String[] COL_NAME = {"휴대폰 번호", "이름", "가입일"};
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
		add(new CustomersSelectBtn());
	}

}
