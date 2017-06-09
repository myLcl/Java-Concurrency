package ch22bridge;

public class BridgeMain {
	public static void main(String[] args) {
		HandsetBrand hb;
		
		hb = new HandsetBrandM();
		hb.setSoft(new HandsetGame());
		hb.run();
	}
}
