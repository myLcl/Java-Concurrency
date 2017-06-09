package ch25mediator;

public class Irag extends Country {

	public Irag(UnitedNations mediator) {
		super(mediator);
	}
	
	public void declare(String  message) {
		mediator.declare(message, this);
	}
	
	public void getMessage(String message) {
		System.out.println("伊拉克获得消息:" + message);
	}
	
}
