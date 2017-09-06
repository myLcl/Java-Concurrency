package basic.thread;

import org.junit.Test;

import java.text.BreakIterator;

/**
 * 测试Thread基本操作
 * Created by conglin.liu on 2017/9/6.
 */
public class NativeThread {

    //创建线程00
    Thread thread00 = new Thread() {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println("thread00:" + i);
            }
        }
    };

    //创建线程01
    Thread thread01 = new Thread() {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println("thread01:" + i);
            }
        }
    };

    public static void main(String[] args) {
        //获取当前线程
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
    }

    /**
     * 匿名内部类创建线程
     */
    @Test
    public void createThread() throws InterruptedException {
        thread00.start();
        thread01.start();
//        thread01.join();
    }


    /**
     * 线程阻塞 : 中断interrupt
     */
    @Test
    public void interrupt() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted");
                        Thread.interrupted();//清除中断标示位
                        System.out.println(Thread.currentThread().isInterrupted());
                        break;
                    }
                }
            }
        };

        thread.start();
        thread.interrupt();

    }

    /**
     * 线程阻塞 : 加入 join
     */
    @Test
    public void join() {
        thread00.start();
    }

    /**
     * 线程优先级 : 高优先级并不总是先执行
     */
    @Test
    public void priority()  {
        thread00.setPriority(Thread.MIN_PRIORITY);
        thread01.setPriority(Thread.MAX_PRIORITY);
        thread00.start(); //低优先级执行
        thread01.start();
    }
}
