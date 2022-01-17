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
	
	private JTextField selectTxt;				//사용자에게 받는 text	
	private JComboBox<String> com;				//사용자가 선택한 콤보박스
	private final String[] COL_NAME = new Function_ctm().getTitle();
	
	public CustomersSelectLayout(CustomersTableLayout tl) {
		
		
		//간단한 설명 라벨
		JLabel txtLab = new JLabel("원하시는 항목으로 조회하세요");
		
		//콤보박스
		com = new JComboBox<>(COL_NAME);
		com.setBounds(0,0, 500,30); //comboBox 설정
		
		//텍스트 박스
		selectTxt = new JTextField("검색어 입력");
		selectTxt.setSize(1000,20);
		//Txt
		selectTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectTxt.setText("");
			}
		});

		//bottom layout 설정
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(0, 0, 1000, 30);
		setBorder(new LineBorder(Color.black));
		
		
		add(txtLab);
		add(com);
		add(selectTxt);
		
		//검색 버튼
		add(new CustomersSelectBtn(this, tl));
	}
	
	public JTextField getSelectTxt() {
		return selectTxt;
	}
	
	public JComboBox<String> getComboBox(){
		return com;
	}

}