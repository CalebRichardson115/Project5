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
	/*
	public Pet(int id, String name, String type, String species, int age, Boolean adopted) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = false;
	}
	*/
	
}
