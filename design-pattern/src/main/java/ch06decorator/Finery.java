package ch06decorator;

/**
 * @author lcl
 * 
 */
public abstract class Finery extends Person{
	private Person person;
	
	
	public Finery() {
	}

	public void decorator(Person person) {
		this.person = person;
	}

	public void show() {
		if(person != null) {
			person.show();
		}
	}
}
