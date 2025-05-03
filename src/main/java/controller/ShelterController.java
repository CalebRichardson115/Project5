package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import view.*;
import pets.*;


public class ShelterController {
	
	private AdoptionListView userListView;
	private UserInputView inputView;
	private Shelter<Pet> shelter;
	
	public ShelterController(Shelter<Pet> shelter) {
		userListView = new AdoptionListView();
		inputView = new UserInputView();
		this.shelter = shelter;
		userListView.setModelList(this.shelter.getList());
	}
	
	public void initiate() {
		userListView.setVisible(true);
	}
}
