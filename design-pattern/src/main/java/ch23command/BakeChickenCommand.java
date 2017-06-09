package ch23command;


public class BakeChickenCommand extends Command {

	public BakeChickenCommand(Barbecuer barbecuer) {
		super(barbecuer);
	}

	@Override
	public void executeCommand() {
		barbecuer.bakeChicken();
	}		

}
