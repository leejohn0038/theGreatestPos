package project.goods.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class LookupLnbButtons extends JButton {
	private final static HashMap<String, Point> LNB_NAV_BUTTON = new HashMap<>();
	static {
		LNB_NAV_BUTTON.put("전체", new Point(0, 0));
		LNB_NAV_BUTTON.put("카테고리", new Point(100, 0));
		LNB_NAV_BUTTON.put("유통기한", new Point(200, 0));
		LNB_NAV_BUTTON.put("거래처", new Point(300, 0));
	}
	
	public LookupLnbButtons(String btn) {
		setText(btn);
		setSize(50, 25);
		setFont(Font.getFont("돋음"));
		setLocation(LNB_NAV_BUTTON.get(btn));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setMargin(new Insets(0, 0, 0, 0));

	}
}
