package ch15simpleFactoryReflect;

public class SqlserverUser implements IUser{
	
	public SqlserverUser(){}

	public void insert(User user) {
		System.out.println("Insert a record for table User in Sqlserver ");
	}
	
	public User getUser(int id) {
		System.out.println("Get a record from table User in Sqlserver ");
		return null;
	}



}
