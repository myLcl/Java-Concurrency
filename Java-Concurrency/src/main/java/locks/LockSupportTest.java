package locks;

import java.util.concurrent.locks.LockSupport;

/**
 *  测试线程挂起和继续执行
 *  <p>
 *      测试入口main()
 *
 * Created by conglin.liu on 2017/9/10.
 */
public class LockSupportTest {
    static Object u = new Object();
    static TestSuspendThread t1 = new TestSuspendThread("t1");
    static TestSuspendThread t2 = new TestSuspendThread("t2");

    public static class TestSuspendThread extends Thread
    {
        public TestSuspendThread(String name)
        {
            setName(name);
        }

        @Override
        public void run()
        {
            synchronized (u)
            {
                System.out.println("in " + getName());
                //挂起
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        t1.start();
        Thread.sleep(100);
        t2.start();
        //继续执行
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
