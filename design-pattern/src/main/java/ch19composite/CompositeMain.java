package ch19composite;

public class CompositeMain {
	public static void main(String[] args) {
		ConcreteCompany root = new ConcreteCompany("北京总公司");
		root.add(new HrDepartment("北京总公司人力资源部"));
		
		ConcreteCompany comp = new ConcreteCompany("上海分公司");
		comp.add(new HrDepartment("上海分公司人力资源部"));
		
		root.add(comp);
		
		System.out.println("结构");
		root.display(1);
		System.out.println("职责");
		root.lineOfDuty();
	}
}
