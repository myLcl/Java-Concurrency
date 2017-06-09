package ch01simpleFactory;

public class SimpleFactoryMain {

  /**
   * @author lcl
   */
  public static void main(String[] args) {
	  System.out.println(OperationFactory.createOperation('+').getResult());
	  System.out.println(OperationFactory.createOperation('-').getResult());
  }
}
