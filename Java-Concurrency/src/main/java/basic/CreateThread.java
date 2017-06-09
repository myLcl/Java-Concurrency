package basic;

/**
 *1.创建线程的两种方式 
 *2.设置和获取线程的状态: 名字, 存活状态, 运行状态, 优先级, 守护线程
 *3.开始线程: 
 */
public class CreateThread {

	public static void main(String[] args) {
//		Thread currentThread = Thread.currentThread();
//		System.out.println(currentThread.getName());
//		MyThread thread = new MyThread();
//		thread.setDaemon(true);
//		System.out.println(thread.isDaemon());
//		System.out.println(thread.getPriority());
//		thread.setPriority(Thread.MAX_PRIORITY);
//		System.out.println(thread.getPriority());
//		System.out.println(thread.getState());
//		thread.setName("00");
//		System.out.println(thread.getName());
//		System.out.println(thread.getId());
//		System.out.println(thread.isAlive());
//		
//		thread.start();
//		
//		MyRunnable runnable = new MyRunnable();
//		new Thread(runnable).start();
		
//		new MyThread().start();
//		new MyThread().start();
		
		MyRunnable r = new MyRunnable();
		new Thread(r).start(); 
		new Thread(r).start(); 
	}
	
}


class MyThread extends Thread {
	private int ticket = 5; 
	
	@Override
	public void run() {
		for (int i=0;i<10;i++) {  
            if(ticket > 0){  
                System.out.println("ticket = " + ticket--);  
            }  
        }  
	}
}

class MyRunnable implements Runnable {
	private int ticket = 5; 
	
	public void run() {
		for (int i=0;i<10;i++) {  
            if(ticket > 0){  
                System.out.println("ticket = " + ticket--);  
            }  
        } 
	}
}
