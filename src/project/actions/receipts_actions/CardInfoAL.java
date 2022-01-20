package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.MainFrame;
import project.frames.receipts_frames.CardInfo;
import project.frames.receipts_frames.Refunding;

public class CardInfoAL implements ActionListener{

	MainFrame main;
	
	public CardInfoAL(MainFrame main) {
		this.main = main;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Refunding refunding = (Refunding)main.getFrame("��ǰ����"); 
		CardInfo cardinfo = (CardInfo)main.getFrame("ī�������Է�");
		String text = cardinfo.getField().getText();
		if (FieldRegexLimit.isValid(Regex.getRegex()[4], text)) {
			if(refunding.getCardinfo().equals(text)) {
				JOptionPane.showMessageDialog(cardinfo, "Ȯ�εǾ����ϴ�.");
				cardinfo.setVisible(false);
				refunding.setCardrefund(true);
			} else {				
				JOptionPane.showMessageDialog(cardinfo, "ī�� ������ ��ġ���� �ʽ��ϴ�.");
			}
		} else if(text.equals("")) {
			JOptionPane.showMessageDialog(cardinfo, "ī�� ������ �Է����ּ���.");
		} else {
			JOptionPane.showMessageDialog(cardinfo, "���Ŀ� ���� �ʴ� �Է��Դϴ�.");
		}
		
	}

}
