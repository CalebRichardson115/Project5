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
		if(adopted == true) return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Adopted";
		/*else */return "Id: " + id + " Name: " + name + " Type: " + type + " Species: " + species + " Age: " + age + " Adoption Status: Not Adopted";
	}
	
	public void setAdopted(Boolean adopted) {
		this.adopted = adopted;
	}
	
	public int getId() {
		return this.id;
	}
}
