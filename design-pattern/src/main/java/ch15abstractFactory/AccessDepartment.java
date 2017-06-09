package ch15abstractFactory;

public class AccessDepartment implements IDepartment{

	public void insert(Department department) {
		System.out.println("Access-insert-Department");
	}

}
