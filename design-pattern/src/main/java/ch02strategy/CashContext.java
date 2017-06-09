package ch02strategy;

/**
 * @author lcl
 */
public class CashContext {
	private CashSuper  cashSuper;

	public  CashContext(char cashType) {
		switch (cashType) {
		case 'n':
			  cashSuper = new CashNormal();
			  break;
		case 'r':
			  cashSuper = new CashReturn();	
			  break;
		case '8':
			 cashSuper = new CashRebate();	
			 break ;		
		default:
			break;
		}
	}

	public CashSuper getCashSuper() {
		return cashSuper;
	}

	public void setCashSuper(CashSuper cashSuper) {
		this.cashSuper = cashSuper;
	}
	
	
	

}
