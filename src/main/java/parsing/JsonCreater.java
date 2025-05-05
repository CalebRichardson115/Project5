package parsing;

import com.google.gson.Gson;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;

import pets.*;

public class JsonCreater {
	//Creates a json file to be added into the project resources.
	public static void createJson(DefaultListModel<Pet> petList) {
		//Creates a new gson builder that is formatted for json files.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//Formats the timeStamp to the current time as of the button push.
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		//Establishes file type and directory.
		timeStamp = "src/main/resources/"+timeStamp+"_pets.json";
		//Convert for file writing.
		List<Pet> pets = ConvertDefaultListToPetList.ConvertDefaultListModelToPetList(petList);
		//Creates the json file.
		try{
			FileWriter fileWriter = new FileWriter(timeStamp);
			gson.toJson(pets, fileWriter);
		} catch(IOException e) {
			System.out.println("Save failed");
			return;
		}
		
	}
}
