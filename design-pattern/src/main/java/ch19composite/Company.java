package ch19composite;

public abstract class Company {
	public String name;
	
	public Company(String name) {
		super();
		this.name = name;
	}
	
	public abstract void add(Company company);
	public abstract void display(int depth);
	public abstract void lineOfDuty();
}
