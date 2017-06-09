package ch15abstractFactory;

public class AbstractFactoryMain {
	public static void main(String[] args) throws Exception {
		
		IUser iuser1 = DataAccess.createUser();
		User user = new User();
		iuser1.insert(user);
		
		IDepartment idepartment = DataAccess.createDepartment();
		Department dsepartment = new Department();
		idepartment.insert(dsepartment);
	}
}
