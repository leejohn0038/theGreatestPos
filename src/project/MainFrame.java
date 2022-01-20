package project;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import project.actions.obj.User_Data;
import project.components.receipts_components.BuySubmitBtn;
import project.components.receipts_components.DeleteBtn;
import project.components.receipts_components.MainButtons;
import project.components.receipts_components.SaleSubmitBtn;
import project.components.receipts_components.Tables;
import project.components.receipts_components.TextField;
import project.components.receipts_components.Toppanel;
import project.frames.receipts_frames.Frames;

public class MainFrame extends JFrame {
	
	private Frames frames;
	private static User_Data user;
	private JTextField field;
	private Tables table;
	private int totalPrice;
	private JComboBox<String> combo;
	private boolean print;
	private int rid;
	
	public MainFrame() {
		frames = new Frames(this);
		add(new Toppanel("판매"));
		add(table = new Tables(new String[] {"상품id", "상품이름", "수량", "가격"}, 300, 100, 680, 300));
		
		String[] btnNames1 = {"상품", "영수증", "직원", "회원", "업무가이드"};
		String[] items = {"현금", "카드"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new MainButtons(this, btnNames1[i]));
		}
		add(field = new TextField(610, 450, 200, 30));
		add(new SaleSubmitBtn(this, 830, 450, 70, 30));
		add(combo = new JComboBox<String>(items) {{setBounds(910, 450, 70, 30);}});
		add(new BuySubmitBtn(this, 450, 550, 100, 50));
		add(new DeleteBtn(this));
		setLayout(null);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
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
	
	public String getCombo() {
		return combo.getSelectedItem().toString();
	}
	
	
	public int loginID() {
		return user.getUserId();  
	}
	
	public void setPrint(boolean print) {
		this.print = print;
	}
	
	public boolean getPrint() {
		return print;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	 
	public int getRid() {
		return rid;
	}
	
	public static void main(String[] args) {
		user = new Login(new MainFrame()).getUserData();
	}
	
}

