package project.components.goods_components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class BasicTextArea extends JTextArea {
	
	public BasicTextArea() {
		setSize(175, 25);
		setText("�˻�� �Է����ּ���");
		setFont(Font.getFont("����"));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setText("");
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				setText("�˻�� �Է����ּ���");
			}
		});
		setVisible(true);
	}
	
	public BasicTextArea(String str) {
		super(str);
		setSize(175, 25);
		setFont(Font.getFont("����"));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setText("");
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (getText().isEmpty()) {
					setText(str);
				}
			}
		});
		setVisible(true);
		
	}
}






















