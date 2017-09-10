package collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 */
public class MyBlockQueue {
	public static void main(String[] args) throws InterruptedException {   
        BlockingQueue<String> bqueue = new ArrayBlockingQueue<String>(20);   
        
        for (int i = 0; i < 30; i++) {  
            //将指定元素添加到此队列中   
            bqueue.put("" + i);   
            System.out.println("向阻塞队列中添加了元素:" + i); 
            
            if(i > 8) {
            	System.out.println("从阻塞队列中移除元素==============" + bqueue.take());  
            }
            
        }   
        
        System.out.println("程序到此运行结束，即将退出----");   
	}   
}
