package ch15simpleFactoryReflect;

public class SqlserverDepartment implements IDepartment {

	public Department GetDepartment(int id) {
		// TODO Auto-generated method stub
		System.out.println("Get a record from table Department in Sqlserver ");
		return null;
	}

	public void Insert(Department department) {
		// TODO Auto-generated method stub
		System.out.println("Insert a record for table Department in Sqlserver ");

	}

}
