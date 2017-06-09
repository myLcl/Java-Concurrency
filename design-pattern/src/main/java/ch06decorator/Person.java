package ch06decorator;

/**
 * @author lcl
 */
public  class Person {

	private String name;
	
	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("decorator: " + this.name );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
