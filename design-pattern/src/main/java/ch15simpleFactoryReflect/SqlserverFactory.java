package ch15simpleFactoryReflect;

public  class SqlserverFactory implements IFactory{

	public IUser createUser() {
		return new SqlserverUser();
	}

	public IDepartment createDepartment() {
		return new SqlserverDepartment();
	}

	
}
