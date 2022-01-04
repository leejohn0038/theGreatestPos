package project.frames;

import javax.swing.JFrame;

import project.components.Buttons2;
import project.components.Buttons3;
import project.components.Tables;
import project.components.Toppanel;

public class Receipts extends JFrame {
	
	
	public Receipts() {
		add(new Toppanel("영수증"));
		add(new Tables(100, 250, 200));
		
		String[] btnNames3 = {"매출구분", "구매시기", "결제수단", "판매금액", "상품코드", "영수증번호"};
		for (int i = 0; i < btnNames3.length; ++i) {			
			add(new Buttons3(btnNames3[i]));
		}
				String[] btnNames2 = {"포인트 적립", "현금 영수증", "영수증 발급", "반품업무"};
		for (int i = 0; i < btnNames2.length; ++i) {
			add(new Buttons2(btnNames2[i], 200));
		}
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false);
	}
}
