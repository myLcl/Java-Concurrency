package execution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 生产者和消费者交换数据
 */
public class MyExchanger {
	public static void main(String[] args) {
        Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
        
        Producer1 producer = new Producer1(new ArrayList<String>(), exchanger);
        Consumer1 consumer = new Consumer1(new ArrayList<String>(), exchanger);
        
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

/** 生产者线程*/
 class Producer1 implements Runnable{
    
    /**
     * 存储交换的数据
     */
    private List<String> buffer;
    
    /**
     * 和消费者要交换的对象
     */
    private final Exchanger<List<String>> exchanger;
    
    Producer1(List<String> buffer,Exchanger<List<String>> exchanger){
        this.buffer = buffer;
        this.exchanger = exchanger;
    }
    
    public void run() {
        for(int i = 0 ; i < 2 ; i++){
                String message = "" + i ;
                System.out.println("Produce的数据 : " + message);
                buffer.add(message);
            
            //调用exchange()与消费者进行数据交换
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Produce收到来自Consumer的数据的长度 : " + buffer.size());
    }
}
 
/** 消费者线程*/ 
class Consumer1 implements Runnable{
	    private List<String> buffer;
	    
	    private final Exchanger<List<String>> exchanger;
	    
	    public Consumer1(List<String> buffer,Exchanger<List<String>> exchanger){
	        this.buffer = buffer;
	        this.exchanger = exchanger;
	    }
	    
	    public void run() {
	        for(int i = 0 ; i < 2 ; i++){
	            //调用exchange()与消费者进行数据交换
	            try {
	                buffer = exchanger.exchange(buffer);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            
	            for(int j = 0 ; j < buffer.size() ; j++){
	                System.out.println("Consumer收到来自Produce的数据 : " + buffer.get(0));
	                buffer.remove(0);
	            }
	        }
	        
	        System.out.println("Consumer清空数据");
	    }
	} 