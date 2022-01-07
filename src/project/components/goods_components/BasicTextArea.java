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
		setText("검색어를 입력해주세요");
		setFont(Font.getFont("돋움"));
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
				setText("검색어를 입력해주세요");
			}
		});
		setVisible(true);
	}
	
	public BasicTextArea(String str) {
		super(str);
		setSize(175, 25);
		setFont(Font.getFont("돋움"));
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






















