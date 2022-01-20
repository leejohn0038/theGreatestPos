package project.components.goods_components;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class BasicDropbox extends JComboBox<String> {
	
	public BasicDropbox(String[] combo) {
		
		setSize(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		ArrayList<String> abc = new ArrayList<>();
//		abc.add("a");
//		abc.add("b");
//		abc.add("asdf");
		
		
		String[] aaa = new String[abc.size()];
		
		for (int i = 0; i < abc.size(); ++i) {
			aaa[i] = abc.get(i);
		}
		
		
		
		JComboBox<String> cb = new JComboBox<>(aaa);
		cb.setSize(100, 100);
//		cb.se
		JFrame frame = new JFrame();
		cb.setLocation(100, 100);
		frame.add(cb);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}














