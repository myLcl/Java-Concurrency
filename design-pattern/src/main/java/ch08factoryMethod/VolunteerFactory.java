package ch08factoryMethod;

public class VolunteerFactory implements Factory {

	public LeiFeng createLeiFeng() {
		return new Volunteer();
	}
	
 

}
