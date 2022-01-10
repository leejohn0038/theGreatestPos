package project;

import javax.swing.JFrame;

import project.components.receipts_components.MainButtons;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;
import project.frames.Frames;

public class MainFrame extends JFrame {
	
	private Frames frames;
	
	public MainFrame() {
		frames = new Frames(this);
		add(new Toppanel("판매"));
		add(new Tables(new String[] {"상품id", "상품이름", "수량", "가격"}));
		
		String[] btnNames1 = {"상품", "영수증", "직원", "회원", "업무가이드"};
		String[] btnNames2 = {"포인트 적립", "현금 영수증", "영수증 발급"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new MainButtons(this, btnNames1[i]));
		}
		
		for(int i = 0; i < btnNames2.length; ++i) {
			add(new ReceiptButtons(this, btnNames2[i]));
		}
			
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false); 
	}
	
	public JFrame getFrame(String btn) {
		return frames.FRAMES.get(btn);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}

