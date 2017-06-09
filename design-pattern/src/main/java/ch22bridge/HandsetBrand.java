package ch22bridge;

public abstract class HandsetBrand {
	protected HandsetSoft soft;
	
	public abstract void run(); 

	public void setSoft(HandsetSoft soft) {
		this.soft = soft;
	}
	
	
}
