package project.goods.frame;

import javax.swing.JFrame;

import project.components.Buttons1;
import project.goods.components.BasicGnbButton;

public class GoodsFrame extends JFrame {

	public GoodsFrame() {
		ContentsPanel contents = new ContentsPanel();
		add(new GnbPanel(contents));
		add(contents);
		
		String[] snbButtons = {"상품", "영수증", "직원", "회원", "업무가이드"};
		for (int i = 0; i < snbButtons.length; ++i) {
			add(new Buttons1(snbButtons[i]));
		}
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false);
	}
	
}
