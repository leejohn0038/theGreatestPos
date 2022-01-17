package project.frames.goods_frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.receipts_components.MainButtons;



public class GoodsFrame extends JFrame {
	ContentsPanel contents;
	
	public GoodsFrame(MainFrame main) {
		contents = new ContentsPanel();
		add(contents);
		add(new GnbPanel(contents));
		
		String[] snbButtons = {"상품", "영수증", "직원", "회원", "업무가이드"};
		for (int i = 0; i < snbButtons.length; ++i) {
			add(new MainButtons(main, snbButtons[i]));
		}
		
		contents.getManagementPanel().getExportConfirm().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
		contents.getManagementPanel().getImportConfirm().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setVisible(false);
		setResizable(false);
	}
	
	void importRefresh() {
		contents.getManagementPanel().getImportConfirm().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
	}
	
	void exportRefresh() {
		contents.getManagementPanel().getExportConfirm().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
	}
	
	public void refresh() {
		contents.getLookupPanel().getLookupTable().getTableModel().fireTableDataChanged();
		contents.getLookupPanel().getLookupTable().repaint();
	}
	
}
