import java.io.IOException;

import javax.swing.SwingUtilities;
import java.io.IOException;

import pets.*;
import parsing.*;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			Shelter<Pet> shelter = new Shelter<Pet>();
			shelter = JsonShelterParsing.loadJson("src/main/resources/pets.json", "src/main/resources/exotic_animals.json");
			shelter.printValues();
		}catch(IOException e) {
			System.out.println("Error in loading files.");
		}
		/*
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
			}
		});
		*/
		
		
	}

}
