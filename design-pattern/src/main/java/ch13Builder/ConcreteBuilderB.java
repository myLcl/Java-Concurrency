package ch13Builder;

public class ConcreteBuilderB extends Builder{
	private Product p = new Product();
	
	@Override
	public void builderPartA() {
		p.add("楼房B--partA--打桩");
	}

	@Override
	public void builderPartB() {
		p.add("楼房B--partB--搭架子");
	}

	@Override
	public Product getResult() {
		return p;
	}

}
