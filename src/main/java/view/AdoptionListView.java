package view;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pets.*;

public class AdoptionListView extends JFrame {
	private JList list;
	private JPanel panel;
	
	public AdoptionListView() {
		setTitle("Animal Shelter Adoption Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>(); 
		list = new JList<Pet>(modelList);
	
		list.setBounds(68, 85, 390, 174);
		panel.add(list);
		
	}
}
