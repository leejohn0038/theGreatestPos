package project;

import javax.swing.JFrame;

import project.actions.obj.User_Data;
import project.components.receipts_components.MainButtons;
import project.components.receipts_components.ReceiptButtons;
import project.components.receipts_components.Tables;
import project.components.receipts_components.Toppanel;
import project.frames.receipts_frames.Frames;

public class MainFrame extends JFrame {
	
	private Frames frames;
	private static User_Data user;
	
	public MainFrame() {
		
		setBounds(500, 100, 1000, 700);
		
		frames = new Frames(this);
		
		add(new Toppanel(this, "판매"));
		add(new Tables(new String[] {"상품id", "상품이름", "수량", "가격"}, 300, 100, 680, 300));
		
		String[] btnNames1 = {"상품", "영수증", "직원", "회원", "업무가이드"};
		String[] btnNames2 = {"포인트 적립", "현금 영수증", "영수증 발급"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new MainButtons(this, btnNames1[i]));
		}
		
		for(int i = 0; i < btnNames2.length; ++i) {
			add(new ReceiptButtons(this, btnNames2[i], 0));
		}
		
		setLayout(null);
		//setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(false);
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame(String btn) {
		return frames.getFrame(btn);
	}
	
	int loginID() {
		return user.getUserId();  
	}
	
	public static void main(String[] args) {
		
		user = new Login(new MainFrame()).getUserData();
	}
}

