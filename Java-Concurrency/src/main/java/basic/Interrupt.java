package basic;

/**
 * 执行高级线程任务: 中断
 */
public class Interrupt {
	public static void main(String[] args)  {
		
		Runnable r = new Runnable() {
			public void run() {
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					
					//如果去掉这句, 下面的输出语句就会答应
//					return;
				}
				
				System.out.println(Thread.currentThread().isInterrupted());
				System.out.println("中断");
				
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		//主线程休眠,确保刚才启动的线程执行一段时间
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//中断线程
		t.interrupt();
		
		/** 测试 interrupted()*/
//		System.out.println(Thread.interrupted());
//		
//		//中断
//		Thread.currentThread().interrupt();
//		System.out.println(Thread.interrupted());
//		
//		System.out.println(Thread.interrupted());
	}
}
