package ch20iterate;

public class IterateMain {
	public static void main(String[] args) {
		ConcreteAgregate agregate = new ConcreteAgregate();
		agregate.insert("1");
		agregate.insert("2");
		agregate.insert("3");
		
		Iterate iterate = agregate.createIterate(agregate);
		System.out.println(iterate.first());
		
		while(!iterate.isDone()) {
			System.out.println(iterate.concreteItem());
			iterate.next();
		}
		
		
		ConcreteAgregate agregate1 = new ConcreteAgregate();
		agregate1.insert("1");
		agregate1.insert("2");
		agregate1.insert("3");
		
		Iterate iterate1 = new ConcreteIteratorDesc(agregate1);
		System.out.println("desc" + "===========================");
		
		while(!iterate1.isDone()) {
			System.out.println(iterate1.concreteItem());
			iterate1.next();
		}
		
	}
}
