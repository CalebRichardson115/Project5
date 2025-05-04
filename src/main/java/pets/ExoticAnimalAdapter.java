package pets;

public class ExoticAnimalAdapter extends Pet {
	private ExoticAnimal animal = null;
	int id;
	boolean adopted;
	public ExoticAnimalAdapter (String id, String name,String type, String species, int age, boolean adopted){
		this.animal = new ExoticAnimal(id, name, type, species, age);
		this.name = animal.name;
		this.age = animal.age;
		this.type = animal.type;
		this.species = animal.species;
		//To be different from regular pets, exotic animals will have negative IDs.
		//this.id = Integer.parseInt(animal.id);
		this.id = 2;
		this.adopted  = adopted;
		
	}
	@Override
	public String toString() {
		return "Name: "+ this.name + " Type: " + this.type;
	}
	
	@Override
	public String getDetails() {
		if(adopted == true) return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Adopted";
		else return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Not Adopted";
	}
	
	@Override
	public void setAdopted(Boolean adopted) {
		this.adopted = adopted;
	}
	
	@Override
	public void setID(int id) {
		this.id = id;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public Boolean getAdopted() {
		return this.adopted;
	}
}
