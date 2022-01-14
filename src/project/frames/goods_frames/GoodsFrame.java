package project.frames.goods_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.receipts_components.MainButtons;


public class GoodsFrame extends JFrame {

	public GoodsFrame(MainFrame main) {
		ContentsPanel contents = new ContentsPanel();
		add(contents);
		add(new GnbPanel(contents));
		
		String[] snbButtons = {"상품", "영수증", "직원", "회원", "업무가이드"};
		for (int i = 0; i < snbButtons.length; ++i) {
			add(new MainButtons(main, snbButtons[i]));
		}
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
}