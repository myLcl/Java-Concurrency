package locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *线程间通信
 */
public class MyCondition{  
    public static void main(String args[]){  
        Info info = new Info(); 
        
        //启动生产者
        Producer pro = new Producer(info) ; 
        new Thread(pro).start() ;  
        
        try{  
            Thread.sleep(100) ;  
        }catch(InterruptedException e){  
            e.printStackTrace() ;  
        }  
  
        //启动消费者
        Consumer con = new Consumer(info) ;
        new Thread(con).start() ;  
    }  
}  

/**定义信息类   */
class Info{  
    private String name = null;
    private String content = null ;
    private boolean flag = true ;   // true生产, false消费  
  
    private Lock lock = new ReentrantLock();    
    private Condition condition = lock.newCondition(); //产生一个Condition对象  
   
    public  void set(String name,String content){  
        lock.lock();  
        try{  
            while(!flag){  
                condition.await() ;  
            }  
            
            this.setName(name) ;   
            
            Thread.sleep(300) ;  
            
            this.setContent(content) ; 
            flag  = false ; // 改变标志位，表示可以取走  
            
            System.out.println("生产者: " + this.getName() +  " --> " + this.getContent()) ;
            
            condition.signal();  
        }catch(InterruptedException e){  
            e.printStackTrace() ;  
        }finally{  
            lock.unlock();  
        }  
    }  
  
    public void get(){  
        lock.lock();  
        try{  
            while(flag){  
                condition.await() ;  
            }     
            
            Thread.sleep(300) ;  
            
            System.out.println("消费者: " + this.getName() +  " --> " + this.getContent()) ;  
           
            flag  = true ;  // 改变标志位，表示可以生产  
           
            condition.signal();  
        }catch(InterruptedException e){  
            e.printStackTrace() ;  
        }finally{  
            lock.unlock();  
        }  
    }  
  
    public void setName(String name){  
        this.name = name ;  
    }  
    public void setContent(String content){  
        this.content = content ;  
    }  
    public String getName(){  
        return this.name ;  
    }  
    public String getContent(){  
        return this.content ;  
    }  
}  

/**生产者线程 */
class Producer implements Runnable{   
    private Info info = null ;      // 保存Info引用  
    
    public Producer(Info info){  
        this.info = info ;  
    }  
    
    public void run(){  
        boolean flag = true ;   // 定义标记位  
        for(int i=0;i<10;i++){  
            if(flag){  
                this.info.set("姓名--1","内容--1") ;    
                flag = false ;  
            }else{  
                this.info.set("姓名--2","内容--2") ;     
                flag = true ;  
            }  
        }  
    }  
} 

/**消费者线程 */
class Consumer implements Runnable{  
    private Info info = null ;  
    
    public Consumer(Info info){  
        this.info = info ;  
    }  
    public void run(){ 
        for(int i=0;i<10;i++){  
            this.info.get() ;  
        }  
    }  
} 