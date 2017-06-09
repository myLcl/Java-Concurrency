package ch17adapter;

public class Translator extends Player{
	private String name;
	private  ForeignCenter center = new ForeignCenter();
	
	public Translator(String name) {
		center.name = name;
	}

	@Override
	public void attach() {
		center.jingon();
	}

	@Override
	public void defense() {
		center.fangshou();
	}
}
