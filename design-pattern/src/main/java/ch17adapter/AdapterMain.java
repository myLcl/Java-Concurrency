package ch17adapter;

public class AdapterMain {
	public static void main(String[] args) {
		Player play = new Translator("姚明");
		
		play.attach();
		play.defense();
	}
}
