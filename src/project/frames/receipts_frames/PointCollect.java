package project.frames.receipts_frames;

import javax.swing.JFrame;

import project.components.Toppanel;
import project.components.receipts_components.PointCollectPanel;
import project.components.receipts_components.SubmitBtn;

public class PointCollect extends JFrame {
	
	public PointCollect() {
		add(new Toppanel("����Ʈ ����"));
		add(new PointCollectPanel());
		add(new SubmitBtn());
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new PointCollect();
	}
}
