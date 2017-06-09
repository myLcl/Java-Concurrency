package ch26flyweight;

public class FlyweightMain {
	public static void main(String[] args) {
		User user = new User("lcl");
		WebSiteFactory factory = new WebSiteFactory();
		
		WebSite webSite1 = factory.getWebSite("博客");
		webSite1.operation(user);
		
		WebSite webSite2 = factory.getWebSite("论坛");
		webSite2.operation(user);
		
		factory.getCount();
		
	}
}
