package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import view.*;
import pets.*;


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
	
	private class AdoptPetButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int adoptIndex = petListView.getSelectedPetIndex();
			if(petListView.getPetList().get(adoptIndex).getAdopted() == true) {
				System.out.println("Pet is already adopted.");
			}
			else {
				petListView.getPetList().get(adoptIndex).setAdopted(true);
			}
		}
		
	}
}
