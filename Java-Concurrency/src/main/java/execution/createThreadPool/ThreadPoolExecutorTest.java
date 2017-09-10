package execution.createThreadPool;

import java.util.concurrent.*;

/**
 * 自定义线程池: 标准线程池, 增强线程池 , 失败处理
 */
public class ThreadPoolExecutorTest {
	public static void main(String[] args){   

    }


    /**
     * 增加线程池, 提供扩展操作
     */
    public static void  strength() {
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                    0L, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>()){

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成");
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }

        };
    }

    /**
     * 标准线程池
     */
    public static void pool() {
        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);

        //创建线程池，池中保存的线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,
                50,TimeUnit.MILLISECONDS,bqueue);

        //创建七个任务
        Runnable t1 = new MyThread();
        Runnable t2 = new MyThread();
        Runnable t3 = new MyThread();
        Runnable t4 = new MyThread();
        Runnable t5 = new MyThread();
        Runnable t6 = new MyThread();
        Runnable t7 = new MyThread();

        //每个任务会在一个线程上执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);

        //关闭线程池
        pool.shutdown();
    }
}   
  
class MyThread implements Runnable{   
    public void run(){   
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");   
        try{   
            Thread.sleep(100);   
        }catch(InterruptedException e){   
            e.printStackTrace();   
        }   
    }   
}  
