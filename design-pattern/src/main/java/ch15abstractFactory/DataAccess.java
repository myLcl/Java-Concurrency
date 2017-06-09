package ch15abstractFactory;

import java.util.ResourceBundle;


public class DataAccess {
	 //static char db = 's';
	 //static char db = 'a';
	
	static String namespace = "ch15abstractFactory.";
	static String db = ResourceBundle.getBundle("ch15abstractFactory/db").getString("db");
	
	 public static IUser createUser() throws Exception {
//		 IUser user = null;
//		 
//		 switch(db) {
//			 case 's':
//				 user = new SqlserverUser();
//				 break;
//			 case 'a':
//				 user = new AccessUser();
//				 break;
//		 }
		 
//		 return user;
		 
		 Class<IUser> user =(Class<IUser>) Class.forName(namespace + db + "User");
		 IUser iUser = user.newInstance();
		 
		 return iUser;
		 
	 }
	 
	 public static IDepartment createDepartment() throws Exception {
//		 IDepartment department = null;
//		 
//		 switch(db) {
//			 case 's':
//				 department = new SqlserverDepartment();
//				 break;
//			 case 'a':
//				 department = new AccessDepartment();
//				 break;
//		 }
//		 
//		 return department;
		 
		 Class<?> forName = Class.forName(namespace + db + "Department");
		 IDepartment department =(IDepartment)forName.newInstance();
		 
		 return department;
		 
	 }
}
