package ch28visitor;

public class VisitorMain {
	public static void main(String[] args) {
		ObjectStructure str = new ObjectStructure();
		str.add(new Man());
		str.add(new Women());
		
		Action action = new AmativenessAction();
		
		str.disPlay(action);
	}
}
