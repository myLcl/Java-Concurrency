package ch23command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
	
	public List<Command> commandList = new ArrayList<Command>();
	public final int count = 1;
	
	//添加订单
	public void  add(Command command) {
		if(commandList.size() > (count-1)) {
			System.out.println("请换别的烧烤");
		}else{
			commandList.add(command);
		}
	}
	
	//取消订单
	public void  cancel(Command command) {
		commandList.remove(command);
	}
	
	public void notifyBarbecuer() {
		for (Command command : commandList) {
			command.executeCommand();
		}
	}
	
}
