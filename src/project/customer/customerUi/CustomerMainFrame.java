package project.customer.customerUi;

import javax.swing.JFrame;



public class CustomerMainFrame extends JFrame {
	
	public CustomerMainFrame() {
		new CustomerInputFieldUi();
		
		String[] CIbtn = {"ID : ", "�̸� : ", "�޴��� ��ȣ : ", "�ּ� : ", "�������� : ", "����� ����Ʈ : "};

		for (int i = 0; i < CIbtn.length; ++i) {
			add(new CustomerInputButtonUi(CIbtn[i]));
		}

	}
	public static void main(String[] args) {
		new CustomerMainFrame();
	}
}
