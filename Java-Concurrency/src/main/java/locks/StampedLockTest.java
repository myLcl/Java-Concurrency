package locks;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by conglin.liu on 2017/9/10.
 */
public class StampedLockTest {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    // 写锁方法
    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    //读锁方法
    double distanceFromOrigin() { // A read-only method
       // 根据stamp来查看是否互斥，写一次stamp变增加某个值
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;

        /*
        validate中会先查看是否有写线程在写，然后再判断输入的值和当前的 stamp是否相同，
        即判断是否读线程将读到最新的数据。如果有写线程在写，或者 stamp数值不同，则返回失败。
         */
        if (!sl.validate(stamp)) {
            //写锁退化成普通的读锁去读
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
