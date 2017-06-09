package ch13Builder;


public class ConcreteBuilderA extends Builder{
	private Product p = new Product();
	
	@Override
	public void builderPartA() {
		p.add("楼房A--partA--打桩");
	}

	@Override
	public void builderPartB() {
		p.add("楼房A--partB--搭架子");
	}

	@Override
	public Product getResult() {
		return p;
	}

}
