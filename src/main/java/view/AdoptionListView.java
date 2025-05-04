package view;

import java.util.*;

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
	
	private JButton removePetButton;
	private JButton addPetButton;
	private JButton viewDetailsButton;
	private JButton adoptPetButton;
	private JButton saveButton;
	
	private DefaultListModel<Pet> modelList;
	
	
	public AdoptionListView() {
		setTitle("Animal Shelter Adoption Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		modelList = new DefaultListModel<Pet>(); 
		list = new JList<Pet>(modelList);
	
		list.setBounds(68, 85, 390, 174);
		panel.add(list);
		
		adoptPetButton = new JButton("Adopt Selected Animal");
		adoptPetButton.setBounds(66, 285, 177, 23);
		panel.add(adoptPetButton);
		
		viewDetailsButton = new JButton("View Animal Details");
		viewDetailsButton.setBounds(250, 285, 177, 23);
		panel.add(viewDetailsButton);
		
		addPetButton = new JButton("Add a Pet");
		addPetButton.setBounds(66, 315, 177, 23);
		panel.add(addPetButton);
		
		removePetButton = new JButton("Remove a Pet");
		removePetButton.setBounds(250, 315, 177, 23);
		panel.add(removePetButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(158, 345, 177, 23);
		panel.add(saveButton);
	}
	public void setModelList(List<Pet> shelter) {
		modelList.clear();
		for(Pet pet : shelter) {
			modelList.addElement(pet);
		}
	}
	
	public void addActionListenerToRemovePetButton(ActionListener listener) {
		removePetButton.addActionListener(listener);
	}
	
	public void addActionListenerToAdoptPetButton(ActionListener listener) {
		adoptPetButton.addActionListener(listener);
	}
	
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	
	public int getSelectedPetIndex() {
		System.out.println("Selected pet index: " + list.getSelectedIndex());
		return list.getSelectedIndex();
	}
	
	public Pet getSelectedPet() {
		return (Pet) list.getSelectedValue();
	}
	
	
}
