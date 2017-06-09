package basic;

public class InterruptBySemaphore {
	public static void main(String[] args){
		
		class StoppableThread extends Thread {
			private boolean stopped; // 标志位 defaults to false
			
			@Override
			public void run(){
				int count = 1;
				
				System.out.println("标志位=====" + stopped);
				while(!stopped) {
					System.out.println("循环次数=====" + count);
					count++;
				} 
				System.out.println("标志位=====" + stopped + " :循环结束");
			}
			
			void stopThread(){
				stopped = true;
			}
			
		}
		
		StoppableThread thd = new StoppableThread();
		thd.start();
		try{
			Thread.sleep(1); 
		}
		catch (InterruptedException ie){
		}
		
		thd.stopThread();
		
	}
}
