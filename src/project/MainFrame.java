package project;

import javax.swing.JFrame;

import project.components.receipts_components.MainButtons;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;
import project.frames.receipts_frames.Frames;

public class MainFrame extends JFrame {
	
	private Frames frames;
	
	public MainFrame() {
		frames = new Frames(this);
		add(new Toppanel(this, "판매"));
		add(new Tables(new String[] {"상품id", "상품이름", "수량", "가격"}, 300, 100, 680, 300));
		
		String[] btnNames1 = {"상품", "영수증", "직원", "회원", "업무가이드"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new MainButtons(this, btnNames1[i]));
		}
			
		setLayout(null);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame(String btn) {
		return frames.getFrame(btn);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}

