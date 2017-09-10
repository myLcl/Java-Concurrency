package atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 测试AtomicIntegerFieldUpdater
 * <p>
 *   将score使用 AtomicIntegerFieldUpdater变成 AtomicInteger。保证了线程安全
 *
 * Created by conglin.liu on 2017/9/9.
 */
public class AtomicIntegerFieldUpdaterTest {
    public static class V{
        int id;
        volatile int score; //下面将操作该变量为原子变量
        public int getScore()
        {
            return score;
        }
        public void setScore(int score)
        {
            this.score = score;
        }

    }
    public final static AtomicIntegerFieldUpdater<V> vv = AtomicIntegerFieldUpdater.newUpdater(V.class, "score");

    public static AtomicInteger allscore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException
    {
        final V stu = new V();
        Thread[] t = new Thread[10000];
        for (int i = 0; i < 10000; i++)
        {
            t[i] = new Thread() {
                @Override
                public void run()
                {
                    if(Math.random()>0.4)
                    {
                        vv.incrementAndGet(stu);
                        allscore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }

        //阻塞线程
        for (int i = 0; i < 10000; i++)
        {
            t[i].join();
        }

        //当输出相同 ,说明线程安全
        System.out.println("score="+stu.getScore());
        System.out.println("allscore="+allscore);
    }
}
