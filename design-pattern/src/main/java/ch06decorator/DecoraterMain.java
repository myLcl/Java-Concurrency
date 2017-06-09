package ch06decorator;

/**
 * @author lcl
 * 
 */
public class DecoraterMain {
	public static void main(String[] args) {
		Person person = new Person("lcl"); 
		
		Hat hat = new Hat();
		Sneaker sneaker = new Sneaker();
		
		hat.decorator(person);
		sneaker.decorator(hat);
		sneaker.show();
	}
	
}
