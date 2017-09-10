package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 *等待多个线程任务到达阻塞点
 * <p>
 *  Conference 会场线程 Participater参会者线程
 *  会场线程启动, 等待3个参会者线程
 *
 */
public class CountDownLatchTest {
	public static void main(String[] args) {
        //启动会议室线程，等待与会人员参加会议
        Conference conference = new Conference(3);
        new Thread(conference).start();
        
        //参会者线程
        for(int i = 0 ; i < 3 ; i++){
            Participater participater = new Participater("" + i , conference);
            Thread thread = new Thread(participater);
            thread.start();
        }
    }
}

/** 会场类 */
class Conference implements Runnable{
    private final CountDownLatch countDown;//障碍器
    
    public Conference(int count){
        countDown = new CountDownLatch(count);
    }
    
    /** 与会人员到达 */
    public void arrive(String name){
        System.out.println(name + "到达.....");
        
        //到达一个,锁计数器 - 1, 在计数到达0之前会一直阻塞
        countDown.countDown();
        
        System.out.println("还有 " + countDown.getCount() + "位没有到达...");
    }
    
    public void run() {
        System.out.println("准备开会，参加会议人员总数为：" + countDown.getCount());
        
        //调用await(),等待所有的与会人员到达
        try {
            countDown.await();
        } catch (InterruptedException e) {
        }
        
        System.out.println("所有人员已经到达，会议开始.....");
    }
}

/** 参会者类*/
class Participater implements Runnable{
    private String name;
    private Conference conference;
    
    public Participater(String name,Conference conference){
        this.name = name;
        this.conference = conference;
    }

    public void run() {
        conference.arrive(name);
    }
}