package ch15simpleFactoryReflect;

public class AccessUser implements IUser {

	public User getUser(int id) {
		System.out.println("Get a record from table User in Access ");
		return null;
	}

	public void insert(User user) {
		System.out.println("Insert a record for table User in Access ");

	}

}
