package project.goods.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class BasicTextArea extends JTextArea {
	
	public BasicTextArea() {
		
		setSize(200, 25);
		setText("검색어를 입력해주세요");
		setFont(Font.getFont("돋음"));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setVisible(true);
		
	}

}
