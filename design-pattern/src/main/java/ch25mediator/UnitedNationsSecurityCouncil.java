package ch25mediator;

public class UnitedNationsSecurityCouncil extends UnitedNations {
	private USA colleague1;
	private Irag colleague2;
	
	@Override
	public void declare(String message, Country colleague) {
		if(colleague == colleague1) {
			colleague2.getMessage(message);
		}else{
			colleague1.getMessage(message);
		}
	}


	public void setColleague1(USA colleague1) {
		this.colleague1 = colleague1;
	}

	public void setColleague2(Irag colleague2) {
		this.colleague2 = colleague2;
	}
	
	
	
}
