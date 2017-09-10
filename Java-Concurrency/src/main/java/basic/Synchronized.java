package basic;


/**
 *测试Synchronized关键字
 * <p>
 * main()是测试入口
 */
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
//		codeBlock00();
//		codeBlock01();

//		memberMethod00();
//		memberMethod01();

//		staticMethod();

		//可重入
		final Thread4 t = new Thread4(); //保证锁唯一
		for (int i = 0; i <5 ; i++) {
			new Thread(t).start();
			
		}
	}


	/**
	 * 锁代码块
	 * <p>
	 *  给定一个对象, 开启多个线程 , 线程顺序输出
	 */
	public static void codeBlock00() {
		Synchronized s = new Synchronized();
		Thread1 t1 = new Thread1(s);
		new Thread(t1).start();
		new Thread(t1).start();
	}

	/**
	 * 锁代码块
	 * <p>
	 *  给定一个对象, 开启多个线程 , 线程输出顺序是乱的
	 */
	public static void codeBlock01() {
		Synchronized s1 = new Synchronized();
		Synchronized s2 = new Synchronized();
		Thread1 t1 = new Thread1(s1);
		Thread1 t2 = new Thread1(s2);
		new Thread(t1).start();
		new Thread(t2).start();
	}


	/**
	 * 锁成员方法
	 * <p>
	 * 一个对象开启多个线程 , 线程顺序输出
	 */
	public static void memberMethod00() {
		Thread2 t = new Thread2();
		new Thread(t).start();
		new Thread(t).start();
	}
	/**
	 * 锁成员方法
	 * <p>
	 *  多个对象分别开启线程 , 线程的输出顺序是乱的
	 */
	public static void memberMethod01() {
		Thread2 t2 = new Thread2();
		Thread2 t1 = new Thread2();
		new Thread(t2).start();
		new Thread(t1).start();
	}


	/**
	 * 锁静态方法
	 * <p>
	 *  多个对象, 开启多个线程, 线程的顺序输出
	 */
	public static void  staticMethod() {
		Thread3 t0 = new Thread3();
		Thread3 t1 = new Thread3();
		new Thread(t0).start();
		new Thread(t1).start();
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
	
	//修饰成员方法,锁的是调用它的对象
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
	
	//修饰静态方法, 锁的是class对象
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


//验证可重入的特性
class Thread4 implements Runnable{


	public synchronized  void run() { //第一次获得t的锁
		doSomething();  //再次活的t的锁
	}

	public synchronized void doSomething() {
		System.out.println("----");
	}

}