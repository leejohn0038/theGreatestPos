package project.frames.receipts_frames;

import java.util.ArrayList;

import javax.swing.JFrame;

import project.components.receipts_components.Tables;

public class PrintedRcp extends JFrame {

	public PrintedRcp(ArrayList<Object[]> arr) {
		add(new Tables(new String[] {"상품이름", "수량", "가격"},0, 0, 400, 300) {{updateRows(arr);}});
		
		setVisible(true);
		setBounds(600, 200, 500, 500);
	}
	
}
