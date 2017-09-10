package atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *
 * AtomicStampedReference 测试
 * <P>
 * 解释下代码，初始是10元, 有3个线程在给用户充值，当用户余额少于20时，就给用户充值20元。有100个线程在消费，每次消费10元
 * 结果是仅充值一次
 *
 *Created by conglin.liu on 2017/9/9.
 */
public class AtomicStampedReferenceTest {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(
            19, 0);

    public static void main(String[] args)
    {
        for (int i = 0; i < 3; i++)
        {
            final int timestamp = money.getStamp();//获取时间戳

            //充值线程
            new Thread()
            {
                public void run()
                {
                    while (true)
                    {
                        while (true)
                        {
                            Integer m = money.getReference();//获得值
                            if (m < 20)
                            {
                                if (money.compareAndSet(m, m + 20, timestamp,
                                        timestamp + 1))
                                {
                                    System.out.println("充值成功，余额:"
                                            + money.getReference());
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                };
            }.start();
        }

        //消费线程
        new Thread()
        {
            public void run()
            {
                for (int i = 0; i < 100; i++)
                {
                    while (true)
                    {
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10)
                        {
                            if (money.compareAndSet(m, m - 10, timestamp,
                                    timestamp + 1))
                            {
                                System.out.println("消费10元，余额:"
                                        + money.getReference());
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {
                        // TODO: handle exception
                    }
                }
            };
        }.start();
    }
}
