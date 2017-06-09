package ch25mediator;

public abstract class Country {
	public UnitedNations mediator;

	public Country(UnitedNations mediator) {
		super();
		this.mediator = mediator;
	}
	
	

}
