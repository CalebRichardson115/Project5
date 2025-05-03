import java.io.IOException;

import javax.swing.SwingUtilities;
import java.io.IOException;

import pets.*;
import parsing.*;
import controller.*;
import view.*;


public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//Shelter<Pet> shelter = new Shelter<Pet>();
		try {
			Shelter<Pet> shelter =  JsonShelterParsing.loadJson("src/main/resources/pets.json", "src/main/resources/exotic_animals.json");
			//shelter.printValues();
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					ShelterController controller = new ShelterController(shelter);
					controller.initiate();
				}
			});
			
		}catch(IOException e) {
			System.out.println("Error in loading files.");
		}
		
		/*
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ShelterController controller = new ShelterController(shelter);
				controller.initiate();
			}
		});*/
		
		
		
	}

}
