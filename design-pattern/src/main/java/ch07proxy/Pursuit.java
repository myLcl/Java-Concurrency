package ch07proxy;

public class Pursuit implements GiveGift {
	private SchoolGirl schoolGirl;
	
	
	public Pursuit(SchoolGirl schoolGirl) {
		this.schoolGirl = schoolGirl;
	}

	public void giveFlowers() {
		System.out.println(schoolGirl.getName() + "送你玫瑰花");
	}

}
