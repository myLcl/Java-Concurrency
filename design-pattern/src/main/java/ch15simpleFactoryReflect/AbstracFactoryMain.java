package ch15simpleFactoryReflect;


public class AbstracFactoryMain {
	public static void main(String[] args) throws Exception {
		IFactory factory1 = new SqlserverFactory();
		IUser iuser = factory1.createUser();
		User user = new User();
		iuser.insert(user);
		
		IFactory factory2 = new AccessFactory();
		IDepartment idepartment = factory2.createDepartment();
		idepartment.GetDepartment(1);
	}

}
