package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import view.*;
import pets.*;
import parsing.ConvertDefaultListToPetList;
import parsing.JsonCreater;


public class ShelterController {
	
	private AdoptionListView petListView;
	private UserInputView inputView;
	private Shelter<Pet> shelter;
	//Controller is passed a shelter to add to its list view and initiates all buttons.
	public ShelterController(Shelter<Pet> shelter) {
		petListView = new AdoptionListView();
		inputView = new UserInputView();
		this.shelter = shelter;
		petListView.setModelList(this.shelter.getList());
		petListView.addActionListenerToRemovePetButton(new RemovePetButtonActionListener());
		petListView.addActionListenerToAdoptPetButton(new AdoptPetButtonActionListener());
		petListView.addActionListenerToViewDetailsButton(new ViewDetailsButtonActionListener());
		petListView.addActionListenerToAddPetButton(new AddPetButtonActionListener());
		petListView.addActionListenerToSaveButton(new SaveButtonActionListener());
		inputView.addActionListenerToCancelButton(new CancelButtonActionListener());
		inputView.addActionListenerToSubmitButton(new SubmitButtonActionListener());
		
		petListView.addActionListenerToNameSortButton(new NameSortButtonActionListener());
		//petListView.addActionListenerToAgeSortButton(new AgeSortButtonActionListener());
	}
	//List view is the default view.
	public void initiate() {
		petListView.setVisible(true);
	}
	//Removes a selected pet. Does nothing if no selection is made.
	private class RemovePetButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Pet pet = petListView.getSelectedPet();
			
			petListView.getPetList().removeElement(pet);
		}
		
	}
	//Sets the selected pet to be adopted. Gives an error if there is no selection or if the pet is already adopted. 
	private class AdoptPetButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int adoptIndex = petListView.getSelectedPetIndex();
			if(adoptIndex == -1) {
				JOptionPane.showMessageDialog(inputView, "Select a Pet to Adopt", "Invalid input", 1, null);
				return;
			}
			if(petListView.getPetList().get(adoptIndex).getAdopted() == true) {
				JOptionPane.showMessageDialog(inputView, "Pet is already adopted", "Invalid input", 1, null);
			}
			else {
				petListView.getPetList().get(adoptIndex).setAdopted(true);
				JOptionPane.showMessageDialog(inputView, "Pet Adopted", "", 1, null);
			}
		}
	}
	//Prints the details of a selected pet unless no pet is selected.
	private class ViewDetailsButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Pet printPet = petListView.getSelectedPet();
			if(printPet == null) {
				JOptionPane.showMessageDialog(inputView, "Select a Pet to View Details", "Invalid input", 1, null);
				return;
			}
			JOptionPane.showMessageDialog(inputView, printPet.getDetails(), "Pet Details", 1, null);
		}
	}
	//Initiates the input view.
	private class AddPetButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			petListView.setVisible(false);
			inputView.setVisible(true);
		}
	}
	//Cancels inputting a new Pet by toggling the inputView to false and petListView to true.
	private class CancelButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			inputView.setVisible(false);
			petListView.setVisible(true);
		}
	}
	//Calls on the JsonCreater to make a new json file of the current list.
	private class SaveButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JsonCreater.createJson(petListView.getPetList());
		}
	}
	
	private class SubmitButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Checks to see if age and integer are valid numbers.
			if(!inputView.getId().matches("\\d+") || !inputView.getAge().matches("\\d+")) {
				JOptionPane.showMessageDialog(inputView, "ID and Age must be valid numbers.", "Invalid input", 1, null);
				return;
			}
			//Checks to see if the other fields are blank.
			if(inputView.getName().isBlank() || inputView.getPetType().isBlank() || inputView.getSpecies().isBlank()) {
				JOptionPane.showMessageDialog(inputView, "Fill in all fields.", "Invalid input", 1, null);
				return;
			}
			int id = Integer.parseInt(inputView.getId());
			int age = Integer.parseInt(inputView.getAge());
			//Checks to see if id is present in the list.
			for(int i = 0; i < petListView.getPetList().size(); i++) {
				if(petListView.getPetList().get(i).getId() == id) {
					JOptionPane.showMessageDialog(inputView, "ID already exists.", "Invalid input", 1, null);
					return;
				}
			}
			//Assuming that any new pet is not adopted.
			Pet newPet = new NormalPet(id, inputView.getName(), inputView.getPetType(), inputView.getSpecies(), age, false);
			petListView.getPetList().addElement(newPet);
			JOptionPane.showMessageDialog(inputView, "Pet has been added", "", 1, null);
			inputView.setVisible(false);
			petListView.setVisible(true);
		}
	}
	//Copies the list to a list of pets that is sorted by name and then copies that pet list.
	private class NameSortButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			List<Pet> petList = new ArrayList<>();
			petList = ConvertDefaultListToPetList.ConvertDefaultListModelToPetList(petListView.getPetList());
			Collections.sort(petList);
			petListView.setModelList(petList);
		}
	}
}
