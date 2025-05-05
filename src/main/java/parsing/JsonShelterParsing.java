package parsing;

import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.lang.reflect.Type;

import pets.*;
/*
 * Reads both the normal pet adoption json file and the exotic animal json file
 * and stores them into pet objects to be added into the shelter.
 */
public class JsonShelterParsing {
	private static Gson gson = new Gson();
	
	public static  Shelter<Pet> loadJson(String filePathPet, String filePathExotic) throws IOException {
		Shelter<Pet> shelter = new Shelter();
		//Puts the contents of the json file into a string.
		Path petPath = Path.of(filePathPet);
		String allPets = Files.readString(petPath);
		//Creates a list of normal pets to be added into the shelter.
		Type petTypeList = new TypeToken<List<NormalPet>>() {}.getType();
		List<NormalPet> petData = gson.fromJson(allPets, petTypeList);
		//Adds all of the regular pets to the shelter first.
		for(NormalPet petInfo : petData) {
			shelter.getList().add((Pet) petInfo);
		}
		//Adding exotic pets.
		Path exoticPetPath = Path.of(filePathExotic);
		String allExotic = Files.readString(exoticPetPath);

		Type exoticTypeList = new TypeToken<List<ExoticDTO>>() {}.getType();
		List<ExoticDTO> exoticPetData = gson.fromJson(allExotic, exoticTypeList);
		//Takes petInfo from the exotic json file and makes new exotic animal adapters for each to be inserted into the shelter.
		for(ExoticDTO petInfo : exoticPetData) {
			ExoticAnimalAdapter newExotic = new ExoticAnimalAdapter(petInfo.uniqueId, petInfo.animalName, petInfo.category, petInfo.subSpecies, petInfo.yearsOld, false);
			shelter.getList().add((Pet) newExotic);
		}
		return shelter;
	}
}