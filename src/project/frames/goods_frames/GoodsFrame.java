package project.frames.goods_frames;

import javax.swing.JFrame;

import project.components.Buttons1;
import project.components.goods_components.BasicGnbButton;

public class GoodsFrame extends JFrame {

	public GoodsFrame() {
		ContentsPanel contents = new ContentsPanel();
		add(contents);
		add(new GnbPanel(contents));
		
		String[] snbButtons = {"��ǰ", "������", "����", "ȸ��", "�������̵�"};
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
