package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试可中断, 可限时
 *
 * <p>测试入口是main()
 *
 * <P> 可中断
 *  主线程的 write() 和 read() 由同一把锁锁住
 *  写线程,开启无线循环; 主线程设置读线程中断; 读线程监听中断信号
 *
 *  <p>可限时5秒
 *  两个线程获得同一把锁, 获得锁后,睡眠6秒, 因此必有一个线程获不到锁而退出
 *
 */
public class ReentrantLockTest {
	private ReentrantLock lock = new ReentrantLock();  

	//写线程调用
    public void write() {  
        lock.lock();  
        try {  
            long startTime = System.currentTimeMillis();  
            System.out.println("in write : 开始往这个buff写入数据…");
            for (;;)// 模拟要处理很长时间      
            {  
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;  
                }  
            }  
        } finally {
            lock.unlock();  
        }  
    }  

    //读线程调用
    public void read() throws InterruptedException {
        lock.lockInterruptibly();// 注意这里，可以接收到中断信号
        try {
            System.out.println("in read : 从这个buff读数据");
        } finally {  
            lock.unlock();  
        }  
    }  

    //测试可中断
   public static void interuptTest() {
       ReentrantLockTest buff = new ReentrantLockTest();

       final WriterThread writer = new WriterThread(buff);
       final ReaderThread reader = new ReaderThread(buff);

       writer.start();
       reader.start();

       //主线程等待2秒
       long start = System.currentTimeMillis();
       for (;;) {
           if (System.currentTimeMillis() - start > 5000) {
               System.out.println("in main : 不等了，读线程尝试中断");
               reader.interrupt();  //此处中断读操作
               break;
           }
       }
    }

    //测试可限时
    public static void limitTimeTest() {
        LimitTimeThread timeThread = new LimitTimeThread();
        Thread t1 = new Thread(timeThread);
        Thread t2 = new Thread(timeThread);
        t1.start();
        t2.start();
    }

    public static void main(String args[]) {
//        interuptTest();


        limitTimeTest();

    }


}  
  
class ReaderThread extends Thread {
  
    private ReentrantLockTest buff;
  
    public ReaderThread(ReentrantLockTest buff) {
        this.buff = buff;  
    }  
  
    @Override  
    public void run() {  
  
        try {  
            buff.read();//可以收到中断的异常，从而有效退出      
        } catch (InterruptedException e) {  
            System.out.println("in reader2 : 我不读了");
        }  

    }  
}  
  
class WriterThread extends Thread {
  
    private ReentrantLockTest buff;
  
    public WriterThread(ReentrantLockTest buff) {
        this.buff = buff;  
    }  
  
    @Override  
    public void run() {  
        buff.write();  
    }  
}

//可限时线程
class LimitTimeThread extends Thread{
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run()
    {
        try
        {
            if (lock.tryLock(5, TimeUnit.SECONDS))
            {
                Thread.sleep(6000);
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + " : get lock failed");
            }
        }
        catch (Exception e)
        {
        }
        finally
        {
            if (lock.isHeldByCurrentThread())
            {
                lock.unlock();
            }
        }
    }

}
