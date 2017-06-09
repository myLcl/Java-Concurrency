package ch12facade;

public class Facade {
	private SubSystemOne one;
	private SubSystemTwo two;
	
	public Facade() {
		this.one = new SubSystemOne();
		this.two = new SubSystemTwo();
	}
	
	public void methodA() {  
		System.out.println("方法组1");
		one.methodOne();
	}
	
	
	public void methodB() {
		System.out.println("方法组2");
		one.methodOne();
		two.methodTwo();
	}
}
