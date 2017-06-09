package ch26flyweight;


public class ConcreteWebSite extends WebSite {
	private String name;
	
	public ConcreteWebSite(String name) {
		this.name = name;
	}

	@Override
	public void operation(User user) {
		System.out.println("网站分类:"+ name +"--登陆用户:"+user.getName());
	}

}
