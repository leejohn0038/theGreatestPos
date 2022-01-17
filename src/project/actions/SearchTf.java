package project.actions;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchTf {

	public SearchTf(TableRowSorter<TableModel> rowSorter, JTextField textfield) {
		rowSorter.addRowSorterListener(null);
		textfield.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String keyword = textfield.getText();
				
				if (keyword.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String keyword = textfield.getText();
				
				if (keyword.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}
		});
	}
}
