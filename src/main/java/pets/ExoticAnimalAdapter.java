package pets;

public class ExoticAnimalAdapter extends Pet {
	private ExoticAnimal animal = null;
	int id;
	boolean adopted;
	public ExoticAnimalAdapter (String id, String name, String species, String type, int age, boolean adopted){
		this.animal = new ExoticAnimal(id, name, type, species, age);
		this.name = animal.name;
		this.age = animal.age;
		this.species = animal.species;
		this.type = animal.type;
		//To be different from regular pets, exotic animals will have negative IDs.
		this.id = Integer.parseInt(animal.id);
		this.id *= -1;
		
		this.adopted  = adopted;
		
	}
}
