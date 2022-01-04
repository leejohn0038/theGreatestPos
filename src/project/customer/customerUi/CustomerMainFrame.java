package project.customer.customerUi;

import javax.swing.JFrame;



public class CustomerMainFrame extends JFrame {
	
	public CustomerMainFrame() {
		new CustomerInputFieldUi();
		
		String[] CIbtn = {"ID : ", "이름 : ", "휴대폰 번호 : ", "주소 : ", "가입일자 : ", "멤버십 포인트 : "};

		for (int i = 0; i < CIbtn.length; ++i) {
			add(new CustomerInputButtonUi(CIbtn[i]));
		}

	}
	public static void main(String[] args) {
		new CustomerMainFrame();
	}
}
