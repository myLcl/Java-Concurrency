package execution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Phaser;

/**
 * 有些时候我们希望只有在某些外部条件满足时: 控制台输入按enter, 且主线程在其它工作线程结束之前已经终止
 */
public class MyPhaser_3 {
	public static void main(String args[]) throws Exception {  
        final Phaser phaser = new Phaser(2);  
        
        for(int i = 0; i < 5; i++) {  
        	phaser.register();  //注册
            final Thread thread = new Thread(new Task(i, phaser));  
            thread.start();  
        }  
          
        //只有当用户按下回车之后，任务才真正开始执行 
        System.out.println("Press ENTER to continue");  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        reader.readLine();  
        
        phaser.arriveAndDeregister();//取消注册
        
        System.out.println("程序结束");
    }  
      
    public static class Task implements Runnable {  
        private final int id;  
        private final Phaser phaser;  
  
        public Task(int id, Phaser phaser) {  
            this.id = id;  
            this.phaser = phaser;  
        }  
          
        public void run() {  
            phaser.arriveAndAwaitAdvance();  
            System.out.println("in Task.run(), phase: " + phaser.getPhase() + ", id: " + this.id);  
        }  
    }  
}
