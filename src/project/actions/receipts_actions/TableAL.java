package project.actions.receipts_actions;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.MainFrame;
import project.frames.receipts_frames.Refunding;

public class TableAL implements ListSelectionListener{

	MainFrame main;
	JTable refundTable;
	int a = 0;
	
	public TableAL(MainFrame main) {
		this.main = main;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		refundTable = ((Refunding)main.getFrame("반품업무")).getJTable();
		for (int i = 0; i < refundTable.getRowCount(); ++i) {
			if(refundTable.isRowSelected(i)) {
				System.out.println(++a);
			}else {
				System.out.println(--a);
			}
		}
		
	}

}
