package project.components.customers_components;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.components.customers_components.CustomersSelectLayout;
import project.components.customers_components.CustomersSideBarLayout;
import project.components.customers_components.CustomersTableLayout;

public class CustomersBottomLayout extends JPanel{
	public CustomersBottomLayout(MainFrame main, JFrame ctm) {
		//ctm 참조형 매개변수로서 width와 height를 반환한다?
		
		// 목표 : ctm은 어디에서 어떤 값을 넣어야 하는 것 인지
		// TopLayout으로 추정된다 이름이 바텀레이아웃인데 바텀에 탑이 들어가는게 맞나 의심
		int fw = ctm.getSize().width, fh = ctm.getSize().height;
		/*
		 이 구성 요소의 크기를 차원 개체 형식으로 반환합니다.
		  차원 객체의 높이 필드는 구성요소의
 			높이를 포함하고 차원 객체의 너비 필드는 구성요소의 너비를 포함합니다.
		*/
		//레이아웃 초기설정
		int[] layoutBounds = {0, (int)(fh*0.2), fw, (int)(fh*0.8)};
		int height;
		
		JPanel inner_layout = new JPanel();
		// CustomersSelectLayout
		JPanel select = new CustomersSelectLayout();
		JPanel side;
		

		add(select);
		height = select.getSize().height;
		System.out.println();
		
		//select 관련 레이아웃이 한자리 먹고 있음 그거 높이 빼주는 계산 해줘야함!
		inner_layout.setLayout(null);
		inner_layout.setBounds(0, 0, layoutBounds[2], layoutBounds[3]-height);
		
		side = new CustomersSideBarLayout(main, layoutBounds[2], layoutBounds[3]);
		inner_layout.add(side);
		inner_layout.add(new CustomersTableLayout(side.getSize().width));
		
		add(inner_layout);
		
		setLayout(null);
		setBounds(layoutBounds[0], layoutBounds[1], layoutBounds[2], layoutBounds[3]);
		setBorder(new LineBorder(Color.black));
	}
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		new CustomersBottomLayout(main, null);
	}
}
