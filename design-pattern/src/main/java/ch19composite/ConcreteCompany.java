package ch19composite;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company{

	private List<Company> children = new ArrayList<Company>();
	
	public ConcreteCompany(String name) {
		super(name);
	}

	@Override
	public void add(Company company) {
		children.add(company);
	}

	@Override
	public void display(int depth) {
		System.out.println("-" + name);
		
		for (Company compoment : children) {
			for(int i=0;i<depth;i++){
			    System.out.print("--");
			 }
			compoment.display(depth + 2);
		}
	}

	@Override
	public void lineOfDuty() {
		for (Company compoment : children) {
			compoment.lineOfDuty();
		}
	}

}
