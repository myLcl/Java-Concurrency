package ch15simpleFactoryReflect;

import java.util.ResourceBundle;


public class DataAccess {
	
	//abstractFactory为包名，db为资源文件的的名称 ,不需要加.propertie后缀
	private static final String db = ResourceBundle.getBundle("abstractFactory/db").getString("db"); 

	public static IUser createUser() throws InstantiationException, IllegalAccessException {
		String className = "abstractFactory." + db + "User";
		IUser result = null;
		try {
			Class<?> cls = Class.forName(className);
			Object obj = cls.newInstance();
			result = (IUser) obj;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (IUser) result;
	}
	
	public static IDepartment createDepartment() throws InstantiationException, IllegalAccessException {
		String className = "abstractFactory." + db + "Department";
		IDepartment result = null;
		try {
			Class<?> cls = Class.forName(className);
			Object obj = cls.newInstance();
			result = (IDepartment) obj;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (IDepartment) result;
		
	}

}
