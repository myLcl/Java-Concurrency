package ch21singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Singleton {
	private static Singleton singleton;
	private static Lock lock = new ReentrantLock();// 锁对象  

	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			lock.lock();
			
			if(singleton == null) {
				singleton = new Singleton();
			}
			
			lock.unlock();//释放锁
		}
		
		return singleton;
	}
	
	public static void main(String[] args) {
		new Thread() {  
	            public void run() {  
	            	System.out.println(getInstance());
	            };  
	        }.start();   
		
        new Thread() {  
            public void run() {  
            	System.out.println(getInstance());
            };  
        }.start();  
        
        System.out.println(singleton);
	}
	
}
