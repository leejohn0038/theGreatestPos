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
		Refunding refunding = (Refunding)main.getFrame("반품업무"); 
		CardInfo cardinfo = (CardInfo)main.getFrame("카드정보입력");
		String text = cardinfo.getField().getText();
		if (FieldRegexLimit.isValid(Regex.getRegex()[4], text)) {
			if(refunding.getCardinfo().equals(text)) {
				JOptionPane.showMessageDialog(cardinfo, "확인되었습니다.");
				cardinfo.setVisible(false);
				refunding.setCardrefund(true);
			} else {				
				JOptionPane.showMessageDialog(cardinfo, "카드 정보가 일치하지 않습니다.");
			}
		} else if(text.equals("")) {
			JOptionPane.showMessageDialog(cardinfo, "카드 정보를 입력해주세요.");
		} else {
			JOptionPane.showMessageDialog(cardinfo, "형식에 맞지 않는 입력입니다.");
		}
		
	}

}
