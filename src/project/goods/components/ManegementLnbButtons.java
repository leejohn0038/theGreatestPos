package project.goods.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ManegementLnbButtons extends JButton {
	private final static HashMap<String, Point> LNB_NAV_BUTTON = new HashMap<>();
	static {
		LNB_NAV_BUTTON.put("¿‘∞Ì", new Point(0, 0));
		LNB_NAV_BUTTON.put("√‚∞Ì", new Point(100, 0));
		LNB_NAV_BUTTON.put("∆Û±‚", new Point(200, 0));
		LNB_NAV_BUTTON.put("π›«∞", new Point(300, 0));
	}
	
	public ManegementLnbButtons(String btn) {
		setText(btn);
		setSize(60, 25);
		setFont(Font.getFont("µ∏¿Ω"));
		setLocation(LNB_NAV_BUTTON.get(btn));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setMargin(new Insets(0, 0, 0, 0));
	}
}
