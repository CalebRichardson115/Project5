package pets;
//Makes a Pet that can be made into an object.
public class NormalPet extends Pet {
	public NormalPet (int id, String name, String type, String species, int age, Boolean adopted) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = false;
	}
}
