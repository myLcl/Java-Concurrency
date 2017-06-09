package ch15abstractFactory;

public class SqlserverDepartment implements IDepartment{

	public void insert(Department department) {
		System.out.println("Sqlserver-insert-Department");
	}

}
