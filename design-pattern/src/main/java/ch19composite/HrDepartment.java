package ch19composite;

public class HrDepartment extends Company{

	public HrDepartment(String name) {
		super(name);
	}

	@Override
	public void add(Company company) {
	}

	
	@Override
	public void display(int depth) {
		System.out.println("-"+name);
	}

	@Override
	public void lineOfDuty() {
		System.out.println(this.name + ": "+"招聘员工");
	}
	
}
