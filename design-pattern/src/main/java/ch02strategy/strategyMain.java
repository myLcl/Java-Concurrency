package ch02strategy;

/**
 * @author lcl
 */
public class strategyMain {

	public static void main(String[] args) {
		
		CashContext strategy = new CashContext('8');
		System.out.println(strategy.getCashSuper().acceptCash(0));
	}
}
