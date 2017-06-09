package ch16state;

public class AfternoonState extends State{

	@Override
	public void writeProgram(Work Work) {
		System.out.println("忙碌状态");
	}

}
