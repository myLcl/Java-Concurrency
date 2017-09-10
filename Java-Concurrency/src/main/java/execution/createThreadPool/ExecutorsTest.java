package execution.createThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *创建线程池
 */
public class ExecutorsTest {
	public static void main(String[] args) {
//		scheduled();
		cached();
	}

	//缓存线程池
	public static void cached() {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++){
			executorService.execute(new MyRunnable());
		}

		executorService.shutdown();

	}

	//单一线程池
	public static void single() {
		ExecutorService  executorService = Executors.newSingleThreadExecutor();
	}

	//定时线程池
	public static void scheduled() {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
		//如果前面的任务还未完成，则调度不会启动。
		ses.scheduleWithFixedDelay(new Runnable() {

			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println(System.currentTimeMillis()/1000);
				} catch (Exception e) {
				}

			}
		}, 0, 2, TimeUnit.SECONDS);//启动0秒后执行，然后周期2秒执行一次

	}

	//定长线程池
	public static void fixed() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

	}
}


class MyRunnable implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName() + "被调用");
	}
}
