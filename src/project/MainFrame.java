package project;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import project.components.receipts_components.BuySubmitBtn;
import project.components.receipts_components.MainButtons;
import project.components.receipts_components.SaleSubmitBtn;
import project.components.receipts_components.Tables;
import project.components.receipts_components.TextField;
import project.components.receipts_components.Toppanel;
import project.frames.receipts_frames.Frames;

public class MainFrame extends JFrame {
	
	private Frames frames;
	private JTextField field;
	private Tables table;
	private int totalPrice;
	
	public MainFrame() {
		frames = new Frames(this);
		add(new Toppanel(this, "�Ǹ�"));
		add(table = new Tables(this, new String[] {"��ǰid", "��ǰ�̸�", "����", "����"}, 300, 100, 680, 300));
		
		String[] btnNames1 = {"��ǰ", "������", "����", "ȸ��", "�������̵�"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new MainButtons(this, btnNames1[i]));
		}
		add(field = new TextField(300, 450, 200, 30));
		add(new SaleSubmitBtn(this, 520, 450, 70, 30));
		add(new BuySubmitBtn(this, 450, 550, 100, 50));
		
		setLayout(null);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame(String btn) {
		return frames.getFrame(btn);
	}
	
	public JTextField getField() {
		return field;
	}
	
	public Tables getTable() {
		return table;
	}
	
	public JTable getJTable() {
		return table.getTable();
	}
	
	public int getTotalPrice() {
		totalPrice = 0;
		for (int i = 0; i < getJTable().getRowCount(); ++i) {
			totalPrice += Integer.parseInt(String.valueOf(getJTable().getValueAt(i, 3)));
		}
		return totalPrice;
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
}

