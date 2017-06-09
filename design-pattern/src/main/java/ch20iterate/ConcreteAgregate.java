package ch20iterate;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAgregate extends Agregate{
	private List<Object> items = new ArrayList<Object>();
	
	@Override
	public Iterate createIterate(ConcreteAgregate agregate) {
		return new ConcreteIterate(agregate);
	}

	public int count() {
		return items.size();
	}
	
	public Object item(int index){
		return items.get(index);
	}
	
	public void insert(Object object) {
		items.add(object);
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}
	
	
}


