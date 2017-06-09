package ch28visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
	private List<Person> list = new ArrayList<Person>();
	
	public  void add(Person person)  {
		list.add(person);
	}
	
	public void remove(Person person) {
		list.remove(person);
	}
	
	public void disPlay(Action action) {
		for (Person person : list) {
			person.accept(action);
		}
	}
}
