package basic;

public class Synchronized {
	private int count;
	
	public void getCount(){
		for (int i = 0; i < 5; i ++) {
		      try {
		         System.out.println(Thread.currentThread().getName() + ":" + (count++));
		         
		         Thread.sleep(100);
		      } catch (InterruptedException e) {
		         e.printStackTrace();
		      }
		   }
	}
	
    public static void main(String[] args) throws Exception {
    	Thread1 t1 = new Thread1(new Synchronized());
    	new Thread(t1).start();
    	new Thread(t1).start();
    	
    	/*Thread2 t2 = new Thread2();
    	new Thread(t2).start();
    	new Thread(t2).start();*/
    	
    	/*Thread3 t3_0 = new Thread3();
    	Thread3 t3_1 = new Thread3();
    	new Thread(t3_0).start();
    	new Thread(t3_1).start();*/
    	
    }
}

/** 修饰代码块 */
class Thread1 implements Runnable{
	private Synchronized s;
	
	public Thread1(Synchronized s) {
		this.s = s;
	}
	
	public void run() {
		 //修饰代码块: 锁的是()中配置的对象
		 synchronized(s) {
			 s.getCount();
			 
             try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	     }  
	}
}

/** 修饰成员方法 */
class Thread2 implements Runnable{
	private int count;
	
	//修饰成员方法,锁的是调用它的对象,该例中也即是调用它的线程
	public synchronized void run() {
		 for (int i = 0; i < 5; i ++) {
		      try {
		         System.out.println(Thread.currentThread().getName() + ":" + (count++));
		         
		         Thread.sleep(100);
		      } catch (InterruptedException e) {
		         e.printStackTrace();
		      }
		   }
	}
}

/** 修饰静态方法 */
class Thread3 implements Runnable {
	private static int count;
	
	//修饰静态方法, 锁的是这个类的所有对象
	public static synchronized void getCounter() {
		for (int i = 0; i < 5; i ++) {
	         try {
	            System.out.println(Thread.currentThread().getName() + ":" + (count++));
	            Thread.sleep(100);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }
	}
	
	public void run() {
		getCounter();
	}
}
