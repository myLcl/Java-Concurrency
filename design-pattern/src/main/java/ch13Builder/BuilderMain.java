package ch13Builder;


public class BuilderMain {
	public static void main(String[] args) {
		
		Director d = new Director();
		
		Builder builderA = new ConcreteBuilderA();
		d.construct(builderA);
		Product p1 = builderA.getResult();
		p1.show();
		
		Builder builderB = new ConcreteBuilderB();
		d.construct(builderB);
		Product p2 = builderB.getResult();
		p2.show();
		
	}
}
