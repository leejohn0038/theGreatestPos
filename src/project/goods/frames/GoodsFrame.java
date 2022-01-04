package project.goods.frames;

import javax.swing.JFrame;

import project.components.Buttons1;
import project.goods.components.BasicGnbButton;
import project.goods.components.GoodsGnbButtons;

public class GoodsFrame extends JFrame {

	public GoodsFrame() {
		add(new GoodsGnbButtons());
		add(new ContentsPanel());
		
		String[] snbButtons = {"상품", "영수증", "직원", "회원", "업무가이드"};
		for (int i = 0; i < snbButtons.length; ++i) {
			//add(new Buttons1(snbButtons[i]));
		}

		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false);
	}
	
}
