import java.io.IOException;

import javax.swing.SwingUtilities;

import pets.*;
import parsing.*;
import controller.*;

public class Main {

	public static void main(String[] args){
		
		try {
			//Loads the shelter with pets from both json files.
			Shelter<Pet> shelter =  JsonShelterParsing.loadJson("src/main/resources/pets.json", "src/main/resources/exotic_animals.json");
			//Runs the GUI.
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
	}

}
