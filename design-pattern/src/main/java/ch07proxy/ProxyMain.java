package ch07proxy;

public class ProxyMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
	  SchoolGirl schoolGirl = new SchoolGirl("小丽");
	  
	  Proxy proxy = new Proxy(schoolGirl);
	  
	  proxy.giveFlowers();
	  
  }

}
