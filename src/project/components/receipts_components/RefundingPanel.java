package project.components.receipts_components;



import javax.swing.JPanel;

import project.MainFrame;

public class RefundingPanel extends JPanel {
	
	public RefundingPanel(MainFrame main) {
		setLayout(null);
		setBounds(0, 300, 1000, 200);
		
		add(new Button(main, "카드정보입력", 650, 120, 130, 50));
		add(new Label("총합:", 100, 120, 300, 30));
		add(new Label("현금:", 100,20, 50, 30));
		add(new TextField(150, 20, 200, 30));
		add(new Label("카드", 100, 70, 50, 30));
		add(new TextField(150, 70, 200, 30));
	}
}
