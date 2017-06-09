package execution;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *可变数目: 动态注册和取消 
 *
 *示例: 
 *	在旅游过程中,有可能很凑巧遇到几个朋友,
 *	然后他们听说你们在旅游,所以想要加入一起继续接下来的旅游.
 *	也有可能,在旅游过程中,突然其中有某几个人临时有事,想退出这次旅游了
 */
public class MyPhaser_5 {
    public static void main(String[] args) {
    	final int num = 3;
        Phaser phaser = new Phaser(num){
        	/**
        	 * 如果该方法返回true，那么Phaser会被终止, 默认实现是在注册任务数为0时返回true
        	 * phase : 阶段数
        	 * registeredParties : 注册的线程数 
        	 */
        	 @Override
             protected boolean onAdvance(int phase, int registeredParties) {
                 System.out.println("" + getArrivedParties() + "个人都到齐了,第" + (phase + 1) + "次集合 \n");
                 return phase >= num;
             }
        };
        
        new Thread(new TourismRunnable(phaser),"小明").start();
        new Thread(new TourismRunnable(phaser),"小刚").start();
        new Thread(new TourismRunnable(phaser),"小红").start();
    }
}

/** 旅行线程 */
class TourismRunnable implements Runnable{
    Phaser phaser;
    /**
     * 每个线程保存一个朋友计数器,小红第一次遇到一个朋友,取名`小红的朋友0号`,第二次遇到一个朋友,取名为`小红的朋友1号`
     */
    AtomicInteger frientCount = new AtomicInteger();
    
    public TourismRunnable(Phaser phaser) {
        this.phaser = phaser;
    }
 
    public void run() {
    	 switch (phaser.getPhase()){
	         case 0:if(!goToPoint("出发点")) break;
	         case 1:if(!goToPoint("旅游景点")) break;
	         case 2:if(!goToPoint("酒店")) break;
    	 }
    }
 
    /**
     * @param point 目的地
     * @return 返回true,说明还要继续旅游,否则就临时退出了
     */
    private boolean goToPoint(String point){
        try {
            if(!randomEvent()){
            	//取消注册
                phaser.arriveAndDeregister();
                return false;
            }
            System.out.println(Thread.currentThread().getName() + "到了" + point);
            
            //阻塞
            phaser.arriveAndAwaitAdvance();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
 
    /**
     * 随机事件: 遇到新朋友一起旅游 或者 中途退出旅游
     * @return 返回true,说明还要继续旅游,否则就临时退出了
     */
    private boolean randomEvent() {
    	int random = new Random().nextInt(100);
        String name = Thread.currentThread().getName();
        
        if (random < 10){
            int friendNum =  1;
            System.out.println("=====================" + name + ":遇到了"+friendNum+"个朋友,要一起去旅游");
            
            new Thread(new TourismRunnable(phaser), name + "的朋友" + frientCount.incrementAndGet() + "号").start();
            //注册
            phaser.bulkRegister(friendNum);
            
        }else if(random > 80){
            System.out.println("=====================" + name + ":突然有事要离开一下,不和他们继续旅游了");
            return false;
        }
        
        return true;
    }
}