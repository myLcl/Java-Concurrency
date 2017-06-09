package execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *线程池执行Runnable任务 
 */
public class MyExecutors {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++){   
	        executorService.execute(new MyRunnable());   
	    } 
		 
	    executorService.shutdown(); 
	}

}

class MyRunnable implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName() + "被调用");
	}
}
