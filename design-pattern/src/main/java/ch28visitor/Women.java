package ch28visitor;

public  class Women extends Person {

	@Override
	public void accept(Action action) {
		action.getWomenConclusion(this);
	}

}
