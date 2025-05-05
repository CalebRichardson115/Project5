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
	
	private JButton ageSortButton;
	
	private DefaultListModel<Pet> modelList;
	
	
	public AdoptionListView() {
		//Sets up the GUI view.
		setTitle("Animal Shelter Adoption Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		//Initalizes the list.
		modelList = new DefaultListModel<Pet>(); 
		list = new JList<Pet>(modelList);
	
		list.setBounds(68, 85, 390, 174);
		panel.add(list);
		//Initializes the buttons for list view.
		adoptPetButton = new JButton("Adopt Selected Animal");
		adoptPetButton.setBounds(66, 270, 177, 23);
		panel.add(adoptPetButton);
		
		viewDetailsButton = new JButton("View Animal Details");
		viewDetailsButton.setBounds(250, 270, 177, 23);
		panel.add(viewDetailsButton);
		
		addPetButton = new JButton("Add a Pet");
		addPetButton.setBounds(66, 300, 177, 23);
		panel.add(addPetButton);
		
		removePetButton = new JButton("Remove a Pet");
		removePetButton.setBounds(250, 300, 177, 23);
		panel.add(removePetButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(158, 330, 177, 23);
		panel.add(saveButton);
		
		ageSortButton = new JButton("Sort by Name");
		ageSortButton.setBounds(68,30,177,23);
		panel.add(ageSortButton);
	}
	//Sets the list using a shelter.
	public void setModelList(List<Pet> shelter) {
		modelList.clear();
		for(Pet pet : shelter) {
			modelList.addElement(pet);
		}
	}
	//Methods that add action listener to buttons in list view.
	public void addActionListenerToRemovePetButton(ActionListener listener) {
		removePetButton.addActionListener(listener);
	}
	
	public void addActionListenerToAdoptPetButton(ActionListener listener) {
		adoptPetButton.addActionListener(listener);
	}
	
	public void addActionListenerToViewDetailsButton(ActionListener listener) {
		viewDetailsButton.addActionListener(listener);
	}
	
	public void addActionListenerToAddPetButton(ActionListener listener) {
		addPetButton.addActionListener(listener);
	}
	
	public void addActionListenerToSaveButton(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
	
	public void addActionListenerToNameSortButton(ActionListener listener) {
		ageSortButton.addActionListener(listener);
	}
	//Retrieves the JList.
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	//Returns the selected index of the JList.
	public int getSelectedPetIndex() {
		return list.getSelectedIndex();
	}
	//Returns a selected Pet from the JList.
	public Pet getSelectedPet() {
		return (Pet) list.getSelectedValue();
	}
	
	
}
