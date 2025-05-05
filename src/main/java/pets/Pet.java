package pets;
//Pet has to be an abstract class according to specifications.
//Implements Comparable so that the list view can sort by names.
public abstract class Pet implements Comparable<Pet>{
	//Protected so that only subclasses have access to fields.
	protected int id;
	protected String name;
	protected String type;
	protected String species;
	protected int age;
	protected Boolean adopted;
	//Standard toString method is simplified so not all details are given in the list view.
	public String toString() {
		return "Name: "+ this.name + " Type: " + this.type;
	}
	//Returns all information regarding a pet.
	public String getDetails() {
		if(adopted == true) return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Adopted";
		else return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Not Adopted";
	}
	//Getter and setters for Pets.
	public int getId() {
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
	
	public Boolean getAdopted() {
		return this.adopted;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setAdopted(Boolean adopted) {
		this.adopted = adopted;
	}
	//Makes it so that the list view automatically gets sorted by age when the sortAge button is pressed.
	@Override
	public int compareTo(Pet pet) {
		return this.getName().compareTo(pet.getName());
	}
}
