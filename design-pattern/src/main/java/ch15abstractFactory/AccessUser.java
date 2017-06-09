package ch15abstractFactory;

public class AccessUser implements IUser{

	public void insert(User user) {
		System.out.println("Access-insert-user");
	}

}
