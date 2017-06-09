package ch24chain;

public class ChainMain {
	public static void main(String[] args) {
		
		Manager manager = new CommonManager("经理");
		manager.setSuperior(new MajordomoManager("总监"));	
		
		Request request = new Request("请假");
		manager.request(request);
		
		Request request1 = new Request("涨工资");
		manager.request(request1);
		
	}
}
