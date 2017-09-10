package atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference测试
 * <p>
 * 是原子操作模板类 ,用来封装任意类型的数据
 *<p>
 * 开启10个线程进行无锁操作,只有一个线程修改成功
 * Created by conglin.liu on 2017/9/9.
 */
public class AtomicReferenceTest {
    public final static AtomicReference<String> atomicString = new AtomicReference<String>("hosee");
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            final int num = i;
            new Thread() {
                public void run() {
                    try
                    {
                        Thread.sleep(Math.abs((int)Math.random()*100));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    if (atomicString.compareAndSet("hosee", "ztk"))
                    {
                        //只有一个线程会打印
                        System.out.println(Thread.currentThread().getId() + "Change value");
                    }else {
                        System.out.println(Thread.currentThread().getId() + "Failed");
                    }
                };
            }.start();
        }
    }
}
