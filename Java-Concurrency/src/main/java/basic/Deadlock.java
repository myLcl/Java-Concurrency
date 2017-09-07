package basic;

public class Deadlock {
	//监视器对象
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();
	
	public void instanceMethod1(){
		synchronized(lock1){
			System.out.println("线程1: 获得lock1,等待lock2");
			synchronized(lock2)	{
				System.out.println("线程1:获得lock2");
			}
		}
	}
	
	public void instanceMethod2(){
		synchronized(lock2){
			System.out.println("线程2: 获得lock2,等待lock1");
			synchronized(lock1){
				System.out.println("线程2: 获得lock1");
			}
		}
	}
	
	public static void main(String[] args){
		final Deadlock dld = new Deadlock();
		
		Runnable r1 = new Runnable(){
			public void run(){
				while(true){
					dld.instanceMethod1();
					try{
						System.out.println("线程1: 睡眠");
						Thread.sleep(1000);
					}
					
					catch (InterruptedException ie){
					}
				}
			}
		};
		
		Runnable r2 = new Runnable(){
			public void run(){
				while(true) {
					dld.instanceMethod2();
					try {
						System.out.println("线程2: 睡眠");
						Thread.sleep(1000);
					}
					catch (InterruptedException ie){
					}
				}
			}
		};
		
		Thread thdA = new Thread(r1);
		Thread thdB = new Thread(r2);
		
		thdA.start();
		thdB.start();
	}
	
}
