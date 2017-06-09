package ch12facade;


public class FacadeMain {
	public static void main(String[] args) {
		Facade facade = new Facade();
		
		facade.methodA();
		facade.methodB();
	}
}
