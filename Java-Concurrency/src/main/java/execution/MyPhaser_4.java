package execution;

import java.util.concurrent.Phaser;

/**
 *主线程等待这些工作线程结束 
 */
public class MyPhaser_4 {
	public static void main(String args[]) throws Exception {  
        final int count = 5;  
        final int phaseToTerminate = 3;  
        
        final Phaser phaser = new Phaser(count) {  
            @Override  
            protected boolean onAdvance(int phase, int registeredParties) {  
                System.out.println("===================== " + phase + " ==================");  
                return phase == phaseToTerminate;  
            }  
        };  
          
        for(int i = 0; i < count; i++) {  
            System.out.println("starting thread, id: " + i);  
            final Thread thread = new Thread(new Task(i, phaser));  
            thread.start();  
        }  
          
        //主线程等待其他线程结束 
        phaser.register();  
        while (!phaser.isTerminated()) {  
            phaser.arriveAndAwaitAdvance();  
        }  
        
        System.out.println("done");  
    }  
      
    public static class Task implements Runnable {  
        //  
        private final int id;  
        private final Phaser phaser;  
  
        public Task(int id, Phaser phaser) {  
            this.id = id;  
            this.phaser = phaser;  
        }  
          
        public void run() {  
            while(!phaser.isTerminated()) {  
                try {  
                    Thread.sleep(500);  
                } catch(InterruptedException e) {  
                    // NOP  
                }  
                System.out.println(Thread.currentThread().getName()+"--phase: " + phaser.getPhase() + "--id: " + this.id);  
                phaser.arriveAndAwaitAdvance();  
            }  
        }  
    }  

}
