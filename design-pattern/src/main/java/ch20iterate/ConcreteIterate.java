package ch20iterate;

public class ConcreteIterate extends Iterate{
	private ConcreteAgregate agregate;
	private int current = 0;

	public ConcreteIterate(ConcreteAgregate agregate) {
		this.agregate = agregate;
	}

	@Override
	public Object first() {
		return agregate.item(0);
	}

	@Override
	public Object next() {
		current++;
		
		Object ret = null;
		if(current < agregate.count()) {
			ret = agregate.item(current);
		}
		return ret;
	}

	@Override
	public Boolean isDone() {
		return current >= agregate.count() ? true : false ;
	}

	@Override
	public Object concreteItem() {
		return agregate.item(current);
	}

	
	
	public ConcreteAgregate getAgregate() {
		return agregate;
	}

	public void setAgregate(ConcreteAgregate agregate) {
		this.agregate = agregate;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	
	
}
