package project.goods.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class BasicTextArea extends JTextArea {
	
	public BasicTextArea() {
		
		setSize(175, 25);
		setText("검색어를 입력해주세요");
		setFont(Font.getFont("돋음"));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setText("");
			}
		});
		setVisible(true);
		
	}

}
