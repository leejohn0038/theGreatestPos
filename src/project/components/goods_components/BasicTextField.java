package project.components.goods_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BasicTextField extends JTextField {
	
	public BasicTextField() {
		setSize(175, 25);
		setText("�˻�� �Է����ּ���");
		setFont(Font.getFont("����"));
		setAlignmentY(JTextArea.CENTER_ALIGNMENT);
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
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setText("");
					
				}
			}
		});
		setVisible(true);
	}
	
	public BasicTextField(String str) {
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
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setText(str);
				}
			}
		});
		setVisible(true);
		
	}
}






















