package ch16state;

public class MorningState extends State{

	@Override
	public void writeProgram(Work work) {
		if(work.hour < 12) {
			System.out.println("休闲状态");
		}else{
			work.state = new AfternoonState();
			work.request();
		}
		
	}
	
}
