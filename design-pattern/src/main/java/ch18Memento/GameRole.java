package ch18Memento;

public class GameRole {
	int vit;
	
	public GameRole(int vit) {
		this.vit = vit;
	}

	public RoleStateMementor saveState(){
		return new RoleStateMementor(this.vit);
	}
	
	public void displayState(){
		System.out.println(vit);
	}
	
	public void recoveryState(RoleStateMementor mementor){
		this.vit = mementor.getVit();
	}
	
	public void fight(){
		this.vit = 0;
	}
	
	
}
