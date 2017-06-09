package execution;

import java.util.concurrent.Phaser;
/**
 *相当于CountDownLatch
 */
public class MyPhaser_1 {
	public static void main(String[] args) {
		//CountDownLatch(1);
		Phaser phaser = new Phaser(1); 

		// 执行任务
		for (int i = 0; i < 3; i++) {
			Task task = new Task(phaser);
			Thread thread = new Thread(task);
			thread.start();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// countDownLatch.countDown()
		phaser.arrive(); 
	}
}

class Task implements Runnable {
	private final Phaser phaser;

	Task(Phaser phaser) {
		this.phaser = phaser;
	}

	public void run() {
		// countDownLatch.await()
		phaser.awaitAdvance(phaser.getPhase()); 
		
		System.out.println(Thread.currentThread().getName() + "执行任务...");
	}
}
