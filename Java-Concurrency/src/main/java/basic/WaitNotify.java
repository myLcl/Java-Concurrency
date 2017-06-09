package basic;


/**
 * 线程协作
 * wait(), notify() : 抛出：IllegalMonitorStateException - 如果当前线程不是此对象监视器的所有者
 *
 */
public class WaitNotify {
    public static String a = "";// 作为监视器对象

    public static void main(String[] args) throws InterruptedException {
    	WaitNotify wa = new WaitNotify();
        TestTask task = wa.new TestTask();
        
        Thread t = new Thread(task);
        t.start();
        
        //主线程休眠
        Thread.sleep(100);
        
        for (int i = 1; i > 0; i--) {
            System.out.println("快唤醒挂起的线程************");
            Thread.sleep(100);
        }
        
        synchronized (a) {
            a.notifyAll();
        }
    }

    
    class TestTask implements Runnable {

        public void run() {
            synchronized (a) {
                try {
                    for (int i = 1; i > 0; i--) {
                        System.out.println("我在运行 ***************");
                    }
                    
                    a.wait();
                    
                    for (int i = 1; i > 0; i--) {
                        System.out.println("又开始运行了*******");
                    }
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
