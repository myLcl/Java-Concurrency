package ch23command;


public abstract class Command {
	public Barbecuer barbecuer;
	
	public Command(Barbecuer barbecuer) {
		this.barbecuer = barbecuer;
	}

	public abstract void executeCommand();
}
