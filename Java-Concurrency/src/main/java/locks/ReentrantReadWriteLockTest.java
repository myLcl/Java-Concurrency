package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 测试 ReadWriteLock
 * <p>
 *     测试入口是main()
 */
public class ReentrantReadWriteLockTest {
	public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Writer writer=new Writer(pricesInfo);
        Reader read =  new Reader(pricesInfo);
        
        //写线程
        Thread t=new Thread(writer);
        t.start();

        //多个读线程
        for (int i=0; i<3; i++){
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
     double price  = 1;

     ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
     Lock writeLock = readWriteLock.writeLock(); //写锁
     Lock readLock = readWriteLock.readLock(); //读锁

    public PricesInfo(){
    }
    
    //读锁
    public void getPrice(){
        readLock.lock();
		System.out.println(Thread.currentThread().getName()+ ": 读取数据= " + price);
        readLock.unlock();
    }
    
    //写锁
    public void setPrice(double price){
        writeLock.lock();
        try {
			this.price = price;
			System.out.println(Thread.currentThread().getName()+ ":写入数据= " + price);
		}finally {
            writeLock.unlock();
		}
    }
}

