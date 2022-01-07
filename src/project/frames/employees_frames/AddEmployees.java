package project.frames.employees_frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.w3c.dom.Text;

import project.actions.employees_actions.AddBtn;

public class AddEmployees extends JFrame{
	
	private int frame_size[] = {700,500}; 
	
	public AddEmployees() {
		
		add(inner_lay());
		//add(out_lay());
		setBounds(500,500,frame_size[0],frame_size[1]);
		setVisible(false);
	}
	
	/*
	// Ȥ�� �𸣴� �ϴ� ���ܵΰڽ��ϴ�. �� �߰��� �� �г� �̿��ϱ�����
	JPanel out_lay() {
		String[] locNames = {"East", "West", "South", "North"};
		JPanel out = new JPanel();
		
		out.setLayout(new BorderLayout());
		
		for(int i = 0; i<locNames.length; i++) {
			JPanel sideLay = new JPanel();
			sideLay.setBorder(new LineBorder(Color.black));
			out.add(sideLay, locNames[i]);
		}
		
		out.add(inner_lay(), "Center");
		return out;
	}*/
	
	JPanel inner_lay() {
		
		JPanel inner = new JPanel();
		JLabel exLab = new JLabel("����Ͻ� ���� ������ �Է����ּ���");
		JButton btn = new JButton("���");
		
		String[] title_labs = {"ID", "�̸�", "��ȭ��ȣ", "��å"}; 
		ArrayList<JLabel> labs = new ArrayList<>();
		HashMap<String,Object> txts = new HashMap<>();
		
		int exLab_x; 
		
		inner.setLayout(null);
		//inner.setSize(100,100);
		
		//��� �����
		exLab.setSize(300, 50);
		exLab_x = Math.abs((frame_size[0]-exLab.getSize().width)/2);
		exLab.setLocation(exLab_x,0);
		exLab.setFont(new Font("consolas|����", Font.BOLD, 15));
		
		for(int i = 0; i<title_labs.length;i++) {
			
			JLabel lab = new JLabel();
			JLabel idLab = new JLabel();
			JTextField txt = new JTextField();
			int txtLoc[] = new int[2];
			
			//�󺧷� ���� ǥ��
			lab.setText(title_labs[i]);
			lab.setBounds(50,(i+1)*75,200,50);
			lab.setFont(new Font("consolas|����", Font.BOLD,20));
			lab.setBorder(new LineBorder(Color.black));
			
			//�ؽ�Ʈ�ʵ�
			txtLoc[0] = lab.getSize().width + lab.getLocation().x + 50;
			txtLoc[1] = lab.getLocation().y;
			
			labs.add(lab);
			
			//���̵� ���� db�� ���� ������� �������� ����
			if(i==0) {
				idLab.setText("101");
				idLab.setBounds(txtLoc[0], txtLoc[1], 300, 50);
				txts.put(title_labs[i], idLab);
				inner.add(idLab);
			}else {
				txt.setBounds(txtLoc[0], txtLoc[1], 300, 50);
				txts.put(title_labs[i], txt);
				inner.add(txt);
			}
			inner.add(lab);
		}
		
		btn.setSize(100,50);
		btn.setLocation(frame_size[0]-btn.getSize().width-100, frame_size[1]-btn.getSize().height-50);
		btn.addActionListener(new AddBtn());
		
		inner.add(exLab);
		inner.add(btn);
		
		return inner;
	}
}














