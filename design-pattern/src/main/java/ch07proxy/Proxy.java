package ch07proxy;

public class Proxy implements GiveGift {
	private Pursuit pursuit;
	
	
	public Proxy(SchoolGirl schoolGirl) {
		this.pursuit = new Pursuit(schoolGirl);
	}

	public void giveFlowers() {
		pursuit.giveFlowers();
	}

}
