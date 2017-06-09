package ch23command;

public class CommandMain {

	public static void main(String[] args) {
		//开店前准备
		Barbecuer barbecuer = new Barbecuer();
		
		Command mutton = new BakeMuttonCommand(barbecuer);
		Command chicken = new BakeChickenCommand(barbecuer);
		
		Waiter waiter = new Waiter();
		
		//客人点菜
		waiter.add(mutton);
		waiter.add(chicken);
		
		//通知厨房
		waiter.notifyBarbecuer();
		
		waiter.cancel(mutton);
		waiter.add(chicken);
		waiter.notifyBarbecuer();
		
		
	}
}
