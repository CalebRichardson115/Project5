package pets;

public class ExoticAnimalAdapter extends Pet {
	private ExoticAnimal animal = null;
	//Adapts an exotic animal into a Pet.
	public ExoticAnimalAdapter (String id, String name,String type, String species, int age, boolean adopted){
		this.animal = new ExoticAnimal(id, name, type, species, age);
		this.name = animal.name;
		this.age = animal.age;
		this.type = animal.type;
		this.species = animal.species;
		//To be different from regular pets, exotic animals will have their Ids start at 10000 so that overlap is infeasible.
		//Removes all non-digit characters.
		this.id = Integer.parseInt(id.replaceAll("[\\D]", ""));
		this.id = this.id + 10000;
		this.adopted  = adopted;
	}
}
