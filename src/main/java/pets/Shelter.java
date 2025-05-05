package pets;

import java.util.ArrayList;
import java.util.List;
//Stores a generic list.
public class Shelter<T extends Pet> {
	private List<T> list;
	
	public Shelter() {
		list = new ArrayList<>();
	}
	//Prints the values of the shelter. Named each element "animal" for readability. 
	public void printValues() {
		for(T animal : list) {
			System.out.println(animal.toString());
		}
	}
	//Returns the list of animals
	public List<T> getList(){
		return list;
	}
	
	
}
