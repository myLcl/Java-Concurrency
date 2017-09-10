package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *测试Semaphore
 * <p>
 *  并发数量设置为3个, 线程池开启10个线程访问, 每释放一个许可 ,可允许的线程增加1
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		// 使用线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		// 只允许3个线程同时访问
		final Semaphore semp = new Semaphore(3);

		// 模拟10个客户端访问
		for (int index = 0; index < 10; index++) {

			Runnable run = new Runnable() {
				public void run() {
					try {
						// 获取许可
						semp.acquire();

						System.out.println("线程"+ Thread.currentThread().getName() + "获得许可：");

						// 模拟耗时的任务
						for (int i = 0; i < 999999; i++);

						// 释放许可
						semp.release();

						System.out.println("线程"+ Thread.currentThread().getName() + "释放许可：");
						System.out.println("当前允许进入的任务个数："+ semp.availablePermits());

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

			exec.execute(run);
		}
		// 关闭线程池
		exec.shutdown();
	}
}