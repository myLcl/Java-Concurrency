package ch15abstractFactory;

public class SqlserverUser implements IUser{
	public void insert(User user) {
		System.out.println("Sqlserver-insert-user");
	}  
	
}
