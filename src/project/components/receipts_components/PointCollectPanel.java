package project.components.receipts_components;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PointCollectPanel extends JPanel {
	
	public PointCollectPanel() {
		
		setLayout(null);
		setBounds(0, 200, 1000, 300);
		add(new TextField(300, 50, 200, 50));
		add(new Label("금액:", 200,50, 50, 50));
		add(new Label("전화번호:", 200,120, 100, 50));
		add(new TextField(300, 120, 200, 50));
	}

}
