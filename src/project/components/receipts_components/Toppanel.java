package project.components.receipts_components;

import java.awt.Font;

import javax.swing.JPanel;

import project.MainFrame;

public class Toppanel extends JPanel{
	
	public Toppanel(MainFrame main, String name) {
		
		add(new Label(name, 0, 20, 300, 40) {
			{
				setFont(new Font("µ¸À½", Font.BOLD, 30));
			}
		});
		add(new TextField(500, 20, 270, 40));
		add(new Button(main, "°Ë»ö", 800, 20, 70, 40));
		setBounds(100, 0, 930, 100);
		setLayout(null);		
	}
	
	public Toppanel (String name) {
			
			add(new Label(name, 0, 20, 300, 40) {
				{
					setFont(new Font("µ¸À½", Font.BOLD, 30));
				}
			});
			setBounds(100, 0, 930, 100);
			setLayout(null);		
		}
}
