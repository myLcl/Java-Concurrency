package basic;

/**
 * 使用synchronized 实现生产者消费者模式
 *wait(), notify() : 生产者消费者 
 */
public class ProductConsumer{
	public static void main(String[] args) {
		Shared s = new Shared();
		new Producer(s).start();
		new Consumer(s).start();
	}
}

/** 负责存储数据 */
class Shared {
	private char c;
	private volatile boolean writeable = true;
	
	synchronized void setSharedChar(char c) {
		while (!writeable) {
			try  {
				wait();
			}
			catch (InterruptedException ie){
			}
		}
		
		this.c = c;
		System.out.println(c + " produced by producer.");
		
		writeable = false;
		notify();
	}
	
	synchronized char getSharedChar(){
		while (writeable) {
			try{
				wait();
			}
			catch (InterruptedException ie){
			}
		}
		
		writeable = true;
		notify();
		
		System.out.println(c + " consumed by consumer.");
		return c;
	}
}
	
/** 生产者 */
class Producer extends Thread{
	private final Shared s;
	
	Producer(Shared s){
		this.s = s;
	}
	
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++){
			synchronized (s) {
				s.setSharedChar(ch);
			}
		}
	}
}
	
/** 消费者 */
class Consumer extends Thread {
	private final Shared s;

	Consumer(Shared s) {
		this.s = s;
	}

	@Override
	public void run() {
		char ch;
		do {
			synchronized (s) {
				ch = s.getSharedChar();
			}
			
		} 
		while (ch != 'Z');
	}
}
