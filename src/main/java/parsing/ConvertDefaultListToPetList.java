package parsing;

import pets.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
//Returns a list of pets from a default list model.
public class ConvertDefaultListToPetList {
	public static List<Pet> ConvertDefaultListModelToPetList(DefaultListModel<Pet> modelList) {
		List<Pet> petList = new ArrayList<>();
		for(int i = 0; i < modelList.size(); i ++) {
			petList.add(modelList.getElementAt(i));
		}
		return petList;
	}
}
