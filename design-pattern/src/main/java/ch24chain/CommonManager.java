package ch24chain;

public class CommonManager extends Manager{

	public CommonManager(String name) {
		super(name);
	}

	@Override
	public void request(Request request) {
		if(request.trye.equals("请假")) {
			System.out.println(name + "批准请假");
		}else if(superior != null){
			superior.request(request);
		}
	}

	
}
