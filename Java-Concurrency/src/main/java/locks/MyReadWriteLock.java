package locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 测试读写锁  : 多个线程读, 只能一个线程写
 */
public class MyReadWriteLock {
	public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Writer writer=new Writer(pricesInfo);
        Reader read =  new Reader(pricesInfo);
        
        //写线程
        Thread tw=new Thread(writer);
        tw.start();
        
        //多个读线程
        for (int i=0; i<5; i++){
            Thread tr=new Thread(read);
            tr.start();
        } 
    }
}

//读线程
class Reader implements Runnable{
    private PricesInfo pricesInfo;
    
    public Reader(PricesInfo pricesInfo){
        this.pricesInfo = pricesInfo;
    }

    public void run() {
        pricesInfo.getPrice();
    }
}

//写线程
class Writer implements Runnable{
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo){
        this.pricesInfo = pricesInfo;
    }
    
    public void run() {
    	pricesInfo.setPrice(Math.random()*10);
        
    }
}

//数据实体
class PricesInfo {
    private double price;
    
    private ReadWriteLock  lock = new ReentrantReadWriteLock();
    
    public PricesInfo(){
    }
    
    //读锁
    public void getPrice(){
        lock.readLock().lock();
		System.out.println(Thread.currentThread().getName()+ " : in read*****************************");
		System.out.println(Thread.currentThread().getName()+ ": 读取数据= " + price);
		lock.readLock().unlock();
    }
    
    //写锁
    public void setPrice(double price){
        lock.writeLock().lock(); 
        try {
			System.out.println(Thread.currentThread().getName()+ " :in Writer==============================================");
			Thread.sleep(1000);
			this.price = price;
			System.out.println(Thread.currentThread().getName()+ ":写入数据= " + price);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}
    }
}

