package ch16state;

public class StateMain {
	public static void main(String[] args) {
		Work work = new Work(new MorningState());
		//work.hour = 10;
		work.hour = 13;
		work.request();
	}
}
