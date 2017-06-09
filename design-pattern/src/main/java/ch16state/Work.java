package ch16state;

public class Work {
	public State state;
	public int hour;

	public Work(State state) {
		super();
		this.state = state;
	}
	
	public void request() {
		state.writeProgram(this);	
	}
	
	
}
