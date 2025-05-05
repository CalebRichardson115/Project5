package parsing;

import com.google.gson.Gson;
import java.util.List;

import javax.swing.DefaultListModel;

import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;

import pets.*;

public class JsonCreater {
	//Gson gson = new GsonBuilder().setPrettyPrinting().create();
	public static void createJson(DefaultListModel<Pet> petList) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(petList.get(0).toString());
		LocalDateTime present = LocalDateTime.now();
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		timeStamp = "src/main/resources/"+timeStamp+"_pets.json";
		//NEED to change the "."s to "_" may be same for "-"
		System.out.println(timeStamp);
		List<Pet> pets = ConvertDefaultListToPetList.ConvertDefaultListModelToPetList(petList);
		System.out.println(pets.getFirst().toString());
		try{
			FileWriter fileWriter = new FileWriter(timeStamp);
			gson.toJson(pets, fileWriter);
		} catch(IOException e) {
			System.out.println("Save failed");
			return;
		}
		
	}
}
