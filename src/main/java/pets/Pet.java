package pets;
//Pet has to be an abstract class according to specifications.
public abstract class Pet {
	//Protected so that only subclasses have access to fields.
	protected int id;
	protected String name;
	protected String type;
	protected String species;
	protected int age;
	protected Boolean adopted;
	
	public String toString() {
		return "Name: "+ this.name + " Type: " + this.type;
	}
	
	public String getDetails() {
		if(adopted == true) return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Adopted";
		else return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Not Adopted";
	}
	
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
}
