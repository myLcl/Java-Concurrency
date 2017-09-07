package basic;

/**
 * 内存可见性关键字:Volatile
 */
public class Volatile  implements Runnable {  
    private int value;    
    private volatile boolean missedIt;  
    private long creationTime;   
  
    public Volatile() {  
        value = 10;  
        missedIt = false;  
        //获取当前时间，亦即调用Volatile构造函数时的时间  
        creationTime = System.currentTimeMillis();  
    }  
  
    public void run() {  
        print("entering run()");  
  
        if(value == 50) {
        	print("in run() -- value = " + value);
        }
        
        //循环检查value的值是否不同
        while ( value < 20 ) {  
            if  ( missedIt ) {  
            	
                //进入同步代码块前，将value的值赋给currValue  
                int currValue = value;  
                
                //在一个任意对象上执行同步语句，目的是为了让该线程在进入和离开同步代码块
                //将该线程中的所有变量的私有拷贝与共享内存中的原始值进行比较，  
                //从而发现没有用volatile标记的变量所发生的变化  
                Object lock = new Object(); 
                synchronized ( lock ) {  
                    //不做任何事  
                }  
                
                //离开同步代码块后，将此时value的值赋给valueAfterSync  
                int afValue = value;
                
                print("in run() - currValue=" + currValue );  
                print("in run() - afValue=" + afValue);  
//                break;   
            }  
        }  
        
        print("leaving run()");  
    }  
  
    
    public void workMethod() throws InterruptedException {  
        print("entering workMethod()");  
        
        //改变missedIt的值  
        missedIt = true;
        print("missedIt = " + missedIt);
        Thread.sleep(2000);  
        
        //改变value的值  
        value = 50; 
        print("value = " + value);
        Thread.sleep(2000);  
        
        print("leaving workMethod()");  
    }  
  
/* 
*打印程序执行到此所化去的时间
*打印msg的代码所在的线程 
*/  
    private void print(String msg) {  
        //时间
        long interval = System.currentTimeMillis() - creationTime;  
        String tmpStr = "" + ( interval / 1000.0 ) ;       
        
        //当前线程名
        String nameStr = "        " + Thread.currentThread().getName();  
        nameStr = nameStr.substring(nameStr.length() - 8, nameStr.length());      
        
        System.out.println(tmpStr + " " + nameStr + ": " + msg);  
    }  
  
    
    
    public static void main(String[] args) {  
        try {  
            //通过该构造函数可以获取实时时钟的当前时间  
            Volatile vol = new Volatile();  
  
            Thread t = new Thread(vol);  
            t.start();  
  
            //休眠100ms，让刚刚启动的线程有时间运行  
            Thread.sleep(100);    
            
            vol.workMethod();  
            
        } catch ( InterruptedException x ) {  
            System.err.println("one of the sleeps was interrupted");  
        }  
    }  
}  
