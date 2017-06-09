package ch01simpleFactory;

/**
 * @author lcl
 */
public class OperationFactory {
	 public static Operation createOperation(char operate) {
		 switch (operate) {
			case '+':
				return new OperationAdd();
			case '-':
				return new OperationSub();
			default:
				break;
			}
		return null; 
		 
	 }
}
