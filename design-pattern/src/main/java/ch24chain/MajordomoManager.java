package ch24chain;


public class MajordomoManager extends Manager {

	public MajordomoManager(String name) {
		super(name);
	}

	@Override
	public void request(Request request) {
		if(request.trye.equals("涨工资")) {
			System.out.println(name + "批准涨工资");
		}
	}


}
