package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.components.receipts_components.PointCollectPanel;
import project.components.receipts_components.Toppanel;

public class PointCollect extends JFrame {
	
	public PointCollect() {
		add(new Toppanel("포인트 적립"));
		add(new PointCollectPanel());
		//add(new SubmitBtn(450, 500, 100, 50));
		
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new PointCollect();
	}
}
