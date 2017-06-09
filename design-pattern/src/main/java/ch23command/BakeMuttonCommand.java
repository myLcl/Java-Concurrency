package ch23command;


public class BakeMuttonCommand extends Command {

	public BakeMuttonCommand(Barbecuer barbecuer) {
		super(barbecuer);
	}

	@Override
	public void executeCommand() {
		barbecuer.bakeMutton();
	}

}
