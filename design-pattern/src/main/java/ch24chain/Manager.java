package ch24chain;

public abstract class Manager {
	
	protected String name;
	protected Manager superior;

	public void setSuperior(Manager superior) {
		this.superior = superior;
	}

	public Manager(String name) {
		super();
		this.name = name;
	}
	
	public abstract void request(Request request);
}
