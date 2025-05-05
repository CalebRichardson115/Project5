package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import view.*;
import pets.*;
import parsing.JsonCreater;


public class ShelterController {
	
	private AdoptionListView petListView;
	private UserInputView inputView;
	private Shelter<Pet> shelter;
	
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
	}
	
	public void initiate() {
		petListView.setVisible(true);
	}
	
	private class RemovePetButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Pet pet = petListView.getSelectedPet();
			
			petListView.getPetList().removeElement(pet);
		}
		
	}
	//Sets 
	private class AdoptPetButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int adoptIndex = petListView.getSelectedPetIndex();
			if(adoptIndex == -1) {
				return;
			}
			if(petListView.getPetList().get(adoptIndex).getAdopted() == true) {
				System.out.println("Pet is already adopted.");
			}
			else {
				petListView.getPetList().get(adoptIndex).setAdopted(true);
			}
		}
	}
	//Prints the details of a selected pet.
	private class ViewDetailsButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Pet printPet = petListView.getSelectedPet();
			if(printPet == null) {
				return;
			}
			System.out.println(printPet.getDetails());
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
}
