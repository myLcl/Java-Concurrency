package com.jvm.lcl;

/**
 * 类加载测试
 *
 */
public class ClassLoaderTest {
    public static void main( String[] args ) throws ClassNotFoundException
    {
    	 ClassLoader loader = HelloWorld.class.getClassLoader(); 
         System.out.println(loader); 
         
//         使用ClassLoader.loadClass()来加载类，不会执行初始化块 
//         loader.loadClass("com.jvm.lcl.Test01"); 
         
         //使用Class.forName()来加载类，默认会执行初始化块 
//         Class.forName("com.jvm.lcl.Test01"); 
         
         //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块 
         Class.forName("com.jvm.lcl.Test01", false, loader); 
    }
}

class Test01 {
	static 
	{ 
        System.out.println("静态初始化块执行了！"); 
	} 
}
