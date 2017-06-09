package basic;

/**
 * join()
 * @author Administrator
 *
 */
public class Join {
	public static int a = 0;  
	  
    public static void main(String[] args) throws Exception {  
        Runnable r = new Runnable(){
			public void run() {
				 for (int k = 0; k < 5; k++) {  
			            a = a + 1;  
			        }
				 System.out.println("a" + a);
			}
        };
        
        Thread t = new Thread(r);  
        t.start();   
        t.join();
        
        for (int i=0; i<1; i++) {                
            System.out.println("i=" + i);  
        }  
    }         
}
