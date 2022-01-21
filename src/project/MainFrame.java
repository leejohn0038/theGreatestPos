package project;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import project.actions.goods_actions.CloseWindow;
import project.actions.obj.User_Data;
import project.components.goods_components.ButtonImage;
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
	private JButton closeBtn;
	private ButtonImage img = new ButtonImage();
	
	public MainFrame() {
		
		setBounds(500, 100, 1000, 700);
		
		frames = new Frames(this);
		add(new Toppanel("판매"));
		add(table = new Tables(new String[] {"상품id", "상품이름", "수량", "가격"}, 230, 70, 760, 460));
		String[] btnNames1 = {"상품", "영수증", "직원", "회원"};
		String[] items = {"현금", "카드"};
		ImageIcon[] btnImage = {img.mainGoods(), img.mainReceipt(), img.mainEmployee(), img.mainCustomer()};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new MainButtons(this, btnNames1[i], btnImage[i]));
		}
		add(field = new TextField(530, 540, 200, 30));
		add(new SaleSubmitBtn(this, 530, 590, 270, 100));
		add(combo = new JComboBox<String>(items) {{setBounds(730, 540, 70, 30);}});
		add(new BuySubmitBtn(this, 840, 540, 150, 150));
		add(new DeleteBtn(this));
		
		add(new JLabel() {{
			setBounds(0, 0, 200, 150);
			setIcon(new ImageIcon("./image/logo.png"));
		}});
		closeBtn = new JButton(new ImageIcon("./image/home.png"));
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorderPainted(false);
		closeBtn.setBounds(930, 10, 60, 25);
		closeBtn.addActionListener(new CloseWindow(this));
		add(closeBtn);
		
		//백그라운드 색깔용 패널
		add(new JPanel() {{setBounds(0, 0, 1000, 700); setBackground(Color.WHITE);}});
		
		setLayout(null);
		setVisible(false);
		setResizable(false); 
		setUndecorated(true);
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

