package basic;

/**
 * sleep()
 * @author Administrator
 *
 */
public class Sleep {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				int count = 0;
				while(!Thread.interrupted()) {
					System.out.println(Thread.currentThread().getName() +":" + (count++) );
				}
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		
		
		try {
			t1.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		t1.interrupt();
		t2.interrupt();
	}
}
