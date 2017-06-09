package ch26flyweight;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {
	private Map<String, WebSite> flyweight = new HashMap<String,WebSite>();

	public WebSiteFactory() {
		flyweight.put("博客", new ConcreteWebSite("博客"));
		flyweight.put("论坛", new ConcreteWebSite("论坛"));
	}
	
	public WebSite getWebSite(String key) {
		if(!flyweight.containsKey(key)) {
			flyweight.put(key, new ConcreteWebSite(key));
		}
		return (WebSite) flyweight.get(key);
	}
	
	public void getCount() {
		System.out.println("网站分类数量:" + flyweight.size());
	}
	
}
