package pets;
//Exotic Animal has fields from the exotic animal json that need to be adapted to be in a list of pets.
public class ExoticAnimal {
	String id;
	String name;
	String type;
	String species;
	int age;
	
	public ExoticAnimal(String id, String name, String type, String species, int age) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public int getAge() {
		return this.age;
	}
}
