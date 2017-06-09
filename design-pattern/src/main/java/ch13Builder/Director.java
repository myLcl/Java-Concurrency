package ch13Builder;

public class Director {
	public void construct(Builder b) {
		b.builderPartA();
		b.builderPartB();
	}
	
}
